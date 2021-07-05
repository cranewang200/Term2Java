package cst8284.lab05.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst8284.lab05.Rectangle;
import cst8284.lab05.Square;

public class RectangleTest {
//
	
	final double EPSILON = 1E-12;

//	@Before
//	public void setUp() throws Exception {
//		Square square ;
//		Rectangle rectangle;
//	}


	@Test
	public void testGetArea() {
		double area1 = new Square(5.0).getArea();
		double area2 = new Rectangle(5.0,5.0).getArea();
		assertTrue((area1 - area2) < EPSILON);

	}

	@Test
	public void testGetPerimeter() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testRectangle() {
		fail("Not yet implemented");
	}

	@Test
	public void testRectangleDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testRectangleDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testRectangleRectangle() {
		fail("Not yet implemented");
	}

}
