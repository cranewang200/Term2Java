
import java.util.Scanner;

/**
 * 
 * Class Name: CST8284-300 
 * Author Name: Ming Wang 
 * Class Name: Assignment 1
 * Date:May 31, 2021 
 * Description:This class contains the main loop of the
 * application to accept and process the user choices. It verifies the user’s
 * input and based on the selection, the relevant method to execute is called.
 *
 */

/**
 * this class include the startApp,displayAppMenu, and executeMenuItem method 
 * to interactive with user and execute the program. 
 */
public class AppDriver {
	private static final int APP_EXIT = 0;
	private static final int APP_ADD_BOOK = 1;
	private static final int APP_MOD_BOOK = 2;
	private static final int APP_FIND_BOOK = 3;
	private static final int APP_LIST_BOOK = 4;
	private static final int APP_ADD_USER = 5;
	private static final int APP_MOD_USER = 6;
	private static final int APP_FIND_USER = 7;
	private static final int APP_LIST_USER = 8;
	private static final int APP_ADD_LOAN = 9;
	private static final int APP_MOD_LOAN = 10;
	private static final int APP_FIND_LOAN = 11;
	private static final int APP_LIST_LOAN = 12;

	private static Scanner input = new Scanner(System.in);
	public LendingLibraryController appController = new LendingLibraryController();

	/**
	 * this method is used to call the displayAppMenu method 
	 * and executeMenuItem method to output the menu
	 * and execute the program.
	 */
	public void startApp() {

		boolean isContinue = true;
		int i = 0;
		while (isContinue) {
			i = displayAppMenu();

			executeMenuItem(i);

			if (i == APP_EXIT) {
				isContinue = false;
				break;
			}

		}

	}

	/**
	 * displayAppMenu is a method to output the menu to the console.
	 * Shows on the console the menu items that the user can choose from.
	 * and pass the user input to the executeMenuItem to execute the program
	 * @return a integer number for menu option
	 */
	private int displayAppMenu() {
		int inputOption = -1;
		boolean isContinue = true;
		System.out.printf("Enter a selection from the following menu:\r\n"
				+ "1. Enter a new book\r\n"
				+ "2. Modify the book details. Enter the book isbn number\r\n" 
				+ "3. Find a book by isbn number\r\n"
				+ "4. Display list of all books\r\n\n" 
				+ "5. Add a new user\r\n" 
				+ "6. Modify user details\r\n"
				+ "7. Find a user by name\r\n" 
				+ "8. Display all users\r\n\n"
				+ "9. Add a loan. Link a user name to a book by isbn number\r\n"
				+ "10. Modify a loan. Loan is identified by isbn number\r\n"
				+ "11. Find a loan. Loan is identified by isbn number\r\n" 
				+ "12. Display all loans\r\n\n"
				+ "0. Exit program");

		while (isContinue) {
			if (input.hasNextInt()) {
				inputOption = input.nextInt();
				isContinue = false;

			} else if (!input.hasNextInt()) {

				System.out.println("Please input a Integer");
				input.nextLine();
			}
		}
		input.nextLine(); // clean up the input stream
		return inputOption;
	}

	/**
	 * 
	 * executeMenuItem is a method to execute the program by user input
	 * when user input 0 .the program exits
	 * Based on the menu item chosen, it executes the action requested by the user.
	 * The AppDriver uses the appCtrl reference to call the corresponding method in
	 * LendingLibraryController
	 */
	private void executeMenuItem(int choice) {

		int inputOption = choice;
		boolean isContinue = true;

		switch (inputOption) {
		case APP_EXIT:

			System.out.println("system exiting");
			isContinue = false;
			break;
		case APP_ADD_BOOK:
			appController.addBook();
		
			break;
		case APP_MOD_BOOK:
			appController.changeBook();
		
			break;
		case APP_FIND_BOOK:
			appController.findBook();
		
			break;
		case APP_LIST_BOOK:
			appController.listBook();
		
			break;
		case APP_ADD_USER:
			appController.addUser();
			
			break;
		case APP_MOD_USER:
			appController.changeUser();
			
			break;
		case APP_FIND_USER:
			appController.findUser();
		
			break;
		case APP_LIST_USER:
			appController.listUser();
			
			break;
		case APP_ADD_LOAN:
			appController.addBookLoan();
		
			break;
		case APP_MOD_LOAN:
			appController.changeBookLoan();
		
			break;
		case APP_FIND_LOAN:
			appController.findBookLoan();
		
			break;
		case APP_LIST_LOAN:
			appController.listBookLoans();
		
			break;

		default:
			System.out.println("bad input, Please input a 0-12");
			break;

		}

	}

}
