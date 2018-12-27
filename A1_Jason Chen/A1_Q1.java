import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;

/**
 * This program input a list of words and output the number of each word.
 * @author Jason Chen
 *
 */

public class A1_Q1 {
	
	public static void main(String[] args) {
		String userInput;
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a list of words separated by spaces");
		//separate the words by space and press enter when done
		userInput = in.nextLine();
		Scanner input = new Scanner(userInput);
		
		ArrayList<String> wordList = new ArrayList<String>();
		Set<String> wordAndNumber = new HashSet<String>();
		
		//put the words in an ArrayList
		while(input.hasNext()){
			String word = input.next();
			wordList.add(word);
		}
		
		//count the number of words and put them in a set
		for(String element : wordList){
			int numberOfWord = 0;
			for(String element2 : wordList){
				if(element.equals(element2)){
					numberOfWord++;
				}
			}
			wordAndNumber.add(element + " " + numberOfWord);
		}
		
		//loop through the set and print the elements
		for(String element : wordAndNumber){
			String word = element;
			System.out.println(word);
		}
		
		in.close();
		input.close();
	}
}
