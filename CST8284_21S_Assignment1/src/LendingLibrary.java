/**
 * 
 * Class Name: CST8284-300 
 * Author Name: Ming Wang 
 * Class Name: Assignment 1
 * Date:Jun 14, 2021
 * Description: This class contains the implementation of all the methods that do the work of
 * prompting the user and accepting the inputs. Once the data is validated, it
 * is saved or retrieved from the LendingLibrary object as appropriate. This
 * class contains a LendingLibrary object to access or store the items in the
 * LendingLibrary. Each public method in this class corresponds to one choice
 * from the user menu. Each method will present a menu similar to the one shown
 * in the sample output and process the input to perform the required action
 *
 */

/**
 * This class includes addUser, addBook, addLoan, findUser, findBook, findLoan, 
 * userCanBorrow, isBookLoaned methods. and its getters and setters. and a defalut
 * constructor. 
 * This class is used to operate the objects in the array.
 *
 */
public class LendingLibrary {

	private static final int MAX_BOOK_NUMBER = 10;
	private static final int MAX_USER_NUMBER = 5;
	private static final int MAX_LOAN_NUMBER = 5;
	private static final int MAX_LOAN_PER_USER = 2;

	private static int lastBookIndex;
	private static int lastUserIndex;
	private static int lastLoanIndex;

	private static Book[] bookReg = new Book[MAX_BOOK_NUMBER];
	private static User[] userReg = new User[MAX_USER_NUMBER];
	private static BookLoan[] loanReg = new BookLoan[MAX_LOAN_NUMBER];

	public LendingLibrary() {

	}

	/**
	 * makeUser method is to accept the inputs from LendingLibraryController.addUser method
	 * then create a new user and pass it to let the addUser method to use.
	 * @param id user id
	 * @param firstname user first name
	 * @param lastName user last name
	 * @param address user address
	 * @param age	user age, default age = 18
	 * @return a new user object
	 */
	
	public User makeUser(int id, String firstname, String lastName, String address, int age) {

		User user = new User("", "", "");
		user.setId(user.getId());
		user.setFirstName(firstname);
		user.setAddress(address);
		user.setLastName(lastName);
		user.setAge(age);
		return user; 

	}

	/**
	 * addUser method is used to add a new user to the users array.
	 * it will invoke the setLastUserIndex and getLastUserIndex method
	 * to locate the next vacant index in the array. 
	 * then verify if the array has space to save new user
	 * after verify, it will save the new user object to the users array. 
	 
	 * @param u object user passed from makeUser method
	 * @return true for adding user successfully.
	 */
	public boolean addUser(User u) {
		int index = Integer.MIN_VALUE;
		LendingLibrary.setLastUserIndex(index);
		index = LendingLibrary.getLastUserIndex();

		userReg[index] = u;
		userReg[index].setId(userReg[index].getId() + index);
		return true;
	}

	/**
	 * addBook method is used to add a book to the bookReg array.
	 * it will invoke the setLastBookIndex and getLastBookIndex method
	 * to locate the next vacant index in the array. 
	 * then verify if the array has space to save new book
	 * after verify, it will save the new book object to the books array.
	 * @param b the parameter is a Book object which is passed from LendingLibraryController.addBook method
	 * @return if add a book successfully, return true. else return false
	 */
	public boolean addBook(Book b) {

		int index = Integer.MIN_VALUE;
		LendingLibrary.setLastBookIndex(index);
		index = LendingLibrary.getLastBookIndex();
		// to verify that the isbn of two books can not be same
		for (Book book : bookReg) {
			if( book == null) break;
			if(book.getIsbnNumber().equals(b.getIsbnNumber())) {
				return false;
			}
		}

		bookReg[index] = b; // store the new book to the last position of bookReg array
		return true; // add a new book successfully
	}

	/**
	 * addLoan method is used to add a loan to the bookLoan array.
	 * it will invoke the setLastLoanIndex and getLastLoanIndex method
	 * to locate the next vacant index in the array. 
	 * then verify if the array has space to save new loan
	 * after verify, it will save the new loan object to the bookLoan array.
	 * @param l the parameter is a new bookLoan object which is passed from LendingLibraryController.addLoan method
	 * @return if add a bookLoan successfully, return true. else return false
	 */	
	public boolean addLoan(BookLoan l) {

		int index = Integer.MIN_VALUE;
		LendingLibrary.setLastLoanIndex(index); // find the last index of the loan
		index = LendingLibrary.getLastLoanIndex(); // get the last index of the loan

		if (!userCanBorrow(l.getUser())) {
			return false;
		}
		if (isBookLoaned(l.getBook())) {
			return false;
		}
			
		loanReg[index] = l;
		loanReg[index].setBook(l.getBook()); // set the finding book object to bookLoan
		loanReg[index].setUser(l.getUser()); // set the finding user object to bookLoan
	
		return true;
	}

	/**
	 * findUser method is used to find a user by the first name and last name
	 * @param firstName user's first name
	 * @param lastName	user's last name
	 * @return the found user object in the array
	 */
	public User findUser(String firstName, String lastName) {
		int count = 0;
		int index = -1;
		User user1 = new User(null, null, null);
		for (User user : userReg) {
			if(user == null) break;
			if ((firstName.toLowerCase().equals(user.getFirstName().toLowerCase())) && (lastName.toLowerCase().equals(user.getLastName().toLowerCase()))) {
				index = count;
				break;
			}
			count++;
		}
		
		if (index < 0) {
			return user1 = null;
		}
		return userReg[index];
	}

	/**
	 * findBook method is used to find a book by isbn number
	 * @param isbnNumber used to find a book
	 * @return the found book object in the array
	 */
	public Book findBook(String isbnNumber) {
		int count = 0;
		int index = -1;	
		Book book1 = new Book("", "", "", "");

		for (Book book : bookReg) {
			if(book == null) break;
			if (book.getIsbnNumber().equals(isbnNumber)) {
				index = count;
				break;
			}
			count++;			
							
		}
		if (index < 0) {	
			book1 = null;
			return book1 ;
		}	
		return bookReg[index];
	}

/**	
 * findLoan method is used to find a loan the book's isbn number
 * @param isbnNumber the book's isbn number is used to find if this book is loaned
 * @return The found bookLoan object in the loanReg array.
 */
	public BookLoan findLoan(String isbnNumber) {

		int count = 0;
		int index = -1;
		BookLoan bookLoan1 = new BookLoan(null, null, null);
		for (BookLoan bookLoan : loanReg) {
			if(bookLoan == null) break;
			if (bookLoan.getBook().getIsbnNumber().equals(isbnNumber)) {
				index = count;
				break;
			}
			count++;
		}
		if (index < 0) {
			return bookLoan1 = null;
		}
		return loanReg[index];
	}

	/**
	 * this method to verifies that the user has not borrowed more than 2 books
	 * @param u user object passed from addLoan method
	 * @return true for user can borrow books.
	 */
	public boolean userCanBorrow(User u) {

		int count = 0;
		for (BookLoan bookLoan : loanReg) {
			if (bookLoan == null)
				break;
			if (u.getId() == bookLoan.getUser().getId()) {
				count++;
			}
		}
		if (count >= MAX_LOAN_PER_USER) {
			
			return false; // user can not borrow
		} else {
			return true; // user can borrow
		}

	}

	/**
	 * this method is used for verify if the book already loaned.
	 * 
	 * @param b book object passed from addLoan method
	 * @return true for book already borrowed from others. can't borrow
	 */
	public boolean isBookLoaned(Book b) {

		for (BookLoan bookLoan : loanReg) {
			if (bookLoan == null)
				break;
			if (bookLoan.getBook().getIsbnNumber().toLowerCase().equals(b.getIsbnNumber().toLowerCase())) {
				System.out.println("Book already loaned");
				return true; // book already loaned
			}
		}
		return false; // book can be loan
	}

	/**
	 * accessor of bookReg
	 * @return array of books
	 */
	public Book[] getBookReg() {
		return bookReg;
	}

	/**
	 * mutator of bookReg
	 * @param bookReg set the bookReg from passed in
	 */
	public void setBookReg(Book[] bookReg) {
		LendingLibrary.bookReg = bookReg;
	}

	/**
	 * accessor of userReg
	 * @return array of user
	 */
	public User[] getUserReg() {
		return userReg;
	}

	/**
	 * mutator of userReg
	 * @param userReg set the userReg from passed in
	 */
	public void setUserReg(User[] userReg) {
		LendingLibrary.userReg = userReg;
	}

	/**
	 * accessor of loanReg
	 * @return array of loan
	 */
	public BookLoan[] getLoanReg() {
		return loanReg;
	}

	/**
	 * mutator of loanReg
	 * @param loanReg set the loanReg from passed in
	 */
	public void setLoanReg(BookLoan[] loanReg) {
		LendingLibrary.loanReg = loanReg;
	}

	/**
	 * accessor of the lastBookIndex
	 * @return last vacant space in the book array
	 */
	public static int getLastBookIndex() {
		return lastBookIndex;
	}

	/**
	 * mutator of lastBookIndex to find the next vacant space in the book array
	 * @param lastBookIndex the last vacant space index of the book array
	 */
	public static void setLastBookIndex(int lastBookIndex) {

		int index = 0;
		for (Book book : bookReg) {
			if(index < bookReg.length - 1) {
			if (book == null) {
				lastBookIndex = index;
				break;
			}
			index++;
		    }else {
			lastBookIndex = bookReg.length - 1;
			break;
		}
	    }
			

		LendingLibrary.lastBookIndex = lastBookIndex;
	}

	/**
	 * accessor of the lastUser index
	 * @return last vacant space in the user array
	 */
	public static int getLastUserIndex() {
		return lastUserIndex; 
	}

	/**
	 * mutator of lastUserIndex, to find the next vacant space in the user array
	 * @param lastUserIndex last vacant space in the user array
	 */
	public static void setLastUserIndex(int lastUserIndex) {
		
		int index = 0;
		for (User user : userReg) {
			
			if(index < userReg.length - 1) {
			if (user == null ) {
				lastUserIndex = index;
				break;
			}		
			index++;
			}else {
				lastUserIndex = userReg.length - 1;
				break;
			}						
		}
		LendingLibrary.lastUserIndex = lastUserIndex;
		
	}

	/**
	 * accessor of the lastLoanIndex
	 * @return last vacant space in the loan array
	 */
	public static int getLastLoanIndex() {
		return lastLoanIndex;
	}

	
	/**
	 * mutator of the lastLoanIndex. to find the next vacant space in the loan array
	 * @param lastLoanIndex lastUserIndex last vacant space in the loan array
	 */
	public static void setLastLoanIndex(int lastLoanIndex) {

		int index = 0;
		for (BookLoan bookLoan : loanReg) {
			
			if(index < loanReg.length - 1) {
			if (bookLoan == null) {
				lastLoanIndex = index;
				break;
			}
			index++;

		}else {
			lastLoanIndex = loanReg.length - 1;
			break;
		}
		
		}

		LendingLibrary.lastLoanIndex = lastLoanIndex;
	}

}
