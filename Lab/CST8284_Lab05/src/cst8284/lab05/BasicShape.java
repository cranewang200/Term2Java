package cst8284.lab05;

public class BasicShape {
	public static final double minValue = 1.0;
	public static final double maxValue = 10000.0;
	private double width;
	protected BasicShape(double width) {setWidth(width);}
	
	public double getWidth(){return width;}
	public void setWidth(double width){this.width = width;}
			
	@Override
	public String toString(){
		return ("BasicShape extends " + super.toString());
	}
	
	public double getArea()  { return 0.0; }
	public double getPerimeter() { return 0.0; }
	
	
	
}
