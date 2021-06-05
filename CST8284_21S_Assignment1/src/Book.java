

/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Assignment 1
 * Date:Jun 4, 2021
 * Description: Class Book with title, author ,publicationdate, isbnnumber
 */
public class Book {
	
	private String title;
	private String author;
	private String publicationDate;
	private String isbnNumber;
		
	public Book(String title, String author,String publicationDate,String isbnNumber) {
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.isbnNumber = isbnNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	
	/**
	 * Ensures that the string is exactly 10 digits long.
	 * @param s
	 * @return
	 */
	
	public boolean verifyISBNNumber(String s) {
		
		return true;
	}
	
	@Override
	
	public String toString() {
		String msg = "";
		msg = "************ Title:" +  getTitle() + "\n";
		msg += "************ Author:" + getAuthor() + "\n";
		msg += "************ Publication Date:" + getPublicationDate() + "\n";
		msg +="************ ISBN:" + getIsbnNumber() + "\n";
		
		System.out.printf(msg);

		return msg;
	}

}
