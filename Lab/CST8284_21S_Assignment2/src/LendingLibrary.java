import java.util.ArrayList;

/**
 * 
 * Course Name: CST8284
 * Author Name: Ming Wang 
 * Class Name: 300 
 * Date:Jul 14, 2021
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

	private static final int MAX_LOAN_PER_USER = 2;
	private  ArrayList<Book> bookReg;
	private  ArrayList<User> userReg;
	private  ArrayList<BookLoan> loanReg;

	/**
	 * Constructor of the LendingLibrary class with no parameters.
	 */
	public LendingLibrary() {
		bookReg = new ArrayList<Book>();
		userReg = new ArrayList<User>();
		loanReg = new ArrayList<BookLoan>();

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
		
		//to verify if there is a same user in userReg
		for(User user : userReg) {
			if(user.equals(u)) {
				return false;
			}
		}
		
		userReg.add(u);
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

		//to verify if there is a same Book in bookReg
		for(Book book : bookReg) {
			if(book.equals(b)) {
				return false;
			}
		}
		
		bookReg.add(b); 
		return true;
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


		if (!userCanBorrow(l.getUser())) {
			return false;
		}
		if (isBookLoaned(l.getBook())) {
			return false;
		}
		
		//to verify if there is a same loan in loanReg
		for(BookLoan bookLoan : loanReg) {
			if(bookLoan.equals(l)) {
				return false;
			}
		}

		loanReg.add(l);
		int index = loanReg.lastIndexOf(l);
		loanReg.get(index).setBook(l.getBook()); // set the finding book object to bookLoan
		loanReg.get(index).setUser(l.getUser()); // set the finding user object to bookLoan
	
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
		for (User user : userReg) {
			if(user == null) break;
			if ((firstName.toLowerCase().equals(user.getFirstName().toLowerCase())) 
					&& (lastName.toLowerCase().equals(user.getLastName().toLowerCase()))) {
				index = count;
				break;
			}
			count++;
		}
		
		if (index < 0) {
			return null;
		}
		return userReg.get(index);
	}

	/**
	 * findBook method is used to find a book by isbn number
	 * @param isbnNumber used to find a book
	 * @return the found book object in the array
	 */
	public Book findBook(String isbnNumber) {
		int count = 0;
		int index = -1;	
		for (Book book : bookReg) {
			if(book == null) break;
			if (book.getIsbnNumber().equals(isbnNumber)) {
				index = count;
				break;
			}
			count++;			
							
		}
		if (index < 0) {				
			return null ;
		}	
		return bookReg.get(index);
	}

/**	
 * findLoan method is used to find a loan the book's isbn number
 * @param isbnNumber the book's isbn number is used to find if this book is loaned
 * @return The found bookLoan object in the loanReg array.
 */
	public BookLoan findLoan(String isbnNumber) {

		int count = 0;
		int index = -1;
		for (BookLoan bookLoan : loanReg) {
			if(bookLoan == null) break;
			if (bookLoan.getBook().getIsbnNumber().equals(isbnNumber)) {
				index = count;
				break;
			}
			count++;
		}
		if (index < 0) {
			return null;
		}
		return loanReg.get(index);
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
				return true; // book already loaned
			}
		}
		return false; // book can be loan
	}

	/**
	 * Delete user method to delete a user. This method use enhanced for loop.
	 * @param firstName first name of the user
	 * @param lastName	last name of the user
	 * @return true for delete user successfully
	 */
	public boolean deleteUser(String firstName, String lastName) {
		int count = 0;
		int index = -1;
		for (User user : userReg) {
			if(user == null) break;
			if ((firstName.toLowerCase().equals(user.getFirstName().toLowerCase()))
					&& (lastName.toLowerCase().equals(user.getLastName().toLowerCase()))) {
				index = count;
				break;
			}
			count++;
		}
		// if doesn't find user
		if (index < 0) {	
			return false ;
		}	
		
		// to verify if the user loan a book. If the user in the loanReg. They can't be deleted.		
		for(BookLoan bookLoan : loanReg) {
			if(bookLoan == null) break;
			if(bookLoan.getUser().getFirstName().toLowerCase().equals(firstName.toLowerCase()) 
					&& bookLoan.getUser().getLastName().toLowerCase().equals(lastName.toLowerCase())){
				return false;
			}
		}		
		userReg.remove(index);		
		return true;
	}
	
	/**
	 * deleteBook method to delete a book.
	 * @param isbnNumber the isbn number of the book
	 * @return true for delete book successfully
	 */
	public boolean deleteBook(String isbnNumber) {

		int count = 0;
		int index = -1;
		for (Book book : bookReg) {
			if(book == null) break;
			if (isbnNumber.equals(book.getIsbnNumber())) {
				index = count;
				break;
			}
			count++;
		}
		// if doesn't find book
		if (index < 0) {	
			return false ;
		}	
		
		// to verify if the book is loaned. If the book in the loanReg. They can't be deleted.		
		for(BookLoan bookLoan : loanReg) {
			if(bookLoan == null) break;
			if(isbnNumber.equals(bookLoan.getBook().getIsbnNumber())){
				return false;
			}
		}
		bookReg.remove(index);	
		return true;
	}
	
	/**
	 * deleteBookLoan method to delete a loan.
	 * @param isbnNumber the isbn number of the loan
	 * @return true for delete loan successfully
	 */
	public boolean deleteBookLoan(String isbnNumber) {

		int count = 0;
		int index = -1;
		for (BookLoan bookLoan : loanReg) {
			if(bookLoan == null) break;
			if (isbnNumber.equals(bookLoan.getBook().getIsbnNumber())) {
				index = count;
				break;
			}
			count++;
		}
		// if doesn't find loan
		if (index < 0) {	
			return false ;
		}	

		loanReg.remove(index);
		return true;
	}
	

	/**
	 * accessor of bookReg
	 * @return arrayList of books
	 */	
	public ArrayList<Book> getBookReg() {
		return bookReg;
	}


	/**
	 * mutator of bookReg
	 * @param bookReg set the bookReg from passed in
	 */
	public void setBookReg(ArrayList<Book> bookReg) {
		this.bookReg = bookReg;
	}


	/**
	 * accessor of userReg
	 * @return array of user
	 */
	public ArrayList<User> getUserReg() {
		return userReg;
	}



	/**
	 * mutator of userReg
	 * @param userReg set the userReg from passed in
	 */
	public void setUserReg(ArrayList<User> userReg) {
		this.userReg = userReg;
	
	}

	/**
	 * accessor of loanReg
	 * @return array of loan
	 */
	public ArrayList<BookLoan> getLoanReg() {
		return loanReg;
	}

	/**
	 * mutator of loanReg
	 * @param loanReg set the loanReg from passed in
	 */
	public void setLoanReg(ArrayList<BookLoan> loanReg) {
		this.loanReg = loanReg;

	}


}
