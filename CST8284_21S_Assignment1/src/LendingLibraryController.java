
import java.util.Scanner;



public class LendingLibraryController {
	
	private LendingLibrary bookLib;
	private static Scanner input = new Scanner(System.in);
	
	public LendingLibraryController() {
		
	}
	
	/**
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
		if (isValidNumber(age1)) {
			age = Integer.valueOf(age1);
		}
		
		bookLib = new LendingLibrary();
		bookLib.makeUser(1000, first, last, address, age);
	}
	
	/**
	 * The only item we can modify is the address. A user is identified by the first and last names
	 */
	public void changeUser() {
		String first = "";
		String last = "";
		String address = "";
		System.out.println("Find User");
		
		last = getResponseTo("Last name");
		first = getResponseTo("First name");
		
		bookLib = new LendingLibrary();
		
		User user = new User(first,last,address);
		user = bookLib.findUser(first, last);
		address = getResponseTo("Change address");
		user.setAddress(address);
		
		
	}
	
	/**
	 * A user will be searched by the first and last names
	 */
	public void findUser() {
		
		String first = "";
		String last = "";
		System.out.println("Find User");
		
		last = getResponseTo("Last name");
		first = getResponseTo("First name");
		
		bookLib = new LendingLibrary();
		bookLib.findUser(first, last);

	}
	public void listUser() {
		int i = 0;
		for(User user : bookLib.getUserReg()) {
			
			if(user == null) break;
				System.out.printf("User #%d\n",i+1);
				user.toString();			
				i++;
		}
				System.out.println("End of listing");

	}
	
	/**
	 * The ISBN number must be 10 digits. This must be checked and if the test fails, the entry should
     * not be added.
     * The publication date consists of the year only in 4 digits format such as 1919. The date must be
     * validated and the entry addition should abort if the test fails.
	 */
	public void addBook() {
//		Book book = new Book();
		String title = "";
		String author= "";
		String date = "";
		String isbn = "";
		String isbn1 = "";
		System.out.println("New Book Entry");
	
		title = getResponseTo("Title:");
		author = getResponseTo("Author:");
		date = getResponseTo("Publication date (year in NNNN format)");
		isbn = getResponseTo("ISBN number (10 digits):");

		Book book = new Book(title,author,date,isbn);
		bookLib = new LendingLibrary();
		bookLib.addBook(book);
		
	}
	/**
	 * A book is identified by the ISBN number. We can change the author, the title, or the publication
	 *	date. The date must be validated and the modification should abort if the validation fails.
	 */
	public void changeBook() {
		
		String isbn = "";
		String title = "";
		String author= "";
		String date = "";
		
		System.out.println("Change Book");
		
		isbn = getResponseTo("ISBN:");
		
		Book book = new Book("","","","");
		book = bookLib.findBook(isbn);
		
		
		title = getResponseTo("Change title:");
		book.setTitle(title);
		author = getResponseTo("Change author:");
		book.setAuthor(author);
		date = getResponseTo("Change publication date:");
		book.setPublicationDate(date);
		
		
		
	}
	
	/**
	 * A book is searched by the ISBN number.
	 */
	public void findBook() {
		
		String isbn = "";
	
		System.out.println("Find Book");
		
		isbn = getResponseTo("ISBN:");
		
		
		bookLib = new LendingLibrary();
		bookLib.findBook(isbn);
		
		
		
	}
	public void listBook() {
	
		int i = 0;
				
		for(Book book : bookLib.getBookReg()) {		
			if(book == null) break;
				System.out.printf("Book #%d\n",i+1);				
				book.toString();
				i++;
				
			}
				System.out.println("end of listing");
						
		}
		
		
	
	
	/**
	 * 	The book’s ISBN number, the user’s first and last names are required to create a book loan.
	 *	The entry will fail if:
	 *	● The ISBN number is invalid
	 *	● The user does not exist
	 *	● The book is already loaned
	 *	● The user has borrowed 2 books
	 */
	public void addBookLoan() {
		
		User user = new User("","","");
		Book book = new Book("","","","");
//		bookLib = new LendingLibrary();
	
		String date = "";
		System.out.println("New Loan Entry");
		user.setLastName(getResponseTo("User last name:"));
		user.setFirstName(getResponseTo("User first name:"));
		book.setIsbnNumber(getResponseTo("Book isbn number"));	
		date = getResponseTo("Loan date (format yyyy-mm-dd)");
		BookLoan bookLoan = new BookLoan(user, book, date);
		bookLib.addLoan(bookLoan);


		
	}
	
	/**
	 * A loan can be modified using the ISBN number.
		The only change allowed is the due date.
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
		for(BookLoan bookLoan : bookLib.getLoanReg()) {
			if(bookLoan == null) break;
			   System.out.printf("Book loan #%d\n",i+1);
			   bookLoan.toString();
			   i++;
		}System.out.println("end of the book loan list");
		
	}


	
	/**
	 * A helper method that prints out the String as a parameter, and then scans the input and returns
		the user’s response as a String. The purpose of the method is to make the code cleaner and
		improve code readability.We make it private as there is no need for external use.
	 * @param input
	 * @return
	 */
	private String getResponseTo(String msg) {
		
		System.out.println(msg);
		
		return input.nextLine();
	}
	
	private boolean isValidNumber(String input) {
		int i = 0;
		i = Integer.valueOf(input);
		if (i <= 0) {
			System.out.println("The age can't be zero");
			return false;
		}
		return true;
	}
	
	
	
}
