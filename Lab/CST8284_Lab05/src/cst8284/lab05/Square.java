package cst8284.lab05;

/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Lab05
 * Date:Jul 5, 2021
 * Description: Square class is a child class from BasicShape class. This class is used to 
 * calculate the Square perimeter and area. And, it override the equals method and toString
 * method
 */

/**
 * 
 *This is a child class from BasicShape class to calculate the Square perimeter and area
 *And, it override the equals method and toString method
 */
public class Square extends BasicShape{
	
	/*default constructor with default value from super class*/
	public Square() {
		this(minValue);
	}
	/*constructor with double filed*/
	public Square(double width) {
		super(width);
	}
	/*constructor with Square field*/
	public Square(Square square) {
		this(square.getWidth());
	}
	
	/*override getArea method to calculate the area*/
	@Override
	public double getArea() {
		double area = getWidth() * getWidth(); //formula for area of Square
		return area;
	}
	/*override getPerimeter method to calculate the perimeter*/
	@Override
	public double getPerimeter() {
		double perimeter = 4 * getWidth(); //formula for Perimeter of Square
		return perimeter;
	}
	/*override toString method to output*/
	@Override
	public String toString() {
		return ("Square extends " + super.toString());
	}
	/*override equals method to compare the new object*/
	@Override
	public boolean equals(Object obj) {
		if(obj == null || (!(obj instanceof Square))) {
			return false;
		}
		Square square1 = (Square)obj;
		if(getWidth() != square1.getWidth()) {
			return false;
		}
		
		return true;
	}

}

