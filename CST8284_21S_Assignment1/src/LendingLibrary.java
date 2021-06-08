import static org.junit.Assert.assertNotNull;

/**
 * 
 * Class Name: CST8284-300 Author Name: Ming Wang Class Name: Assignment 1
 * Date:May 31, 2021
 * 
 * This class contains the implementation of all the methods that do the work of
 * prompting the user and accepting the inputs. Once the data is validated, it
 * is saved or retrieved from the LendingLibrary object as appropriate. This
 * class contains a LendingLibrary object to access or store the items in the
 * LendingLibrary. Each public method in this class corresponds to one choice
 * from the user menu. Each method will present a menu similar to the one shown
 * in the sample output and process the input to perform the required action :
 * create/modify/find/list a User/Book/BookLoan. The LendingLibraryController
 * uses the bookLib object to access the LendingLibrary object to
 * add/modify/find/list User/Book/BookLoan objects.
 * 
 * The add/find methods process the addition and searching of items in the
 * corresponding arrays.
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

	private  static Book[] bookReg = new Book[MAX_BOOK_NUMBER];
	private  static User[] userReg = new User[MAX_USER_NUMBER];
	private  static BookLoan[] loanReg = new BookLoan[MAX_LOAN_NUMBER];

	public LendingLibrary() {

	}

	public User makeUser(int id, String firstname, String lastName, String address, int age) {
		
		int index = 0;
		int count = 0;
		for (User user : userReg) {
			if (user == null) {
				index = count;
				break;
			}
			count++;
		}
		
		User user = new User("","","");
		user.setId(user.getId());
		user.setFirstName(firstname);
		user.setAddress(address);
		user.setLastName(lastName);
		user.setAge(age);
		addUser(user);
		return user; // caution

	}

	/**
	 * You need to validate that age is a number using isValidNumber
	 * 
	 * @param u
	 * @return
	 */
	public boolean addUser(User u) {
		int index = Integer.MIN_VALUE;

		LendingLibrary.setLastUserIndex(index);
		index = LendingLibrary.getLastUserIndex();

		if(index >= MAX_USER_NUMBER - 1) {
			System.err.println("reach the maximux User");
			index = MAX_USER_NUMBER -1;
			return false;
		}

		userReg[index] = u;
		userReg[index].setId(userReg[index].getId() + index);
		System.out.println("User was added");

		return true;
	}

	/**
	 * addBook method is used to add a book to bookReg array.
	 * 
	 * @param b the parameter is a Book object which is passed in
	 * @return if add a book successfully, return true. else return false
	 */
	public boolean addBook(Book b) {

		int index = Integer.MIN_VALUE;
		LendingLibrary.setLastBookIndex(index);
		index = LendingLibrary.getLastBookIndex();
		
		if (index >= MAX_BOOK_NUMBER - 1 ) { // if the bookReg array to reaching the maxmum size , 10
			System.err.println("reach to the maximun book number");
			index = MAX_BOOK_NUMBER - 1;
			return false;
		}	
		
		bookReg[index] = b; // store the new book to the last position of bookReg array
		return true; // add a new book successfully
	}

	public boolean addLoan(BookLoan l) {

		int index = Integer.MIN_VALUE;

		LendingLibrary.setLastLoanIndex(index);  //find the last index of the loan
	  index = LendingLibrary.getLastLoanIndex(); // get the last index of the loan
		
		if (index >= MAX_LOAN_NUMBER - 1) { // if the array of the loan reach the maximum length
			System.err.println("reach to maximum loan");
			index = MAX_LOAN_NUMBER - 1;  //set the index to the last index of the loan array. 
			return false;				// to prevent the program crush.
		}	

		User user1 = new User("","","");
		for (User user : userReg) {
			if(user == null) {
				System.out.println("No user with this name");
				return false;
			}
			if ((l.getUser().getFirstName().toLowerCase().equals(user.getFirstName().toLowerCase()) ) || 
				(l.getUser().getLastName().toLowerCase().equals(user.getLastName().toLowerCase()))){	
				user1 = user;
				break;					
			}

		System.out.println("No user with this name");
		return false;
		}
			
		Book book1= new Book("","","","");
		
		for(Book book : bookReg) {
			if(book == null) {
				System.out.println("Could not find a book with this isbn");
				return false;
			}

			if(l.getBook().getIsbnNumber().toLowerCase().equals(book.getIsbnNumber().toLowerCase())) {
				book1 = book;
				break;
			}
			System.out.println("Could not find a book with this isbn");
			return false;
		}
		
		if(userCanBorrow(l.getUser())) {
			
		}else if(isBookLoaned(l.getBook())){
			
		}else {			
			loanReg[index] = l;
			loanReg[index].setBook(book1); //set the finding book object to bookLoan 
			loanReg[index].setUser(user1); //set the finding user object to bookLoan
//		}
		System.out.println("Loan added");
	}
		return true;
	
}

	public User findUser(String firstName, String lastName) {
		int count = 0;
		int index = 0;
		for (User user : userReg) {
			if ((firstName.equals(user.getFirstName())) || 
				(lastName.equals(user.getLastName()))){
				index = count;
				break;					
			}
			count++;
			if(count == userReg.length) {
				System.out.println("User not found");
				return userReg[index];
			}
		}
		
		userReg[index].toString();
		return userReg[index];
	}

	/**
	 * findBook method is used to find a book by isbn number
	 * 
	 * @param isbnNumber used to find a book
	 * @return this book's location of the bookReg array.
	 */
	public Book findBook(String isbnNumber) {
		int count = 0;
		int index = -1;	

		for (Book book : bookReg) {
			if (book.getIsbnNumber().equals(isbnNumber)) {
				index = count;										
				break;
			}
			count++;
		}
		
		if (index < 0) {
			System.out.println("Could not find a book with this isbn!");
		}
		bookReg[index].toString();	
		return bookReg[index];
	}

	public BookLoan findLoan(String isbnNumber) {

		int count = 0;
		int index = -1;
		for (Book book : bookReg) {
			if (book.getIsbnNumber().equals(isbnNumber)) {
				index = count;
				break;
			}
			count++;
		}
		if (index == -1) {
			System.out.println("Could not find a book with this isbn!");
		}
		// bookReg[index];
		return null;

	}

	/**
	 * Verifies that the user has not borrowed more than 2 books
	 * 
	 * @param u
	 * @return
	 */
	public boolean userCanBorrow(User u) {
		
		int count = 0;
		for (BookLoan bookLoan: loanReg) {
			if(bookLoan == null) break;
			if(u.getId() == bookLoan.getUser().getId()) {
				count++;
			}						
		}		
		if(count < MAX_LOAN_PER_USER) {			
			return false;
		}
		System.out.println("User already load 2 book, Can not loan more");
		return true;
	}

	/**
	 * Book is loaned. Search based on ISBN number.
	 * 
	 * @param b
	 * @return
	 */
	public boolean isBookLoaned(Book b) {
		
		for(BookLoan bookLoan : loanReg) {
			if (bookLoan == null) break;
			if(bookLoan.getBook().getIsbnNumber().toLowerCase().equals(b.getIsbnNumber().toLowerCase()));{
				System.out.println("Book already loaned");
				return true;
			}
			
		}
		return false;
	}
	
	
	

	public Book[] getBookReg() {
		return bookReg;
	}

	public void setBookReg(Book[] bookReg) {
		LendingLibrary.bookReg = bookReg;
	}

	public User[] getUserReg() {
		return userReg;
	}

	public void setUserReg(User[] userReg) {
		LendingLibrary.userReg = userReg;
	}

	public BookLoan[] getLoanReg() {
		return loanReg;
	}

	public void setLoanReg(BookLoan[] loanReg) {
		LendingLibrary.loanReg = loanReg;
	}

	
	public static int getLastBookIndex() {
		return lastBookIndex;
	}

	public static void setLastBookIndex(int lastBookIndex) {

		int index = 0;
		for (Book book : bookReg) {
			if (book == null) {
				lastBookIndex = index;
				break;
			}
			index++;
		}
			
		LendingLibrary.lastBookIndex = lastBookIndex;
	}

	public static int getLastUserIndex() {
		return lastUserIndex;
	}

	public static void setLastUserIndex(int lastUserIndex) {
		
		int index = 0;
		for(User user : userReg) {
			if(user == null) {
				lastUserIndex = index;
				break;
			}
			index++;
		}
//		if(userReg.length == MAX_USER_NUMBER ) {
//			System.out.println("reach maximum user number");
//			lastUserIndex = 4;
//		}
		LendingLibrary.lastUserIndex = lastUserIndex;

	}

	public static int getLastLoanIndex() {
		return lastLoanIndex;
	}

	public static void setLastLoanIndex(int lastLoanIndex) {
		
	
		int index = 0;
		for (BookLoan bookLoan : loanReg) {
			if (bookLoan == null) {
				lastLoanIndex = index;
				break;
			}index++;
			
		}			
		
		LendingLibrary.lastLoanIndex = lastLoanIndex;
	}

	
	
	
}
