/**
 * 
 * @author Jason Chen
 *
 */

public class Quadrilateral implements Polygon{
	protected double base1;
	protected double base2;
	protected double height;
	protected double side1;
	protected double side2;
	protected double area;
	protected double perimeter;
	
	public Quadrilateral(double base1){
		this.base1 = base1;
	}
	
	public Quadrilateral(double base1, double height){
		this.base1 = base1;
		this.height = height;
	}
	
	public Quadrilateral(double base1, double base2, double height, double side1, double side2) {
		this.base1 = base1;
		this.base2 = base2;
		this.height = height;
		this.side1 = side1;
		this.side2 = side2;
	}
	
	public double areaR() {
		return base1 * height;
	}
	
	public double perimeterR() {
		return (base1 + height)*2;
	}
	
	public double area() {
		return base1*base2/2*height;
	}
	
	public double perimeter(){
		return base1 + base2 + side1 + side2;
	}
}
