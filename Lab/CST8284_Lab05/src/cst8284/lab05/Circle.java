package cst8284.lab05;

import java.lang.reflect.Constructor;

/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Lab05
 * Date:Jul 5, 2021
 * Description: Circle class is a child class from BasicShape class. This class is used to 
 * calculate the circle's perimeter and area. And, it override the equals method and toString
 * method
 */

/**
 * 
 *This is a child class from BasicShape class to calculate the circle's perimeter and area
 *And, it override the equals method and toString method
 */
public class Circle extends BasicShape{
	
	/*default constructor with default value from super class*/
	public Circle() {
		this(minValue);
	}
	/*constructor with double filed*/
	public Circle(double width) {
		super(width);		
	}
	/*constructor with Circle field*/
	public Circle(Circle circle) {
		this(circle.getWidth());
				
	}
	
	/*override getArea method to calculate the area*/
	@Override
	public double getArea() {
		double area = (Math.PI * (getWidth() * getWidth())) / 4; //formula for area of Circle
		return area;
	}
	/*override getPerimeter method to calculate the perimeter*/
	@Override
	public double getPerimeter() {
		double perimeter = Math.PI * getWidth();  //formula for perimeter of Circle
		return perimeter;
	}
	/*override toString method to output*/
	@Override
	public String toString() {
		return ("Circle extends " + super.toString());
	
	}
	/*override equals method to compare the new object*/
	@Override
	public boolean equals(Object obj) {
		if(obj == null || (!(obj instanceof Circle))) {
			return false;
		}
		Circle circle1 = (Circle)obj;
		if(getWidth() != circle1.getWidth()) {
			return false;
		}
		return true;
	}

}
