package cst8284.lab05;

/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Lab05
 * Date:Jul 5, 2021
 * Description: Triangle class is a child class from BasicShape class. This class is used to 
 * calculate the Triangle perimeter and area. And, it override the equals method and toString
 * method
 */

/**
 * 
 *This is a child class from BasicShape class to calculate the Triangle perimeter and area
 *And, it override the equals method and toString method
 */
public class Triangle extends BasicShape{
	
	/*default constructor with default value from super class*/
	public Triangle () {
		this(minValue);
	}

	/*constructor with double filed*/
	public Triangle(double width) {
		super(width);
	}
	/*constructor with Triangle field*/
	public Triangle(Triangle triangle) {
		this(triangle.getWidth());
	}
	/*override getArea method to calculate the area*/
	@Override
	public double getArea() {
		double area = Math.sqrt(3) / 4 * getWidth() * getWidth(); //formula for area of Triangle
		return area;
	}
	/*override getPerimeter method to calculate the perimeter*/
	@Override
	public double getPerimeter() {
		double preimeter = 3 * getWidth();  //formula for perimeter of Triangle
		return preimeter;
	}
	/*override toString method to output*/
	@Override
	public String toString() {
		return ("Triangle extends " + super.toString());
	}
	/*override equals method to compare the new object*/
	@Override
	public boolean equals(Object obj) {
		if(obj == null || (!(obj instanceof Triangle))) {
			return false;
		}
		Triangle triangle1 = (Triangle)obj;
		if(getWidth() != triangle1.getWidth()) {
			return false;
		}
		return true;
	}
}
