import java.util.Scanner;

/**
 * This program converts decimal to hex
 * @author Jason Chen
 *
 */
public class A2_Q1 {

	private static boolean first = true;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a number in decimal");
		//enter a decimal number
		int number = in.nextInt();
		System.out.println("Decimal: " + number);
		System.out.println("Hex: " + decToHex(number));
		in.close();
	}
	
	/**
	 * 
	 * @param num the decimal number you want to convert
	 * @return the hex number converted from decimal
	 */
	public static String decToHex(int num){
		String hex = "";
		int remainder = num % 16;
		
		// if the original num is "0", will return only "0"
		if (num == 0 && first){
			return "0";
		}
		// base case
		else if (num == 0){
			return hex;
		}
		else{
			//if remainder is greater than 9, then do the following
			if (remainder == 10){
				hex += "A";
			}
			else if (remainder == 11){
				hex += "B";
			}
			else if (remainder == 12){
				hex += "C";
			}
			else if (remainder == 13){
				hex += "D";
			}
			else if (remainder == 14){
				hex += "E";
			}
			else if (remainder == 15){
				hex += "F";
			}
			else{
				hex += remainder;
			}
			//change the first boolean flag to false after first run
			first = false;
			//recursive method
			return decToHex(num/16) + hex;
		}
	}
}
