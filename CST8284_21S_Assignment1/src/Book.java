
import java.util.regex.Pattern; //to verify the input is number

/**

 * Class Name: CST8284-300 
 * Author Name: Ming Wang 
 * Class Name: Assignment 1
 * Date:Jun 14, 2021 
 * Description: Class Book with title, author ,publicationDate, isbnNumber
 * besides the constructor and getter and setter.it include the verifyISBNNumber
 * and override toString method
 */

/**
 * This class is a book class. every book object will create and save in this class 
 * due to the teacher's instruction, only make a constructor with 4 fields of title,author,
 * publicationDate,isbnNumber
 *
 */
public class Book {

	private String title;
	private String author;
	private String publicationDate;
	private String isbnNumber;

	/**
	 * constructor with 4 fields
	 * @param title book's title
	 * @param author book's author
	 * @param publicationDate book's publication date
	 * @param isbnNumber book's isbn number
	 */
	public Book(String title, String author, String publicationDate, String isbnNumber) {
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.isbnNumber = isbnNumber;
	}
	//accessor of the title
	public String getTitle() {
		return title;
	}
	//mutator of the title
	public void setTitle(String title) {
		this.title = title;
	}
	//accessor of the author
	public String getAuthor() {
		return author;
	}
	//mutator of the author
	public void setAuthor(String author) {
		this.author = author;
	}
	//accessor of the publicationDate
	public String getPublicationDate() {
		return publicationDate;
	}
	//mutator of the publicationDate
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	//accessor of the isbnNumber
	public String getIsbnNumber() {		
		return isbnNumber;
	}
	//mutator of the IsbnNumber
	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	/**
	 * verifyISBNNumber method is used to verify the isbn number Ensures that the
	 * string is exactly 10 digits long.
	 * 
	 * @param s the isbn input by user
	 * @return true for legal isbn number
	 */

	public boolean verifyISBNNumber(String s) {
		Pattern pattern = Pattern.compile("[0-9]*");
		if ((s.length() == 10) && (pattern.matcher(s).matches())) {
			return true;
		}
		return false;
	}

	
	/**
	 * this override toString method is used to output the book's information
	 */
	@Override
	public String toString() {
		String msg = "";
		msg = "************ Title:" + getTitle() + "\n";
		msg += "************ Author:" + getAuthor() + "\n";
		msg += "************ Publication Date:" + getPublicationDate() + "\n";
		msg += "************ ISBN:" + getIsbnNumber() + "\n";

		return msg;
	}

}
