/**
 * 
 * Course Name: CST8284
 * Author Name: Ming Wang 
 * Class Name: 300 
 * Date:Jul 14, 2021
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
	 *@return formating String message
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
	
	/**
	 * override equals method to verify if two loans are equal
	 * @return true for two loans are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null && (! (obj instanceof BookLoan))) {
			return false;
		}
		BookLoan bookLoan = (BookLoan) obj;
		if((getBook().equals(bookLoan.getBook())) 
				&& (getUser().equals(bookLoan.getUser())) 
				&& (getDueDate().equals(bookLoan.getDueDate()))) {
			return true;
		}
		
		return false;
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
