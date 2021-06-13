import java.util.Scanner;

public class LendingLibraryController {

	private LendingLibrary bookLib;
	private static Scanner input = new Scanner(System.in);

	public LendingLibraryController() {

	}

	/**
	 * method addUser, to create a new user for user array
	 * after the verfication of the input, then pass the input to makeuser method
	 * You need to validate that age is a number using isValidNumber
	 */
	public void addUser() {

		String first = "";
		String last = "";
		String address = "";
		int age = 0;		

		System.out.println("New User Entry");
		last = getResponseTo("Last name:");
		first = getResponseTo("Frist name");
		address = getResponseTo("User address");
		String age1 = getResponseTo("Age");
		boolean isBadInput = true;
		
		while(isBadInput) {
			
			if (isValidNumber(age1) == true) {
				age = Integer.parseInt(age1);
				if (age < 18) {
					age = 18;
					isBadInput = false;
				}
				
				isBadInput = false;
			}else if(isValidNumber(age1) == false){
				age1 = getResponseTo("Age");
			}
		}
	

		bookLib = new LendingLibrary();
		User user = bookLib.makeUser(1000, first, last, address, age);
		boolean isAdded = bookLib.addUser(user);
		
		if(isAdded == true) {
			System.out.println("User was added");
		}else if (isAdded == false){
			System.out.println("User add failed");
		}
		
		
	}

	/**
	 * changeUser method is used to change user's address
	 * it needs to invoke the findUser method to locate the user in the array
	 * then let user to input the new address.
	 */
	public void changeUser() {
		String first = "";
		String last = "";
		String address = "";
		System.out.println("Find User");

		last = getResponseTo("Last name");
		first = getResponseTo("First name");

		bookLib = new LendingLibrary();

		User user = new User(first, last, address);
		user = bookLib.findUser(first, last);
		address = getResponseTo("Change address");
		user.setAddress(address);

	}

	/**
	 * findUser method is used to find a user in the array
	 * A user will be searched by the first and last names
	 */
	public void findUser() {

		String first = "";
		String last = "";
		System.out.println("Find User");

		last = getResponseTo("Last name");
		first = getResponseTo("First name");

		bookLib = new LendingLibrary();
		User user = bookLib.findUser(first, last);
		
		if(user == null) {
			System.out.println("User not found");
		}
		System.out.println(user.toString());
		

	}

	/**
	 * listUser method is used to list all the users in the users array.
	 * it invoke the toString method to output all the information of users
	 */
	public void listUser() {
		int i = 0;
		for (User user : bookLib.getUserReg()) {

			if (user == null)
				break;
			System.out.printf("User #%d\n", i + 1);
			System.out.println(user.toString());
			i++;
		}
		System.out.println("End of listing");

	}

	/**
	 * addBook method is used to create a new book by inputing the information
	 * after verify the input . it will pass the inputs to the LendingLibrary.addBook
	 * method to add the new book to the array
	 * 
	 * The ISBN number must be 10 digits. This must be checked and if the test
	 * fails, the entry should not be added. The publication date consists of the
	 * year only in 4 digits format such as 1919. The date must be validated and the
	 * entry addition should abort if the test fails.
	 */
	public void addBook() {
//		Book book = new Book();
		String title = "";
		String author = "";
		String date = "";
		String isbn = "";
		boolean isBadisbn = true; 
		
		System.out.println("New Book Entry");

		title = getResponseTo("Title:");
		author = getResponseTo("Author:");
		date = getResponseTo("Publication date (year in NNNN format)");
		isbn = getResponseTo("ISBN number (10 digits):");
		Book book = new Book(title, author, date, isbn);	
		
		while(isBadisbn) {
			if(book.verifyISBNNumber(isbn) == true) {
				isBadisbn = false;
			}else if(book.verifyISBNNumber(isbn) == false) {				
				isbn = getResponseTo("ISBN number (10 digits):");
			}
		}
			
		bookLib = new LendingLibrary();
		boolean isAdded = bookLib.addBook(book);
				
		if(true == isAdded ) {
			System.out.println("Book was added");
		}else if(false == isAdded) {
			System.out.println("Book add failed");
		}

	}

	/**
	 * changeUser method is used to change book's information
	 * it needs to invoke the findBook method to locate the book in the array
	 * then let user to input the new information of the book.
	 * 
	 * A book is identified by the ISBN number. We can change the author, the title,
	 * or the publication date. The date must be validated and the modification
	 * should abort if the validation fails.
	 */
	public void changeBook() {

		String isbn = "";
		String title = "";
		String author = "";
		String date = "";

		System.out.println("Change Book");
		isbn = getResponseTo("ISBN:");
		Book book = new Book("", "", "", "");
		book = bookLib.findBook(isbn);

		title = getResponseTo("Change title:");
		book.setTitle(title);
		author = getResponseTo("Change author:");
		book.setAuthor(author);
		date = getResponseTo("Change publication date:");
		book.setPublicationDate(date);
	}

	/**
	 * findBook method is used to find a book in the array
	 * A book is searched by the ISBN number.
	 */
	public void findBook() {

		String isbn = "";

		System.out.println("Find Book");

		isbn = getResponseTo("ISBN:");

		bookLib = new LendingLibrary();
		bookLib.findBook(isbn);
	
		Book book = bookLib.findBook(isbn);
		if(book == null) {
			System.out.println("Could not find a book with this isbn!");
			return;
		}else if (book != null) {
			System.out.println(book.toString());
		}

	}

	public void listBook() {

		int i = 0;

		for (Book book : bookLib.getBookReg()) {
			if (book == null)
				break;
			System.out.printf("Book #%d\n", i + 1);
			System.out.println(book.toString());
			i++;

		}
		System.out.println("end of listing");

	}

	/**
	 * The book’s ISBN number, the user’s first and last names are required to
	 * create a book loan. The entry will fail if: ● The ISBN number is invalid ●
	 * The user does not exist ● The book is already loaned ● The user has borrowed
	 * 2 books
	 */
	public void addBookLoan() {

		User user = new User("", "", "");
		Book book = new Book("", "", "", "");
//		boolean isUserExist;
//		boolean isBookExist;
		String firstName = getResponseTo("First name");
		String lastName = getResponseTo("Last name");
		String isbn = getResponseTo("ISBN");
		 
		System.out.println("New Loan Entry");
		
		user = bookLib.findUser(firstName, lastName);
		book = bookLib.findBook(isbn);	
		String date = getResponseTo("Loan date (format yyyy-mm-dd)");
		
		BookLoan bookLoan = new BookLoan(user, book, date);
		boolean isAdded = bookLib.addLoan(bookLoan);
		
		if(isAdded == true) {
			System.out.println("Loan added");
		}else if (isAdded == false) {
			System.out.println("Loan add failed!!");
		}

	}

	/**
	 * A loan can be modified using the ISBN number. The only change allowed is the
	 * due date.
	 */
	public void changeBookLoan() {

		String isbn = "";
		String date = "";
		System.out.println("Modify loan details");
		isbn = getResponseTo("ISBN number for the loan you want to modify:");

		date = getResponseTo("Change due date(Hit Enter key for no change):");
		bookLib.findLoan(isbn).setDueDate(date);

	}

	/**
	 * A loan can be searched using the ISBN number.
	 */
	public void findBookLoan() {

		String isbn = "";

		isbn = getResponseTo("Find a book loan. Enter ISBN nubmer");

		bookLib = new LendingLibrary();
		bookLib.findLoan(isbn);

	}

	public void listBookLoans() {

		int i = 0;
		for (BookLoan bookLoan : bookLib.getLoanReg()) {
			if (bookLoan == null)
				break;
			System.out.printf("Book loan #%d\n", i + 1);
			System.out.println(bookLoan.toString());
			i++;
		}
		System.out.println("end of the book loan list");

	}

	/**
	 * A helper method that prints out the String as a parameter, and then scans the
	 * input and returns the user’s response as a String. The purpose of the method
	 * is to make the code cleaner and improve code readability.We make it private
	 * as there is no need for external use.
	 * 
	 * @param input
	 * @return
	 */
	private String getResponseTo(String msg) {

		System.out.println(msg);

		return input.nextLine();
	}

	
/**
 * if the input include any non-digit element. return flase
 * @param input the user input
 * @return all elements of input is digit, return true.
 */
	private boolean isValidNumber(String input) {
		
		for(int i = 0 ; i < input.length(); i++ ) {
			if(!Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
			return true;
			
	}

}
