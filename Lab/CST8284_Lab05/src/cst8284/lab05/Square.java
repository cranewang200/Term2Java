package cst8284.lab05;

public class Square extends BasicShape{
	
	public Square() {
		this(minValue);
	}

	public Square(double width) {
		super(width);
	}
	
	public Square(Square square) {
		this(square.getWidth());
	}
	
	@Override
	public double getArea() {
		double area = getWidth() * getWidth();
		return area;
	}
	
	@Override
	public double getPerimeter() {
		double perimeter = 4 * getWidth();
		return perimeter;
	}
	
	@Override
	public String toString() {
		return ("Square extends " + super.toString());
	}
	
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

