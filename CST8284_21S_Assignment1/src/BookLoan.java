/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Assignment 1
 * Date:Jun 14, 2021
 * Description: Class Book with user, book ,dueDate, 
 * besides the constructor and getter and setter.it include 
 * an override toString method
 */

/**
 * This class is a bookLoan class. every bookLoan object will create and save in this class 
 * due to the teacher's instruction, only make a constructor with 3 fields of user,book,
 * dueDate. no default instructor.
 *
 *
 */
public class BookLoan {

	private User user;
	private Book book;
	private String dueDate; 

	/**
	 * constructor with 3 fields user, book, and dueDate
	 * @param user  the user who loan a book
	 * @param book	the book is borrowed by user
	 * @param dueDate the return date of the book
	 */
	public BookLoan(User user, Book book, String dueDate) {
		this.user = user;
		this.book = book;
		this.dueDate = dueDate;

	}

	/**
	 * this override toString method is used to output the loan's information
	 */
	@Override
	public String toString() {
		String msg = "";
		msg = "************ User name:" + user.getFirstName() + " " + user.getLastName() + "\n";
		msg += "************ Title:" + book.getTitle() + "\n";
		msg += "************ Author:" + book.getAuthor() + "\n";
		msg += "************ ISBN:" + book.getIsbnNumber() + "\n";
		msg += "************ Due date:" + dueDate + "\n";
		
		return msg;
	}

	//accessor of the user
	public User getUser() {
		return user;
	}
	//mutator of the user
	public void setUser(User user) {
		this.user = user;
	}
	//accessor of the book
	public Book getBook() {
		return book;
	}
	//mutator of the book
	public void setBook(Book book) {
		this.book = book;
	}
	//accessor of the dueDate
	public String getDueDate() {
		return dueDate;
	}
	//mutator of the dueDate
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

}
