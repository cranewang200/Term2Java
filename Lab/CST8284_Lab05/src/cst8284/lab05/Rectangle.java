package cst8284.lab05;

public class Rectangle extends Square{
	
	private double height;
	
	public Rectangle() {
		this(1.0);
		
	}
	
	public Rectangle(double height) {
		this(height,minValue);
	}
	
	public Rectangle(double height,double width) {
		super(width);
		this.height = height;
		
	}
	
	public Rectangle(Rectangle rectangle) {
		this(rectangle.getHeight(),rectangle.getWidth());
		
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
	@Override
	public double getArea() {
		double area = getHeight() * getWidth();
		return area;
	}
	
	@Override
	public double getPerimeter() {
		double perimeter = (getHeight() +  getWidth()) * 2;
		return perimeter;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || (!(obj instanceof Rectangle))) {
			return false;
		}
		Rectangle rectangle1 = (Rectangle)obj;
		if(getWidth() != rectangle1.getWidth() || getHeight() != rectangle1.getHeight()) {
			return false;
		}
		
		return true;
	}
}
