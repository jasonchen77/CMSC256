import java.util.Scanner;

/**
 * This program calculates the area and perimeter
 * @author Jason Chen
 *
 */

public class A1_Q3 {

 public static void main (String[] args) {
  Scanner in = new Scanner(System.in);
  String shape;
  double base;
  double height;
  double base1;
  double base2;
  double side1;
  double side2;
  
  System.out.println("Please enter the shape.");
  shape = in.nextLine();
  
  if(shape.equals("Triangle")){
   System.out.println("Please enter the base length");
   base = in.nextDouble();
   System.out.println("Please enter the height");
   height = in.nextDouble();
   System.out.println("Please enter the side 1 length");
   side1 = in.nextDouble();
   System.out.println("Please enter the side 2 length");
   side2 = in.nextDouble();
   
   Triangle t = new Triangle(base, height, side1, side2);
   System.out.println("The area is: " + t.area());
   System.out.println("The perimeter is: " + t.perimeter());
  }
  else if(shape.equals("Isoceles Triangle")){
   System.out.println("Please enter the base length");
   base = in.nextDouble();
   System.out.println("Please enter the height");
   height = in.nextDouble();
   System.out.println("Please enter the side 1 length");
   side1 = in.nextDouble();
   System.out.println("Please enter the side 2 length");
   side2 = in.nextDouble();
   
   IsoscelesTriangle t = new IsoscelesTriangle(base, height, side1, side2);
   System.out.println("The area is: " + t.area());
   System.out.println("The perimeter is: " + t.perimeter());
  }
  
  else if(shape.equals("Equilateral Triangle")){
   System.out.println("Please enter the base length");
   base = in.nextDouble();
   System.out.println("Please enter the height");
   height = in.nextDouble();
   System.out.println("Please enter the side 1 length");
   side1 = in.nextDouble();
   System.out.println("Please enter the side 2 length");
   side2 = in.nextDouble();
   
   EquilateralTriangle t = new EquilateralTriangle(base, height, side1, side2);
   System.out.println("The area is: " + t.area());
   System.out.println("The perimeter is: " + t.perimeter());
  }
  
  else if(shape.equals("Quadrilateral")){
   System.out.println("Please enter the base 1 length");
   base1 = in.nextDouble();
   System.out.println("Please enter the base 2 length");
   base2 = in.nextDouble();
   System.out.println("Please enter the height");
   height = in.nextDouble();
   System.out.println("Please enter the side 1 length");
   side1 = in.nextDouble();
   System.out.println("Please enter the side 2 length");
   side2 = in.nextDouble();
   
   Quadrilateral q = new Quadrilateral(base1, base2, height, side1, side2);
   System.out.println("The area is: " + q.area());
   System.out.println("The perimeter is: " + q.perimeter());
  }
  
  else if(shape.equals("Rectangle")){
   System.out.println("Please enter the base length");
   base1 = in.nextDouble();
   System.out.println("Please enter the height");
   height = in.nextDouble();
   
   Rectangle r = new Rectangle(base1,height);
   System.out.println("The area is: " + r.areaR());
   System.out.println("The perimeter is: " + r.perimeterR());
  }
  
  else if(shape.equals("Square")){
   System.out.println("Please enter the base length");
   base1 = in.nextDouble();
   
   Square s = new Square(base1);
   System.out.println("The area is: " + s.area());
   System.out.println("The perimeter is: " + s.perimeter());
  }
  
  else{
   System.out.println("The shape is not recognized.");
  }
  
  in.close();
 }
}
