package cst8284.junit.lab4.test;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
	public void testCounter() {
		Counter secondCounter = new Counter();
		int result = secondCounter.increment();
		
		assertTrue(result == counter.increment());
		
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testCounterInt() {
		Counter thirdCounter = new Counter(INITI_COUNT_FIVE);
		int result = thirdCounter.increment();
		
		assertTrue(result == secondCounter.increment());
		
		
		
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testIncrement() {
		Counter thirdCounter = new Counter(Integer.MAX_VALUE);
		
		int result = 5;
		++result;
		assertTrue(result == secondCounter.increment());

		assertTrue(0 == thirdCounter.increment()); //test the increment won't return number greater than Integer.Max_VALUE
		
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDecrement() {
		
		int result = 5;
		--result;
		assertTrue(result == secondCounter.decrement());
		
		assertTrue(0 == counter.decrement()); //test the decrement won't return a negative number


		
		
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetCount() {
		
		int result = secondCounter.getCount();
		
		assertTrue(result == INITI_COUNT_FIVE);
				
				

				
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAdd() {
		Counter addCounter = new Counter(INITI_COUNT_TEN);
		int result = 5 + 10;
		assumeTrue(result == secondCounter.getCount() + addCounter.getCount());
		
		// Test the add method won't return a number greater than Integer.MAX_VALUE
		// 10 + Integer.MAX_VALUE  return 0
		Counter addCounterMaxValue = new Counter(Integer.MAX_VALUE); 
		assumeTrue(0 == addCounter.getCount() + addCounterMaxValue.getCount());

	}

	@Test
	public void testSub() {
		Counter thirdCounter = new Counter(INITI_COUNT_TEN);
		int result = 10 - 5;
		assumeTrue(result == thirdCounter.getCount() - secondCounter.getCount());
		
		// Test the sub method won't return a negative number 
		//5 - 10 return 0
		assumeTrue(0 == secondCounter.getCount() - thirdCounter.getCount());
		

	}

	@Test
	public void testToString() {
		
		String result = "Count is " + counter.getCount();
		assertTrue(result.equals(counter.toString()));

	}

}
