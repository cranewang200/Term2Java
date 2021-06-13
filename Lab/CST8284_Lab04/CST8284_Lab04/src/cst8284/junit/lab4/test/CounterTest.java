package cst8284.junit.lab4.test;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Before;

import org.junit.Test;

import cst8284.junit.lab4.Counter;

public class CounterTest {

	private final int INITI_COUNT_FIVE = 5;
	private final int INITI_COUNT_TEN = 10;
	private Counter counter;
	private Counter secondCounter;

	@Before
	public void initCounter() throws Exception {
		counter = new Counter();
		secondCounter = new Counter(INITI_COUNT_FIVE);

	}

//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void testCounter_True() {
		// secondCounter = 0
		Counter secondCounter = new Counter();
		int result = secondCounter.getCount() + 1;

		assertTrue(result == counter.increment());

	}

	@Test
	public void testCounter_False() {
		// secondCounter = 0
		Counter secondCounter = new Counter();
		int result = secondCounter.getCount() + 2;

		assertFalse(result == counter.increment());
	}

	@Test
	public void testCounterInt_True() {
		// secondCounter = INITI_COUNT_FIVE
		Counter thirdCounter = new Counter(INITI_COUNT_FIVE);
		int result = thirdCounter.increment();

		assertTrue(result == secondCounter.increment());

	}

	@Test
	public void testCounterInt_False() {
		// secondCounter = INITI_COUNT_FIVE
		Counter thirdCounter = new Counter(INITI_COUNT_TEN);
		int result = thirdCounter.increment();
		assertFalse(result == secondCounter.increment());

	}

	@Test
	public void testIncrement_True() {
		// secondCounter = INITI_COUNT_FIVE
		Counter thirdCounter = new Counter(Integer.MAX_VALUE);
		// 5+1 == 5+1
		int result = INITI_COUNT_FIVE + 1;
		assertTrue(result == secondCounter.increment());
		// test the increment won't return number greater than Integer.Max_VALUE
		// should return 0
		assertTrue(0 == thirdCounter.increment());

	}

	@Test
	public void testIncrement_False() {
		// secondCounter = INITI_COUNT_FIVE
		Counter thirdCounter = new Counter(Integer.MAX_VALUE);
		// 5+2 != 5+1
		int result = INITI_COUNT_FIVE + 2;
		assertFalse(result == secondCounter.increment());
		// test the increment won't return number greater than Integer.Max_VALUE
		// should return 0 but not other number
		assertFalse(1 == thirdCounter.increment());

	}

	@Test
	public void testDecrement_True() {
		// secondCounter = INITI_COUNT_FIVE
		int result = INITI_COUNT_FIVE;
		result = result - 1;
		assertTrue(result == secondCounter.decrement()); // test decrement 1

		assertTrue(0 == counter.decrement()); // test the decrement won't return a negative number

	}

	@Test
	public void testDecrement_False() {
		// secondCounter = INITI_COUNT_FIVE
		int result = INITI_COUNT_FIVE;
		
		result = result - 2;
		assertFalse(result == secondCounter.decrement()); // test decrement 2

		assertFalse(-1 == counter.decrement()); // test the decrement won't return a negative number

	}

	@Test
	public void testGetCount_True() {
		// secondCounter = INITI_COUNT_FIVE
		int result = secondCounter.getCount();

		assertTrue(result == INITI_COUNT_FIVE);
	}

	@Test
	public void testGetCount_False() {
		// secondCounter = INITI_COUNT_FIVE
		int result = secondCounter.getCount();

		assertFalse(result == INITI_COUNT_TEN);
	}

	@Test
	public void testAdd_True() {
		// 10 + 5 = 5 + 5
		// secondCounter = INITI_COUNT_FIVE
		counter.setCount(INITI_COUNT_TEN);
		int result = counter.add(secondCounter).getCount(); // 10 + 5
		assertTrue(result == INITI_COUNT_TEN + INITI_COUNT_FIVE);

		// Test the add method won't return a number greater than Integer.MAX_VALUE
		// 10 + Integer.MAX_VALUE should return 0

		secondCounter.setCount(Integer.MAX_VALUE);

		assertTrue(0 == counter.add(secondCounter).getCount());

	}

	@Test
	public void testAdd_False() {
		// 10 + 5 != 5 + 5
		// secondCounter = INITI_COUNT_FIVE
		counter.setCount(INITI_COUNT_TEN);
		int result = counter.add(secondCounter).getCount(); // 10 + 5
		assertFalse(result == INITI_COUNT_FIVE + INITI_COUNT_FIVE);

		// Test the add method won't return a number greater than Integer.MAX_VALUE
		// 10 + Integer.MAX_VALUE should return 0 not 1
		secondCounter.setCount(Integer.MAX_VALUE);

		assertFalse(1 == counter.add(secondCounter).getCount());

	}

	@Test
	public void testSub_True() {
		// 10-5 == 10-5
		// secondCounter = INITI_COUNT_FIVE
		counter.setCount(INITI_COUNT_TEN);
		int result = counter.sub(secondCounter).getCount();
		assertTrue(INITI_COUNT_TEN - INITI_COUNT_FIVE == result);

//		 Test the sub method won't return a negative number
//		 5 - 10 return should return 0, not -5
		result = secondCounter.sub(counter).getCount();
		assertTrue(0 == result);

	}

	@Test
	public void testSub_False() {
		// secondCounter = INITI_COUNT_FIVE
		// 10 - 5 != 5 - 5
		counter.setCount(INITI_COUNT_TEN);
		int result = counter.sub(secondCounter).getCount();
		assertFalse(INITI_COUNT_FIVE - INITI_COUNT_FIVE == result);

		// Test the sub method won't return a negative number
		// 5 - 10 should return 0 not -5
		result = secondCounter.sub(counter).getCount();
		assertFalse(-5 == result);

	}

	@Test
	public void testToString_True() {

		String result = "Count is " + counter.getCount();
		assertTrue(result.equals(counter.toString()));

	}

	@Test
	public void testToString_False() {

		String result = "Count is not" + counter.getCount();
		assertFalse(result.equals(counter.toString()));

	}

}
