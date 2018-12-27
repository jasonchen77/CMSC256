/**
 * 
 * @author Jason Chen
 *
 */

public class Triangle implements Polygon {
	protected static double base;
	protected static double height;
	protected static double side1;
	protected static double side2;
	protected static double area;
	protected static double perimeter;
	
	public Triangle(double base, double height, double side1, double side2){
		this.base = base;
		this.height = height;
		this.side1 = side1;
		this.side2 = side2;
	}
	
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double area() {
		return area = (base*height)/2;
	}
	
	public double perimeter() {
		return perimeter = base + side1 + side2;
	}
}
