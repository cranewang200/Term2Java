package cst8284.lab05;

public class Triangle extends BasicShape{
	
	public Triangle () {
		this(minValue);
	}

	public Triangle(double width) {
		super(width);
	}
	public Triangle(Triangle triangle) {
		this(triangle.getWidth());
	}
	
	@Override
	public double getArea() {
		double area = Math.sqrt(3) / 4 * getWidth() * getWidth();
		return area;
	}
	
	@Override
	public double getPerimeter() {
		double preimeter = 3 * getWidth();
		return preimeter;
	}
	
	@Override
	public String toString() {
		return ("Triangle extends " + super.toString());
	}
	
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
