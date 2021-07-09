import java.util.Scanner;
import java.util.regex.Pattern;  //to verify the input is digital number

/**
 * 
 * Course Name: CST8284
 * Author Name: Ming Wang 
 * Class Name: 300 
 * Date:Jul 14, 2021
 * This class is the controller of  the program. it interactive with user for 
 * data input and output. then pass and control the data to other method.
 */

/**
 * this class include 4 methods (add, change, find ,and list method)for 
 * each book, user, and loan object. 
 * also it has isValidNumber and getResponseTo method to interactive with user
 * and to veryfy the isbn number is legal.
 */
public class LendingLibraryController {
	private final int DEFAULT_AGE = 18;
	private final int BOOK_DATE = 4;
	private final int LOAN_DATE = 8;
	private final int ISBN_LENGHT = 10 ;
	private LendingLibrary bookLib;
	private Book book;
	private static Scanner input = new Scanner(System.in);
	
	public LendingLibraryController() {
		bookLib = new LendingLibrary();
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
		//to verify if the age is lesser than 18
		while(isBadInput) {			
			if (isValidNumber(age1) == true) {
				age = Integer.parseInt(age1);
				if (age < DEFAULT_AGE) {
					age = DEFAULT_AGE;
					isBadInput = false;
				}				
				isBadInput = false;
			}else if(isValidNumber(age1) == false){
				age1 = getResponseTo("Age");
			}
		}	
		
		User user = new User(first, last, address, age);
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

		User user= bookLib.findUser(first, last);
		// to verify the if the user exist
		if(bookLib.findUser(first, last) != null) {			
			System.out.println(user.toString());
		}else {
			System.out.println("User not found");
			return;
		}
		//user exist, then change address
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


		User user=  bookLib.findUser(first, last);
		//to look for the user by first name and last name
		if(bookLib.findUser(first, last) != null) {
			System.out.println(user.toString());
		}else {
			System.out.println("User not found");
			return;
		}
	}

	/**
	 * listUser method is used to list all the users in the users array.
	 * it invoke the toString method to output all the information of users
	 */
	public void listUser() {
		int i = 0;
		if(bookLib == null) return; //if the bookLib object is null then return, in case program crash
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
		String title = "";
		String author = "";
		String date = "";
		String isbn = "";
		boolean isBadisbn = true; 	
		book = new Book(title, author, date, isbn);
		System.out.println("New Book Entry");

		title = getResponseTo("Title:");
		author = getResponseTo("Author:");
		date = getResponseTo("Publication date (year in NNNN format)");
		// to verify the data is 4 digits
//		Pattern pattern = Pattern.compile("[0-9]*");
		boolean isBadDate = true;
		while(isBadDate) {
			if((date.length() == BOOK_DATE) && isValidNumber(date)) {//call isValidNumber method to verify the numbers				
				isBadDate = false;
			}else {
				date = getResponseTo("Publication date (year in NNNN format)");
			}			
		}
		// to verify the isbn is 10 digits	
		isbn = getResponseTo("ISBN number (10 digits):");
		while(isBadisbn) {
			if(verifyISBNNumber(isbn) == true) {		
				isBadisbn = false;
			}else if(verifyISBNNumber(isbn) == false) {				
				isbn = getResponseTo("ISBN number (10 digits):");
			}
		}
		//end of verification
		book.setAuthor(author);
		book.setIsbnNumber(isbn);
		book.setPublicationDate(date);
		book.setTitle(title);
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
		boolean isBadisbn = true; 

		// to verify the isbn number user want to search		
		while(isBadisbn) {
			if(verifyISBNNumber(isbn) == true) {
				 book = bookLib.findBook(isbn);
				isBadisbn = false;
			}else if(verifyISBNNumber(isbn) == false) {				
				isbn = getResponseTo("ISBN number (10 digits):");
			}
		}		
		//to verify if book exists, then change the information of book
		if(bookLib.findBook(isbn) != null) {	// found book exists, change the information		
			title = getResponseTo("Change title:");
			book.setTitle(title);
			author = getResponseTo("Change author:");
			book.setAuthor(author);
			date = getResponseTo("Change publication date:");
			
			// use isValidNumber method to verify the date input is 4 digits	
			boolean isBadDate = true;
			while(isBadDate) {
				if((date.length() == BOOK_DATE) && isValidNumber(date)) {
					
					isBadDate = false;
				}else {
					date = getResponseTo("Publication date (year in NNNN format)");
				}			
			}
			//	end of verification		
			book.setPublicationDate(date);
		}else {	//book not found, renturn
		System.out.println("Can't find the book");
		return;
		}
	}

	/**
	 * findBook method is used to find a book in the array
	 * A book is searched by the ISBN number.
	 */
	public void findBook() {
	
		String isbn = "";
		System.out.println("Find Book");
		isbn = getResponseTo("ISBN number (10 digits):");
		boolean isBadisbn = true;		
		while(isBadisbn) {
			if(verifyISBNNumber(isbn) == true) {
				book = bookLib.findBook(isbn);
				isBadisbn = false;
			}else if(verifyISBNNumber(isbn) == false) {				
				isbn = getResponseTo("ISBN number (10 digits):");
			}
		}

		if(bookLib.findBook(isbn) != null) {
			System.out.println(book.toString());
		}else{
			System.out.println("Could not find a book with this isbn!");
			return;
		}
		
	}
	/**
	 * listBook method is used to output all the books in the bookReg array
	 */
	public void listBook() {
		int i = 0;		
		if(bookLib == null) return; //if the bookLib object is null then return, in case program crash
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
	 * addBookLoan method is used to create a new loan , after the verification
	 * it will pass the information of the loan to LendingLibrary. addBookLoan
	 * method. to add the new loan object to the book loan array.
	 * 
	 * The book’s ISBN number, the user’s first and last names are required to
	 * create a book loan. The entry will fail if: ● The ISBN number is invalid ●
	 * The user does not exist ● The book is already loaned ● The user has borrowed
	 * 2 books
	 */
	public void addBookLoan() {

		System.out.println("New Loan Entry");
		String firstName = getResponseTo("First name");
		String lastName = getResponseTo("Last name");
		String isbn = getResponseTo("ISBN");	
		User user = bookLib.findUser(firstName, lastName);
		
		boolean isBadisbn = true;
		//verify the isbn number
		while(isBadisbn) {
			if(verifyISBNNumber(isbn) == true) {
				book = bookLib.findBook(isbn);
				isBadisbn = false;
			}else if(verifyISBNNumber(isbn) == false) {				
				isbn = getResponseTo("ISBN number (10 digits):");
			}
		}
		
		if(user == null || book == null) {
			System.out.println("Book or User not found, Add loan failed");
			return ;
		}else {
		
		String date = getResponseTo("Loan date (format yyyymmdd)");
		//verify the date is 8 digits		
		boolean isBadDate = true;
		while(isBadDate) {
			if((date.length() == LOAN_DATE) && isValidNumber(date)) {				
				isBadDate = false;
			}else {
				date = getResponseTo("Loan date (format yyyymmdd)");
			}			
		}
		
		BookLoan bookLoan = new BookLoan(user, book, date);
		boolean isAdded = bookLib.addLoan(bookLoan);
		
		if(isAdded == true) {
			System.out.println("Loan added");
		}else if (isAdded == false) {
			System.out.println("Loan add failed!!");
		}
	  }
	}

	/**
	 * changeBookLoan method is used to change the loan's due date
	 * A loan can be modified using the ISBN number. 
	 */
	public void changeBookLoan() {		
		String isbn = "";
		String date = "";
		System.out.println("Modify loan details");
		isbn = getResponseTo("ISBN number for the loan you want to modify:");

		BookLoan bookLoan = null;
		boolean isBadisbn = true;		
		while(isBadisbn) {
			if(verifyISBNNumber(isbn) == true) {
				bookLoan = bookLib.findLoan(isbn);
				isBadisbn = false;
			}else if(verifyISBNNumber(isbn) == false) {				
				isbn = getResponseTo("ISBN number (10 digits):");
			}
		}			
		//to find the loan
		if(bookLib.findLoan(isbn) != null) {
			System.out.println(bookLoan.toString());
		}else {
			System.out.println("Could not find a loan with this ISBN");
			return;
		}
	
		//to verify the date is correct
		date = getResponseTo("Change due date(Hit Enter key for no change):");
		if(date.equals("")) {
			bookLib.findLoan(isbn).setDueDate(bookLib.findLoan(isbn).getDueDate());
		}else if((date.length() == LOAN_DATE) && isValidNumber(date)){
			bookLib.findLoan(isbn).setDueDate(date);
		}
	
	}

	/**
	 * findBookLoan method is used to find a loan in the loan array
	 * and output the found information to the console.
	 * A loan can be searched using the ISBN number.
	 */
	public void findBookLoan() {		
		String isbn = "";
		isbn = getResponseTo("Find a book loan. Enter ISBN nubmer");
		BookLoan bookLoan = null;
		boolean isBadisbn = true;	
		
		//to verify the isbn is 10 digits
		while(isBadisbn) {
			if(verifyISBNNumber(isbn) == true) {
				bookLoan = bookLib.findLoan(isbn);
				isBadisbn = false;
			}else if(verifyISBNNumber(isbn) == false) {				
				isbn = getResponseTo("ISBN number (10 digits):");
			}
		}
		
		//to check if find the loan
		if(bookLoan == null) {
			System.out.println("Could not find a book with this isbn!");
			return;
		}else if (bookLoan != null) {
			System.out.println(bookLoan.toString());
		}
	}
	
	/**
	 * listBookLoans method is used to output all the loans in the loan array
	 */
	public void listBookLoans() {
		int i = 0;
		if(bookLib == null) return;//if the bookLib object is null then return, in case program crash
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
	 * 
	 * deleteBook method to delete a book. This method can interactive with user
	 * to get the isbn number to pass it to LendingLibrary.deleteBook method, Then 
	 * output the result to users.
	 */
	
	public void deleteBook() {
		String isbnNumber = "";
		isbnNumber = getResponseTo("Delete book, Enter the ISBN number");

		//to verify the isbn input
		boolean isBadIsbn = true;		
		while (isBadIsbn) {
			if(verifyISBNNumber(isbnNumber)) {				
				isBadIsbn = false;
			}else if(!verifyISBNNumber(isbnNumber)) {
				isbnNumber = getResponseTo("Delete Book, Enter the ISBN number");
			}
			
		}
		
		
		boolean isDeleted = bookLib.deleteBook(isbnNumber);
		if(isDeleted) {
			System.out.printf("Book %s\t deleted!\n",isbnNumber);
		}else {
			System.out.printf("Book %s\t delete failed\n",isbnNumber);
		}
		
		
		
	}
	

	/**
	 * 
	 * deleteBook method to delete a user. This method can interactive with user
	 * to get the frist name and last name  to pass it to LendingLibrary.deleteUser method, Then 
	 * output the result to users.
	 */
	
	public void deleteUser() {
		String firstName = "";
		String lastName = "";
		firstName = getResponseTo("Delete user. Enter the first name");
		lastName = getResponseTo("Delete user. Enter the Last name");
		boolean isDeleted = bookLib.deleteUser(firstName, lastName);
		
		if(isDeleted) {
			System.out.printf("User %s\t%s deleted!\n",firstName,lastName);
		}else {
			System.out.printf("User %s\t%s delete failed\n",firstName,lastName);
		}
		
		
	}
	

	/**
	 * 
	 * deleteBook method to delete a book loan. This method can interactive with user
	 * to get the frist name and last name  to pass it to LendingLibrary.deleteUser method, Then 
	 * output the result to users.
	 */
	public void deleteBookLoan() {
		
		String isbnNumber = "";
		isbnNumber = getResponseTo("Delete Loan, Enter the ISBN number");
		
		//to verify the isbn input
		boolean isBadIsbn = true;		
		while (isBadIsbn) {
			if(verifyISBNNumber(isbnNumber)) {				
				isBadIsbn = false;
			}else if(!verifyISBNNumber(isbnNumber)) {
				isbnNumber = getResponseTo("Delete Loan, Enter the ISBN number");
			}
			
		}
	
		
		boolean isDeleted = bookLib.deleteBookLoan(isbnNumber);
		if(isDeleted) {
			System.out.printf("Loan %s\t deleted!\n",isbnNumber);
		}else {
			System.out.printf("Loan %s\t delete failed\n",isbnNumber);
		}
		
		
	
	}

	
	
	/**
	 * 
	 * getResponseTo is a helper method that interactive with user, and then scans the
	 * input and returns the user’s response as a String. The purpose of the method
	 * is to make the code cleaner and improve code readability.We make it private
	 * as there is no need for external use.
	 * 
	 * @param msg  the message passed from other method
	 * @return scanner wating for user input
	 */
	
	private String getResponseTo(String msg) {
		System.out.println(msg);
		return input.nextLine();
	}

	
/**
 * isValidNumber is used to verify the isbn number if it's number
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
	
	
	/**
	 * This method is used to verify the input of isbn is correct
	 * @param n The string input for isbn from user 
	 * @return
	 */
	private boolean verifyISBNNumber(String n) {
		Pattern pattern = Pattern.compile("[0-9]*");
		if ((n.length() == ISBN_LENGHT) && (pattern.matcher(n).matches())) {
			return true;
		}
		return false;
	}


}
