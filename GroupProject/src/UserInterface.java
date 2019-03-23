import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 
 * Manages displaying command options and processing commands given by the user.
 *
 */
public class UserInterface {

	private static Organization org; // The organization to process the commands on.
	private BufferedReader reader; // Input reader to get user commands and other data.
	private static UserInterface userInterface;

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
			org = new Organization();
		}
	}

	/**
	 * Method to be called for retrieving saved data. Uses the appropriate Library
	 * method for retrieval.
	 * 
	 */
	private void retrieve() {
		try {
			if (org == null) {
				org = Organization.retrieve();
				if (org != null) {
					System.out.println(
							" The organization has been successfully retrieved from the file OrganizationData \n");
				} else {
					System.out.println("File doesnt exist; creating new Organization");
					org = Organization.instance();
				}
			}
		} catch (Exception cnfe) {
			cnfe.printStackTrace();
		}
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
			break;
		case 2: // Add a creadit card
			break;
		case 3: // Process transactions
			org.processDonations();
			start();
			break;
		case 4: // List transactions
			org.printTransactions();
			start();
			break;
		case 5: // List all donors
			break;
		case 6: // List a specific donor
			break;
		case 7: // Remove a specific donor
			removeDonor();
			start();
			break;
		case 8: // Remove a credit card
			break;
		case 9: // Save the data
			save();
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

	public Donor removeDonor() {
		System.out.println("Please enter donor ID");
		int id = 0;
		try {
			id = Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			System.out.println("Donors are removed using a integer ID.");
		}
		return org.removeDonor(id);
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
}
