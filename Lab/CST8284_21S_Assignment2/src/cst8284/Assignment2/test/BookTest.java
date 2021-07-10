package cst8284.Assignment2.test;
import cst8284.Assignment2.Book;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Assignment 2
 * Date:Jul 10, 2021
 * Description: jUnit test for Book class. Includes 22 test methods.
 *
 */

/**
 * 
 * For this testing class, instance 3 book objects for testing.
 */
public class BookTest {
	private final String DEFALUT_ISBN = "9781119499";
	private final String DEFALUT_TITLE = "Big Java Early Objects";
	private final String DEFALUT_AUTHOR = "Horstmann Cay";
	private final String DEFALUT_YEAR = "2018";
	
	private final String OTHER_ISBN = "1234567890";
	private final String OTHER_TITLE = "Linux OS";
	private final String OTHER_AUTHOR = "Somebody Else";
	private final String OTHER_YEAR = "2021";
	Book book1;
	Book book2;
	Book book3;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		book1 = new Book(DEFALUT_TITLE, DEFALUT_AUTHOR, DEFALUT_YEAR, DEFALUT_ISBN);
		book2 = new Book(OTHER_TITLE, OTHER_AUTHOR, OTHER_YEAR, OTHER_ISBN);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test the constructor 
	 */
	@Test
	public void testBook_True() {
		String isbn = book1.getIsbnNumber();
		String title = book1.getTitle();
		String author = book1.getAuthor();
		String date = book1.getPublicationDate();
		assertTrue(isbn.equals(DEFALUT_ISBN) && title.equals(DEFALUT_TITLE)
				&& author.equals(DEFALUT_AUTHOR) && date.equals(DEFALUT_YEAR));
	}
	
	/**
	 * Test the constructor 
	 */
	@Test
	public void testBook_False() {
		String isbn = book1.getIsbnNumber();
		String title = book1.getTitle();
		String author = book1.getAuthor();
		String date = book1.getPublicationDate();
		assertFalse(isbn.equals(OTHER_ISBN) && title.equals(OTHER_TITLE)
				&& author.equals(OTHER_AUTHOR) && date.equals(OTHER_YEAR));;
	}

	/**
	 * Test getTitle method 
	 */
	@Test
	public void testGetTitle_True() {
		String title = book1.getTitle();
		assertTrue(title.equals(DEFALUT_TITLE));
	}
	
	/**
	 * Test getTitle method 
	 */
	@Test
	public void testGetTitle_False() {
		String title = book1.getTitle();
		assertFalse(title.equals(OTHER_TITLE));
	}

	/**
	 * Test setTitle method 
	 */
	@Test
	public void testSetTitle_True() {
		book1.setTitle(DEFALUT_TITLE);
		assertTrue(book1.getTitle().equals(DEFALUT_TITLE));
	}
	
	/**
	 * Test setTitle method 
	 */
	@Test
	public void testSetTitle_False() {
		book1.setTitle(DEFALUT_TITLE);
		assertFalse(book1.getTitle().equals(OTHER_TITLE));
	}

	/**
	 * Test getAuthor method 
	 */
	@Test
	public void testGetAuthor_True() {
		String author = book1.getAuthor();
		assertTrue(author.equals(DEFALUT_AUTHOR));
	}
	
	/**
	 * Test getAuthor method 
	 */
	@Test
	public void testGetAuthor_False() {
		String author = book1.getAuthor();
		assertFalse(author.equals(OTHER_AUTHOR));
	}

	/**
	 * Test setAuthor method 
	 */
	@Test
	public void testSetAuthor_True() {
		book1.setAuthor(DEFALUT_AUTHOR);
		assertTrue(book1.getAuthor().equals(DEFALUT_AUTHOR));
	}
	
	/**
	 * Test setAuthor method 
	 */
	@Test
	public void testSetAuthor_False() {
		book1.setAuthor(DEFALUT_AUTHOR);
		assertFalse(book1.getAuthor().equals(OTHER_AUTHOR));
	}

	/**
	 * Test getPublicationDate method 
	 */
	@Test
	public void testGetPublicationDate_True() {
		String date = book1.getPublicationDate();
		assertTrue(date.equals(DEFALUT_YEAR));
	}
	
	/**
	 * Test getPublicationDate method 
	 */
	@Test
	public void testGetPublicationDate_False() {
		String date = book1.getPublicationDate();
		assertFalse(date.equals(OTHER_YEAR));
	}

	/**
	 * Test setPublicationDate method 
	 */
	@Test
	public void testSetPublicationDate_True() {
		book1.setPublicationDate(DEFALUT_YEAR);
		assertTrue(book1.getPublicationDate().equals(DEFALUT_YEAR));
	}
	
	/**
	 * Test setPublicationDate method 
	 */
	@Test
	public void testSetPublicationDate_False() {
		book1.setPublicationDate(DEFALUT_YEAR);
		assertFalse(book1.getPublicationDate().equals(OTHER_YEAR));
	}

	/**
	 * Test getIsbnNumber method 
	 */
	@Test
	public void testGetIsbnNumber_True() {
		String isbn = book1.getIsbnNumber();
		assertTrue(isbn.equals(DEFALUT_ISBN));
	}
	
	/**
	 * Test getIsbnNumber method 
	 */
	@Test
	public void testGetIsbnNumber_False() {
		String isbn = book1.getIsbnNumber();
		assertFalse(isbn.equals(OTHER_ISBN));
	}

	/**
	 * Test setIsbnNumber method 
	 */
	@Test
	public void testSetIsbnNumber_True() {
		book1.setIsbnNumber(DEFALUT_ISBN);
		assertTrue(book1.getIsbnNumber().equals(DEFALUT_ISBN));
	}
	
	/**
	 * Test setIsbnNumber method 
	 */
	@Test
	public void testSetIsbnNumber_False() {
		book1.setIsbnNumber(DEFALUT_ISBN);
		assertFalse(book1.getIsbnNumber().equals(OTHER_ISBN));
	}

	/**
	 * Test override toString method 
	 */
	@Test
	public void testToString_True() {
		
		String expect = "";
		expect = "************ Title:" + book1.getTitle() + "\n";
		expect += "************ Author:" + book1.getAuthor() + "\n";
		expect += "************ Publication Date:" + book1.getPublicationDate() + "\n";
		expect += "************ ISBN:" + book1.getIsbnNumber() + "\n";
		assertEquals(expect, book1.toString());
		
	}
	
	/**
	 * Test override toString method 
	 */
	@Test
	public void testToString_False() {
		String expect = "";
		expect = "************ Title:" + book1.getTitle() + "\n";
		expect += "************ Author:" + book1.getAuthor() + "\n";
		expect += "************ Publication Date:" + book1.getPublicationDate() + "\n";
		expect += "************ ISBN:" + book1.getIsbnNumber() + "\n";
		assertNotEquals(expect, book2.toString());
	}

	/**
	 * Test override equals method 
	 */
	@Test
	public void testEqualsObject_True() {
		book3 = new Book(DEFALUT_TITLE, DEFALUT_AUTHOR, DEFALUT_YEAR, DEFALUT_ISBN);
		assertEquals(book1, book3);
	}
	
	/**
	 * Test override equals method 
	 */
	@Test
	public void testEqualsObject_False() {
		assertNotEquals(book1, book2);;
	}

}
