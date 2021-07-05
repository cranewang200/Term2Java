package cst8284.lab05;

public class Circle extends BasicShape{
	
	public Circle() {
		this(minValue);
	}

	public Circle(double width) {
		super(width);		
	}
	
	public Circle(Circle circle) {
		this(circle.getWidth());
				
	}
	
	
	@Override
	public double getArea() {
		double area = (Math.PI * (getWidth() * getWidth()) / 4);
		return area;
	}
	
	@Override
	public double getPerimeter() {
		double perimeter = Math.PI * getWidth();
		return perimeter;
	}
	
	@Override
	public String toString() {
		return ("Circle extends " + super.toString());
	
	}
	
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
