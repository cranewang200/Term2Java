package cst8284.Assignment2.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst8284.Assignment2.Book;
import cst8284.Assignment2.BookLoan;
import cst8284.Assignment2.User;
/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Assignment 2
 * Date:Jul 10, 2021
 * Description: jUnit test for BookLoan class. Includes 17 test methods.
 *
 */


/**
 * 
 * For this testing class, instance 2 book objects, 
 * 2 User objects and 3 bookLoan objects for testing.
 */
public class BookLoanTest {

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
//	Book book3;
	
	private final String DEFAULT_FIRST = "Mike";
	private final String DEFAULT_LAST = "Jodan";
	private final String DEFAULT_ADDRESS = "1234 Ottawa street";
	private final int DEFAULT_AGE = 22;
	private final int DEFAULT_ID = 1000;
	
	private final String OTHER_FIRST = "Harry";
	private final String OTHER_LAST = "Porter";
	private final String OTHER_ADDRESS = "5678 Toronto street";
	private final int OTHER_AGE = 55;
	private final int OTHER_ID = 2000;
	
	User user1;
	User user2;
//	User user3;
	
	
	private final String DEFAULT_DUE_DATE = "20210101";
	private final String OTHER_DUE_DATE = "20220202";
	BookLoan loan1;
	BookLoan loan2;
	BookLoan loan3;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user1 = new User(DEFAULT_ID, DEFAULT_FIRST, DEFAULT_LAST, DEFAULT_ADDRESS, DEFAULT_AGE);
		user2 = new User(OTHER_ID, OTHER_FIRST, OTHER_LAST, OTHER_ADDRESS, OTHER_AGE);
		
		book1 = new Book(DEFALUT_TITLE, DEFALUT_AUTHOR, DEFALUT_YEAR, DEFALUT_ISBN);
		book2 = new Book(OTHER_TITLE, OTHER_AUTHOR, OTHER_YEAR, OTHER_ISBN);
		
		loan1 = new BookLoan(user1, book1, DEFAULT_DUE_DATE);
		loan2 = new BookLoan(user2, book2, OTHER_DUE_DATE);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test the constructor 
	 */
	@Test
	public void testBookLoan_True() {
		User user = loan1.getUser();
		Book book = loan1.getBook();
		String dueDate = loan1.getDueDate();
		
		assertTrue(user.equals(user1) 
				&& book.equals(book1) 
				&& dueDate.equals(DEFAULT_DUE_DATE));
	}
	
	/**
	 * Test the constructor 
	 */
	public void testBookLoan_Flase() {
		User user = loan1.getUser();
		Book book = loan1.getBook();
		String dueDate = loan1.getDueDate();
		
		assertFalse(user.equals(user2) 
				&& book.equals(book2) 
				&& dueDate.equals(OTHER_DUE_DATE));
	}

	/**
	 * Test override toString method 
	 */
	@Test
	public void testToString_True() {
		String expect = "";
		expect = "************ User name:" + user1.getFirstName() + " " + user1.getLastName() + "\n";
		expect += "************ Title:" + book1.getTitle() + "\n";
		expect += "************ Author:" + book1.getAuthor() + "\n";
		expect += "************ ISBN:" + book1.getIsbnNumber() + "\n";
		expect += "************ Due date:" + DEFAULT_DUE_DATE + "\n";
		
		assertEquals(expect, loan1.toString());
	}

	/**
	 * Test override toString method 
	 */
	@Test
	public void testToString_False() {
		String expect = "";
		expect = "************ User name:" + user1.getFirstName() + " " + user1.getLastName() + "\n";
		expect += "************ Title:" + book1.getTitle() + "\n";
		expect += "************ Author:" + book1.getAuthor() + "\n";
		expect += "************ ISBN:" + book1.getIsbnNumber() + "\n";
		expect += "************ Due date:" + DEFAULT_DUE_DATE + "\n";
		
		assertNotEquals(expect, loan2.toString());
	}
	
	/**
	 * Test override equals method 
	 */
	@Test
	public void testEqualsObject_True() {
		loan3 = new BookLoan(user1, book1, DEFAULT_DUE_DATE);
		assertEquals(loan3, loan1);
	}

	/**
	 * Test override equals method 
	 */
	@Test
	public void testEqualsObject_False() {
		assertNotEquals(loan2, loan1);
	}	
	
	/**
	 * Test getUser method 
	 */
	@Test
	public void testGetUser_True() {
		User user = loan1.getUser();
		assertEquals(user, user1);
	}
	
	/**
	 * Test getUser method 
	 */
	@Test
	public void testGetUser_False() {
		User user = loan1.getUser();
		assertNotEquals(user, user2);
	}

	/**
	 * Test setUser method 
	 */
	@Test
	public void testSetUser_True() {
		loan1.setUser(user1);
		assertEquals(loan1.getUser(), user1);
	}
	
	/**
	 * Test setUser method 
	 */
	@Test
	public void testSetUser_False() {
		loan1.setUser(user1);
		assertNotEquals(loan1.getUser(), user2);
	}

	/**
	 * Test getBook method 
	 */
	@Test
	public void testGetBook_True() {
		Book book = loan1.getBook();
		assertEquals(book, book1);
	}

	/**
	 * Test getBook method 
	 */
	@Test
	public void testGetBook_False() {
		Book book = loan1.getBook();
		assertNotEquals(book, book2);
	}

	/**
	 * Test setBook method 
	 */
	@Test
	public void testSetBook_True() {
		loan1.setBook(book1);
		assertEquals(loan1.getBook(), book1);
	}

	/**
	 * Test setBook method 
	 */
	@Test
	public void testSetBook_False() {
		loan1.setBook(book1);
		assertNotEquals(loan1.getBook(), book2);
	}

	/**
	 * Test getDueDate method 
	 */
	@Test
	public void testGetDueDate_True() {
		String dueDate = loan1.getDueDate();
		assertEquals(dueDate, DEFAULT_DUE_DATE);
	}
	
	/**
	 * Test getDueDate method 
	 */
	@Test
	public void testGetDueDate_False() {
		String dueDate = loan1.getDueDate();
		assertNotEquals(dueDate, OTHER_DUE_DATE);
	}

	/**
	 * Test setDueDate method 
	 */
	@Test
	public void testSetDueDate_True() {
		loan1.setDueDate(DEFAULT_DUE_DATE);
		assertEquals(loan1.getDueDate(), DEFAULT_DUE_DATE);
	}
	
	/**
	 * Test setDueDate method 
	 */
	@Test
	public void testSetDueDate_False() {
		loan1.setDueDate(DEFAULT_DUE_DATE);
		assertNotEquals(loan1.getDueDate(), OTHER_DUE_DATE);
	}

}
