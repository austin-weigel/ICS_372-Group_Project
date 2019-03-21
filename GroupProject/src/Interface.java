import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Manages displaying command options and processing commands given by the user.
 *
 */
public class Interface {

	Organization org; // The organization to process the commands on.
	BufferedReader reader; // Input reader to get user commands and other data.

	/**
	 * Creates a new interface for the given organization.
	 * 
	 * @param org The organization to provide a Interface for.
	 */
	public Interface(Organization org) {
		this.org = org;
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Initially displays all command options. When a command is chosen it processes
	 * the command until done then calls, start(), again unless the command 0, Exit,
	 * is chosen.
	 */
	public void start() {

		printMainMenu();
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
			break;
		case 8: // Remove a credit card
			break;
		case 9: // Save the data
			break;
		case 10: // Help
			start();
			break;
		}
	}

	public Donor removeDonorUI() {
		System.out.println("Please enter donor ID");
		int id = Integer.parseInt(reader.readLine());
		return Organization.removeDonor(id);
	}

	/**
	 * Prints a list of all the command options.
	 */
	public void printMainMenu() {
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
