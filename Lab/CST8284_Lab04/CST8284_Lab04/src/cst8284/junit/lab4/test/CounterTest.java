package cst8284.junit.lab4.test;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Before;

import org.junit.Test;

import cst8284.junit.lab4.Counter;
/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Lab 5
 * Date:Jun 16, 2021
 * Description: Junit test.
 *
 */

/**
 * Counter class includes 2 constructor and 6 methods to be tested.
 * every method need to test the correct result and incorrect result 
 *
 */
public class CounterTest {

	private final int INITI_COUNT_FIVE = 5;
	private final int INITI_COUNT_TEN = 10;
	private Counter counter;
	private Counter secondCounter;

	/*before the test, need to construct 2 new objects for testing*/
	@Before
	public void initCounter() throws Exception {
		counter = new Counter();	//default constructor value = 0
		secondCounter = new Counter(INITI_COUNT_FIVE); //constructor with int field, value = 5
	}

	/*test the default constructor if it is correct*/
	@Test
	public void testCounter_True() {
		Counter secondCounter = new Counter();
		int result = secondCounter.getCount() + 1;
		assertTrue(result == counter.increment());
	}

	/*test the default constructor if it is incorrect*/
	@Test
	public void testCounter_False() {
		// secondCounter = 0
		Counter secondCounter = new Counter();
		int result = secondCounter.getCount() + 2;
		assertFalse(result == counter.increment());
	}

	/*test the constructor with int field if it is correct*/
	@Test
	public void testCounterInt_True() {
		// secondCounter = INITI_COUNT_FIVE
		Counter thirdCounter = new Counter(INITI_COUNT_FIVE);
		int result = thirdCounter.increment();
		assertTrue(result == secondCounter.increment());
	}
	


	/*test the constructor with int field if it is not correct*/
	@Test
	public void testCounterInt_False() {
		// secondCounter = INITI_COUNT_FIVE
		Counter thirdCounter = new Counter(INITI_COUNT_TEN);
		int result = thirdCounter.increment();
		assertFalse(result == secondCounter.increment());
	}

/**
 * test the increment method if it is correct.
 * first it verify the number if it's greater and equals than Integer.Max_VALUE
 * will not return a value greater than Integer.Max_VALUE
 * if the value is greater and equals than Integer.Max_VALUE, then return 0
 * if not , then increment itself by 1 and return the new number
 */
	@Test
	public void testIncrement_True() {
		// secondCounter = INITI_COUNT_FIVE
		// 5+1 == 5+1
		int result = INITI_COUNT_FIVE + 1;
		assertTrue(result == secondCounter.increment());

	}
/**
 *  this test is testing the logic in the increment method
 * 	test the increment won't return number greater than Integer.Max_VALUE
 *	should return 0
 */
	@Test
	public void testIncrementNotOverFlow_True() {	
		Counter thirdCounter = new Counter(Integer.MAX_VALUE);
		assertTrue(0 == thirdCounter.increment());
	}
/**
 * 	test the increment method is incorrect.
 * every time the method will increment by 1
 * if I want the method increment by 2,
 * it will return the wrong number
 */
	@Test
	public void testIncrement_False() {
		// secondCounter = INITI_COUNT_FIVE
//		Counter thirdCounter = new Counter(Integer.MAX_VALUE);
		// 5+2 != 5+1
		int result = INITI_COUNT_FIVE + 2;
		assertFalse(result == secondCounter.increment());

	}
	
	
	/**
	 * this test is testing the logic in the increment method
	 * test the increment won't return number greater than Integer.Max_VALUE
	 *	should return 0 but not other numbers
	 */
	@Test
	public void testIncrementOverFlow_False() {	
		Counter thirdCounter = new Counter(Integer.MAX_VALUE);	
		assertFalse(1 == thirdCounter.increment());
	}
	

	
	/**
	 * test the decrement method if it is correct.
	 * first it verify the number if it's lesser than 0
	 * will not return a negative number
	 * if the value is lesser and 0, then return 0
	 * if not , then decrement itself by 1 and return the new number
	 */
	@Test
	public void testDecrement_True() {
		// secondCounter = INITI_COUNT_FIVE
		// 5-1 == 5-1 
		int result = INITI_COUNT_FIVE;
		result = result - 1;
		assertTrue(result == secondCounter.decrement()); // test decrement 1
	}
	
	/**
	 *  this test is testing the logic in the decrement method
	 * 	test the decrement won't return a negative number 
	 *	should return 0
	 */
	@Test
	public void testDecrementNoNegativeNumber_True() {
		// counter = 0
		//0-1 return 0		
		assertTrue(0 == counter.decrement()); // test the decrement won't return a negative number
	}

	/**
	 * 	test the decrement method is incorrect.
	 * every time the method will decrement by 1
	 * if I want the method decrement by 2,
	 * it will return the wrong number
	 */
	@Test
	public void testDecrement_False() {
		// secondCounter = INITI_COUNT_FIVE
		//5 - 2 != 5 - 1
		int result = INITI_COUNT_FIVE;		
		result = result - 2;
		assertFalse(result == secondCounter.decrement()); // test decrement 2
	}

	/**
	 *  this test is testing the logic in the decrement method
	 * 	test the decrement won't return a negative number 
	 *	if it return a negative number ,it should be wrong
	 */
	 @Test
	public void testDecrementNoNegativeNumber_False() {
		// counter = 0
		 // 0 - 1 != -1 , should return 0
		assertFalse(-1 == counter.decrement()); // test the decrement won't return a negative number
	}
	 
	 //test the getter
	@Test
	public void testGetCount_True() {
		// secondCounter = INITI_COUNT_FIVE
		int result = secondCounter.getCount();
		assertTrue(result == INITI_COUNT_FIVE);
	}
	
	 //test the getter
	@Test
	public void testGetCount_False() {
		// secondCounter = INITI_COUNT_FIVE
		int result = secondCounter.getCount();
		assertFalse(result == INITI_COUNT_TEN);
	}

	/**
	 * Test the add method, first step need to verify the result is not greater 
	 * than Integer.MAX_VALUE.
	 * then return the result for addition
	 */
	@Test
	public void testAdd_True() {
		// 10 + 5 = 10 + 5
		// secondCounter = INITI_COUNT_FIVE
		counter.setCount(INITI_COUNT_TEN);
		int result = counter.add(secondCounter).getCount(); // 10 + 5
		assertTrue(result == INITI_COUNT_TEN + INITI_COUNT_FIVE);
	}

	/**
	 * Test the add method won't return a number greater than Integer.MAX_VALUE
	 * if the result greater than Integer.MAX_VALUE. 
	 * it will return 0
	 */
	@Test
	public void testAddNoOverFlow_True() {
		// secondCounter = INITI_COUNT_FIVE
		// Test the add method won't return a number greater than Integer.MAX_VALUE
		// 10 + Integer.MAX_VALUE should return 0
		secondCounter.setCount(Integer.MAX_VALUE);
		assertTrue(0 == counter.add(secondCounter).getCount());
	}
	
	
	/**
	 * Test the add method, first step need to verify the result is not greater 
	 * than Integer.MAX_VALUE.
	 * then return the result for addition
	 */
	@Test
	public void testAdd_False() {
		// 10 + 5 != 5 + 5
		// secondCounter = INITI_COUNT_FIVE
		counter.setCount(INITI_COUNT_TEN);
		int result = counter.add(secondCounter).getCount(); // 10 + 5
		assertFalse(result == INITI_COUNT_FIVE + INITI_COUNT_FIVE);
	}
	
	/**
	 * Test the add method won't return a number greater than Integer.MAX_VALUE
	 * if the result greater than Integer.MAX_VALUE. 
	 * it will return 0 not the other numbers
	 */
	@Test
	public void testAddNoOverFlow_False() {
		// Test the add method won't return a number greater than Integer.MAX_VALUE
		// 10 + Integer.MAX_VALUE should return 0 not 1
		secondCounter.setCount(Integer.MAX_VALUE);
		assertFalse(1 == counter.add(secondCounter).getCount());
	}

	
	/**
	 * Test the sub method, first step need to verify the result is not a negative number 
	 * then return the result for subtraction
	 */
	@Test
	public void testSub_True() {
		// 10-5 == 10-5
		// secondCounter = INITI_COUNT_FIVE
		counter.setCount(INITI_COUNT_TEN);
		int result = counter.sub(secondCounter).getCount();  //10 -5
		assertTrue(INITI_COUNT_TEN - INITI_COUNT_FIVE == result);
	}
	
	
	/**
	 * Test the sub method won't return a negative number 
	 * if the result is negative number
	 * it will return 0 . it says 5 - 10 should return 0
	 */
	@Test
	public void testSubNoNegativeNumber_True() {
		// secondCounter = INITI_COUNT_FIVE
		counter.setCount(INITI_COUNT_TEN);
		//Test the sub method won't return a negative number
		//5 - 10 return should return 0, not -5
		int result = secondCounter.sub(counter).getCount(); //5 - 10
		assertTrue(0 == result);
	}

	/**
	 * Test the sub method, first step need to verify the result is not a negative number 
	 * then return the result for subtraction
	 * it says 10 - 5 != 5 -5.
	 */
	@Test
	public void testSub_False() {
		// secondCounter = INITI_COUNT_FIVE
		// 10 - 5 != 5 - 5
		counter.setCount(INITI_COUNT_TEN);
		int result = counter.sub(secondCounter).getCount(); // 10 - 5
		assertFalse(INITI_COUNT_FIVE - INITI_COUNT_FIVE == result);
	}
	
	
	/**
	 * Test the sub method won't return a negative number 
	 * if the result is negative number
	 * it will return 0 . it says 5 - 10 should return 0
	 * not return -5, if the return is -5, the testing result would be false
	 */
	@Test
	public void testSubNoNegativeNumber_False() {
		// secondCounter = INITI_COUNT_FIVE
		counter.setCount(INITI_COUNT_TEN);
		// Test the sub method won't return a negative number
		// 5 - 10 should return 0 not -5
		int result = secondCounter.sub(counter).getCount();
		assertFalse(-5 == result);
	}

	/**
	 *to test the toString if the format is correct
	 */
	@Test
	public void testToString_True() {		
		String result = "Count is " + counter.getCount();
		assertTrue(result.equals(counter.toString()));
	}

	/**
	 * to test the toString if the format is NOT correct
	 */
	@Test
	public void testToString_False() {		
		String result = "Count is not" + counter.getCount();
		assertFalse(result.equals(counter.toString()));
	}

}
