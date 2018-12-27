import java.util.Scanner;

/**
 * This program reverses the order of the input.
 * @author Jason Chen
 *
 */

public class A1_Q2 {
	
	public static void main(String[] args){
		int numberOfLines;
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter number of lines.");
		//enter the number of lines you want to enter
		numberOfLines = in.nextInt();
		Scanner input = new Scanner(System.in);
		String[] words = new String[numberOfLines];
		System.out.println("Please enter each line, press enter to go to the next line.");
		for(int x=0; x<numberOfLines; x++){
			words[x] = input.nextLine();
		}

		for(int x=numberOfLines-1; x>=0; x--){
			System.out.println(new StringBuffer(words[x]).reverse().toString());
		}
		in.close();
		input.close();
	}
}
