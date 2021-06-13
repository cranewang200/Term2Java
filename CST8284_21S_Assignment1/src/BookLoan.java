
public class BookLoan {

	private User user;
	private Book book;
	private String dueDate; 

	public BookLoan(User user, Book book, String dueDate) {
		this.user = user;
		this.book = book;
		this.dueDate = dueDate;

	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

}
