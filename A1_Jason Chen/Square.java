/**
 * 
 * @author Jason Chen
 *
 */

public class Square extends Quadrilateral{
	
	public double base;

	public Square(double base){
		super(base);
		this.base = base;
	}
	
	public double area(){
		return base * base;
	}
	
	public double perimeter(){
		return base * 4;
	}
}
