package cst8284.Assignment2.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst8284.Assignment2.User;

/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Assignment 2
 * Date:Jul 10, 2021
 * Description: jUnit test for User class. Includes 30 test methods.
 *
 */

/**
 * 
 * For this testing class, instance 3 User objects for testing.
 */

public class UserTest {
	
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
	
	User user1 ;
	User user2 ;
	User user3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		user1 = new User(DEFAULT_ID, DEFAULT_FIRST, DEFAULT_LAST, DEFAULT_ADDRESS, DEFAULT_AGE);
//		user2 = new User(OTHER_ID, OTHER_FIRST, OTHER_LAST, OTHER_ADDRESS, OTHER_AGE);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		user1 = new User(DEFAULT_ID, DEFAULT_FIRST, DEFAULT_LAST, DEFAULT_ADDRESS, DEFAULT_AGE);
		user2 = new User(OTHER_ID, OTHER_FIRST, OTHER_LAST, OTHER_ADDRESS, OTHER_AGE);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test the constructor with 5 parameters
	 */
	@Test
	public void testUserIntStringStringStringInt_True() {
		int id = user1.getId();
		String first = user1.getFirstName();
		String last = user1.getLastName();
		String address = user1.getAddress();
		int age = user1.getAge();
		
		assertTrue(id == DEFAULT_ID 
				&& first.equals(DEFAULT_FIRST) 
				&& last.equals(DEFAULT_LAST)
				&& address.equals(DEFAULT_ADDRESS)
				&& age == DEFAULT_AGE);
	}

	/**
	 * Test the constructor with 5 parameters
	 */
	@Test
	public void testUserIntStringStringStringInt_False() {
		
		int id = user1.getId();
		String first = user1.getFirstName();
		String last = user1.getLastName();
		String address = user1.getAddress();
		int age = user1.getAge();
		
		assertFalse(id == OTHER_ID
				&& first.equals(OTHER_FIRST) 
				&& last.equals(OTHER_LAST)
				&& address.equals(OTHER_ADDRESS)
				&& age == OTHER_AGE);
	}

	/**
	 * Test the constructor with 4 parameters
	 */
	@Test
	public void testUserStringStringStringInt_True() {
		
		String first = user1.getFirstName();
		String last = user1.getLastName();
		String address = user1.getAddress();
		int age = user1.getAge();
		
		assertTrue(first.equals(DEFAULT_FIRST) 
				&& last.equals(DEFAULT_LAST)
				&& address.equals(DEFAULT_ADDRESS)
				&& age == DEFAULT_AGE);
	}
	
	/**
	 * Test the constructor with 4 parameters
	 */
	@Test
	public void testUserStringStringStringInt_False() {
		String first = user1.getFirstName();
		String last = user1.getLastName();
		String address = user1.getAddress();
		int age = user1.getAge();
		
		assertFalse(first.equals(OTHER_FIRST) 
				&& last.equals(OTHER_LAST)
				&& address.equals(OTHER_ADDRESS)
				&& age == OTHER_AGE);
	}

	/**
	 * Test the constructor with 3 String parameters
	 */
	@Test
	public void testUserStringStringString_True() {
		String first = user1.getFirstName();
		String last = user1.getLastName();
		String address = user1.getAddress();	
		
		assertTrue(first.equals(DEFAULT_FIRST) 
				&& last.equals(DEFAULT_LAST)
				&& address.equals(DEFAULT_ADDRESS));
	}

	/**
	 * Test the constructor with 3 String parameters
	 */
	@Test
	public void testUserStringStringString_False() {
		String first = user1.getFirstName();
		String last = user1.getLastName();
		String address = user1.getAddress();		
		
		assertFalse(first.equals(OTHER_FIRST) 
				&& last.equals(OTHER_LAST)
				&& address.equals(OTHER_ADDRESS));
	}

	/**
	 * Test the override toString method
	 */
	@Test
	public void testToString_True() {
		String expect = "";
		expect = "************ User id:" + user1.getId() + "\n";
		expect += "************ User name:" + user1.getFirstName() + " " + user1.getLastName() + "\n";
		expect += "************ Age:" + user1.getAge() + "\n";
		expect += "************ Address:" + user1.getAddress() + "\n";
		
		assertEquals(expect, user1.toString());
		
	}
	
	/**
	 * Test the override toString method
	 */
	@Test
	public void testToString_False() {
		String expect = "";
		expect = "************ User id:" + user1.getId() + "\n";
		expect += "************ User name:" + user1.getFirstName() + " " + user1.getLastName() + "\n";
		expect += "************ Age:" + user1.getAge() + "\n";
		expect += "************ Address:" + user1.getAddress() + "\n";
		
		assertNotEquals(expect, user2.toString());
	}

	/**
	 * Test the override equals method
	 */
	@Test
	public void testEqualsObject_True() {
		user3 = new User(DEFAULT_ID, DEFAULT_FIRST, DEFAULT_LAST, DEFAULT_ADDRESS, DEFAULT_AGE);
		assertEquals(user1, user3);
	}

	/**
	 * Test the override equals method
	 */
	@Test
	public void testEqualsObject_False() {
		assertNotEquals(user1, user2);
	}

//	@Test
//	public void testGetUserNextId_True() {
//		int nextId = user1.getUserNextId();
//		assertTrue(nextId == DEFAULT_ID + 1 );
//	}
//	
//	@Test
//	public void testGetUserNextId_False() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetUserNextId_True() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetUserNextId_False() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test the getId method
	 */
	@Test
	public void testGetId_True() {
		int id = user1.getId();
		assertTrue(id == DEFAULT_ID);
	}
	
	/**
	 * Test the getId method
	 */
	@Test
	public void testGetId_False() {
		int id = user1.getId();
		assertFalse(id == OTHER_ID);
	}

	/**
	 * Test the setId method
	 */
	@Test
	public void testSetId_True() {
		user1.setId(DEFAULT_ID);
		assertTrue(user1.getId() == DEFAULT_ID);
	}
	
	/**
	 * Test the setId method
	 */
	@Test
	public void testSetId_False() {
		user1.setId(DEFAULT_ID);
		assertFalse(user1.getId() == OTHER_ID);
	}

	/**
	 * Test the getFirstName method
	 */
	@Test
	public void testGetFirstName_True() {
		String first = user1.getFirstName();
		assertTrue(first.equals(DEFAULT_FIRST));
	}
	
	/**
	 * Test the getFirstName method
	 */
	@Test
	public void testGetFirstName_False() {
		String first = user1.getFirstName();
		assertFalse(first.equals(OTHER_FIRST));
	}

	/**
	 * Test the setFirstName method
	 */
	@Test
	public void testSetFirstName_True() {
		user1.setFirstName(DEFAULT_FIRST);
		assertTrue(user1.getFirstName() == DEFAULT_FIRST);
	}

	/**
	 * Test the setFirstName method
	 */
	@Test
	public void testSetFirstName_False() {
		user1.setFirstName(DEFAULT_FIRST);
		assertFalse(user1.getFirstName() == OTHER_FIRST);
	}

	/**
	 * Test the getLirstName method
	 */
	@Test
	public void testGetLastName_True() {
		String last = user1.getLastName();
		assertTrue(last.equals(DEFAULT_LAST));
	}
	
	/**
	 * Test the getLirstName method
	 */
	@Test
	public void testGetLastName_False() {
		String last = user1.getLastName();
		assertFalse(last.equals(OTHER_LAST));
	}

	/**
	 * Test the setLirstName method
	 */
	@Test
	public void testSetLastName_True() {
		user1.setLastName(DEFAULT_LAST);
		assertTrue(user1.getLastName() == DEFAULT_LAST);
	}

	/**
	 * Test the setLirstName method
	 */
	@Test
	public void testSetLastName_False() {
		user1.setLastName(DEFAULT_LAST);
		assertFalse(user1.getLastName() == OTHER_LAST);
	}

	/**
	 * Test the getAddress method
	 */
	@Test
	public void testGetAddress_True() {
		String address = user1.getAddress();
		assertTrue(address.equals(DEFAULT_ADDRESS));
	}
	
	/**
	 * Test the getAddress method
	 */
	@Test
	public void testGetAddress_False() {
		String address = user1.getAddress();
		assertFalse(address.equals(OTHER_ADDRESS));
	}

	/**
	 * Test the setAddress method
	 */
	@Test
	public void testSetAddress_True() {
		user1.setAddress(DEFAULT_ADDRESS);
		assertTrue(user1.getAddress() == DEFAULT_ADDRESS);
	}

	/**
	 * Test the setAddress method
	 */
	@Test
	public void testSetAddress_False() {
		user1.setAddress(DEFAULT_ADDRESS);
		assertFalse(user1.getAddress() == OTHER_ADDRESS);
	}

	/**
	 * Test the getAge method
	 */
	@Test
	public void testGetAge_True() {
		int age = user1.getAge();
		assertTrue(age == DEFAULT_AGE);
	}
	
	/**
	 * Test the getAge method
	 */
	@Test
	public void testGetAge_False() {
		int age = user1.getAge();
		assertFalse(age == OTHER_AGE);
	}

	/**
	 * Test the setAge method
	 */
	@Test
	public void testSetAge_True() {
		user1.setAge(DEFAULT_AGE);
		assertTrue(user1.getAge() == DEFAULT_AGE);
	}
	
	/**
	 * Test the setAge method
	 */
	@Test
	public void testSetAge_False() {
		user1.setAge(DEFAULT_AGE);
		assertFalse(user1.getAge() == OTHER_AGE);
	}


}
