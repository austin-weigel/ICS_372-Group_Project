
/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * Manages displaying command options and processing commands given by the user.
 *
 */
public class UserInterface {

	private static UserInterface userInterface;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Input reader to get user
	private static Organization organization; // The organization to process the commands on.
	// commands and other data.

	public static void main(String[] args) {
		UserInterface.instance().start();
	}

	/**
	 * Creates a new interface for the given organization.
	 * 
	 * @param org The organization to provide a Interface for.
	 */

	/**
	 * Made private for singleton pattern. Conditionally looks for any saved data.
	 * Otherwise, it gets a singleton Library object.
	 * 
	 * @author Bramha Dathan
	 */
	private UserInterface() {
		if (yesOrNo("Look for saved data and  use it?")) {
			retrieve();
		} else {
			organization = Organization.instance();
		}
		help(); // Edit to print command options.
	}

	/**
	 * Supports the singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static UserInterface instance() {
		if (userInterface == null) {
			return userInterface = new UserInterface();
		} else {
			return userInterface;
		}
	}

	/**
	 * Gets a token after prompting
	 * 
	 * @param prompt - whatever the user wants as prompt
	 * @return - the token from the keyboard
	 * 
	 */
	public String getToken(String prompt) {
		do {
			try {
				System.out.println(prompt);
				String line = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
				if (tokenizer.hasMoreTokens()) {
					return tokenizer.nextToken();
				}
			} catch (IOException ioe) {
				System.exit(0);
			}
		} while (true);
	}

	/**
	 * Queries for a yes or no and returns true for yes and false for no
	 * 
	 * @author Bramha Dathan
	 * @param prompt The string to be prepended to the yes/no prompt
	 * @return true for yes and false for no
	 * 
	 */
	private boolean yesOrNo(String prompt) {
		String more = getToken(prompt + " (Y|y)[es] or anything else for no");
		if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
			return false;
		}
		return true;
	}

	/**
	 * Get a numeric value from the user. [JJS]
	 * 
	 * @param prompt The prompting string
	 * @return The integer value entered by the user
	 */
	public int promptForNumericValue(String prompt) {
		// Use a scanner to read in integers
		Scanner scan = new Scanner(System.in);

		// Prompt the user
		System.out.print(prompt);

		// Retrieve the value the user enters
		int userInput = scan.nextInt();

		// Close the scanner after use
		scan.close();

		return userInput;
	}

	/**
	 * Prints a list of all the command options.
	 */
	public static void help() {
		System.out.println("Please select a Business Process:");
		System.out.println("\t0: Exit the application");
		System.out.println("\t1: Add a donor");
		System.out.println("\t2: Add a credit card");
		System.out.println("\t3: Process donations");
		System.out.println("\t4: List all transactions");
		System.out.println("\t5: List all donors");
		System.out.println("\t6: List a specific donor");
		System.out.println("\t7: Remove a specific donor");
		System.out.println("\t8: Remove a credit card");
		System.out.println("\t9: Save the data");
		System.out.println("\t10: Help");
	}

	public void addDonor() {
		String name = getToken("Enter donor name");
		String phone = getToken("Enter phone");
		Donor result;
		result = organization.addDonor(name, phone);
		if (result == null) {
			System.out.println("Could not add member");
		}
		System.out.println(result);
	}

	public void removeDonor() {
		System.out.println("Please enter donor ID");
		int id = 0;
		try {
			id = Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			System.out.println("Donors are removed using a integer ID.");
		}
		organization.removeDonor(id);
		System.out.println("Donor has been removed.");
	}

	public void addDonation() {

		System.out.println("Please enter donor ID.");
		Donor donor = null;
		do {
			int id = 0;
			try {
				id = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				System.out.println("Credit cards are looked up using the donors integer ID.");
			}
			donor = organization.getDonor(id);
			if (donor == null) {
				System.out.println("No donor found with that donor ID.");
				if (yesOrNo("Would you like to cancel card addition?")) {
					return;
				}
			}

		} while (donor == null);

		long cardNumber = 0;
		do {
			System.out.println("Please enter credit card number.");
			try {
				cardNumber = Long.parseLong(reader.readLine());
			} catch (Exception e) {
				System.out.println("Credit cards numbers are whole integer values.");
			}
			if (cardNumber == 0) {
				System.out.println("Credit card number can not be 0.");
				if (yesOrNo("Would you like to cancel card addition?")) {
					return;
				}
			}
		} while (cardNumber == 0);

		double amount = 0;
		do {
			System.out.println("Please enter donation amount greater than 0.");
			try {
				amount = Double.parseDouble(reader.readLine());
			} catch (Exception e) {
				System.out.println("Donation amounts can be integer and decimal values.");
			}
			if (amount <= 0.0) {
				System.out.println("Donation amount can not be negative or 0.");
				if (yesOrNo("Would you like to cancel card addition?")) {
					return;
				}
			}
		} while (amount == 0);

		Donation donation = new Donation(cardNumber, amount);
		donor.addDonation(donation);
		System.out.println(donor.toString() + " added Card: " + cardNumber + " with a donation amount of " + amount);
	}

	public void processTransactions() {
		organization.processDonations();
	}

	public void listTransactions() {
		organization.printTransactions();
	}

	public void removeCreditCard() {
		System.out.println("Please enter donor ID");
		int id = 0;
		try {
			id = Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			System.out.println("Donors are removed using a integer ID.");
		}
		System.out.println("Please enter credit card");

		long cardNumber = 0;
		try {
			cardNumber = Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			System.out.println("Donors are removed using a integer ID.");
		}

		organization.removeCreditCard(id, cardNumber);
		System.out.println("Credit card has been removed.");

	}

	/**
	 * Prints all donors on file. Each donor is printed on their own line [JJS].
	 */
	public void listAllDonors() {
		for (Donor donor : organization.getAllDonors()) {
			System.out.println(donor);
		}
	}

	/**
	 * Prints a specific donor according to the donor id entered by the user. [JJS]
	 */
	public void listSpecificDonor() {
		System.out.println(organization.getDonor(promptForNumericValue("Enter donor ID\n")).getAllDonorInfo());
	}

	/**
	 * Initially displays all command options. When a command is chosen it processes
	 * the command until done then calls, start(), again unless the command 0, Exit,
	 * is chosen.
	 */
	public void start() {

		int command = -1; // Set to -1 to indicate that no valid command has been picked.

		// While there is not a valid command the system will loop and ask for a valid
		// command.
		while (command == -1) {
			String input = "";
			try {
				input = reader.readLine();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			try {
				command = Integer.parseInt(input);
				if (command < 0 || command > 10)
					throw new NumberFormatException();
			} catch (NumberFormatException nfe) {
				System.out.println("'" + input + "' is not a valid command. Please choose a command number 0-10.");
			}
		}

		// Calling the necessary methods to complete the given command then return to
		// start() unless exit is called.
		switch (command) {
		case 0: // Exit
			break;
		case 1: // Add a donor
			addDonor();
			start();
			break;
		case 2: // Add a credit card
			addDonation();
			start();
			break;
		case 3: // Process transactions
			processTransactions();
			start();
			break;
		case 4: // List transactions
			listTransactions();
			start();
			break;
		case 5: // List all donors
			listAllDonors();
			start();
			break;
		case 6: // List a specific donor
			listSpecificDonor();
			break;
		case 7: // Remove a specific donor
			removeDonor();
			start();
			break;
		case 8: // Remove a credit card
			removeCreditCard();
			start();
			break;
		case 9: // Save the data
			save();
			start();
			break;
		case 10: // Help
			help();
			start();
			break;
		}
	}

	/**
	 * Creates a save of the donors DonorList object in Organization
	 * 
	 * @author Brahma Dathan
	 */
	private void save() {
		if (Organization.save()) {
			System.out.println(" The Organization has been successfully saved in the file OrganizationData \n");
		} else {
			System.out.println(" There has been an error in saving \n");
		}
	}

	/**
	 * Method to be called for retrieving saved data. Uses the appropriate Library
	 * method for retrieval.
	 * 
	 */
	private void retrieve() {
		try {
			if (organization == null) {
				organization = Organization.retrieve();
				if (organization != null) {
					System.out.println(
							" The organization has been successfully retrieved from the file OrganizationData \n");
				} else {
					System.out.println("File doesnt exist; creating new Organization");
					organization = Organization.instance();
				}
			}
		} catch (Exception cnfe) {
			cnfe.printStackTrace();
		}
	}
}
