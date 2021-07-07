package cst8284.lab05;

/**
 * 
 * Class Name: CST8284-300
 * Author Name: Ming Wang
 * Class Name: Lab05
 * Date:Jul 5, 2021
 * Description: Rectangle class is a child class from Square class. This class is used to 
 * calculate the Rectangle perimeter and area. And, it override the equals method and toString
 * method
 */

/**
 * 
 *This is a child class from BasicShape class to calculate the Rectangle perimeter and area
 *And, it override the equals method and toString method
 */
public class Rectangle extends Square{
	
	private double height;
	
	/*default constructor with default value */
	public Rectangle() {
		this(minValue);		
	}
	/*constructor with double filed*/
	public Rectangle(double height) {
		this(height,minValue);
	}
	/*constructor with two double field*/
	public Rectangle(double height,double width) {
		super(width);
		this.height = height;
		
	}
	/*constructor with Rectangle field*/
	public Rectangle(Rectangle rectangle) {
		this(rectangle.getHeight(),rectangle.getWidth());
		
	}
	/*accessor of height*/
	public double getHeight() {
		return height;
	}
	/*mutator of height*/
	public void setHeight(double height) {
		this.height = height;
	}
	
	/*override getArea method to calculate the area*/
	@Override
	public double getArea() {
		double area = getHeight() * getWidth(); //formula for area of Rectangle
		return area;
	}
	
	/*override getPerimeter method to calculate the perimeter*/
	@Override
	public double getPerimeter() {
		double perimeter = (getHeight() +  getWidth()) * 2; //formula for Perimeter of Rectangle
		return perimeter;
	}
	
	/*override equals method to compare the new object*/
	@Override
	public boolean equals(Object obj) {

		if(!super.equals(obj)) {
			return false;
		} 
		
		if (obj instanceof Square) {
			if (getHeight() != getWidth()) {
				return false;
			}
		}
		
		if(obj instanceof Rectangle) {
			Rectangle rectangle1 = (Rectangle)obj;
			if ( getHeight() != rectangle1.getHeight()) {
				return false;
			}	
		}
		
		return true;
	}
}
