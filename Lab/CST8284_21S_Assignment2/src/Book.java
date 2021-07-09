


/**

 * Course Name: CST8284
 * Author Name: Ming Wang 
 * Class Name: 300 
 * Date:Jul 14, 2021
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
	 * @param pubDate book's publication date
	 * @param isbn book's isbn number
	 */
	public Book(String title, String author, String pubDate, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationDate = pubDate;
		this.isbnNumber = isbn;
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
	 * this override toString method is used to output the book's information
	 * @return formating String message
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
	
	/**
	 * override equals method to verify if two books are equal
	 * @return true for two books are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null && (! (obj instanceof Book))) {
			return false;
		}
		Book book = (Book) obj;
		if((getTitle().equals(book.getTitle())) 
				&& (getAuthor().equals(book.getAuthor())) 
				&& (getIsbnNumber().equals(book.getIsbnNumber()))
				&& (getPublicationDate().equals(book.getPublicationDate()))) {
			return true;
		}
		
		return false;
	
	}

}
