package cst8284.lab05.test;


import static org.junit.Assert.*;

import java.util.IllegalFormatWidthException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst8284.lab05.Rectangle;
import cst8284.lab05.Square;
/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Lab 05
 * Date:Jul 6, 2021
 * Description: This is a Junit test class for Rectangle to test the getArea 
 * and getPerimeter methods.
 */
public class RectangleTest {

	
	final double EPSILON = 1E-12;
	final double WIDTH = 5.0;
	final double HEIGHT = 5.0;

	@Before
	public void setUp() throws Exception {

	}

	/*test the getArea method with width = 5.0*/
	@Test
	public void testGetArea_True() {
		double area1 = new Square(WIDTH).getArea();
		double area2 = new Rectangle(WIDTH,HEIGHT).getArea();
		assertEquals(area1, area2, EPSILON);

	}

	/*test the getPerimeter method with width = 5.0*/
	@Test
	public void testGetPerimeter_True() {
		double perimeter1 = new Square(WIDTH).getPerimeter();
		double perimeter2 = new Rectangle(WIDTH,HEIGHT).getPerimeter();
		assertEquals(perimeter1, perimeter2, EPSILON);
	}
	
	

}
