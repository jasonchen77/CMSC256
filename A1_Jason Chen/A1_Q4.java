import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * This program reads math expressions and displays the result.
 * @author Jason Chen
 *
 */

public class A1_Q4 {

	public static void main(String[] args){
		try{
			//Please change the file path if needed
			FileReader reader = new FileReader("input.txt");
			Scanner in = new Scanner(reader);
			List<String> list = new LinkedList<String>();
			
			while(in.hasNext()){
				String expression = in.nextLine();
				list.add(expression);
			}
			try {
				for(int x=0; x<list.size(); x++){
					double result = 0;
					//int b = 0;
					List<String> x1 = new LinkedList<String>();
					Stack stack = new Stack();
					Stack num = new Stack();
					
					for(int y=0; y<list.get(x).length(); y++){
							if(list.get(x).charAt(y) == '*' || list.get(x).charAt(y) == '/' || list.get(x).charAt(y) == '+' || list.get(x).charAt(y) == '-' || list.get(x).charAt(y) == '('){
								String operator = list.get(x).substring(y, y+1);
								stack.push(operator);
							}
							else{
								String num2 = list.get(x).substring(y, y+1);
								x1.add(num2);
							}
							
							if(list.get(x).charAt(y) == '*' && list.get(x).charAt(y+1) == '*'){
								x1.add("^");
								y++;
							}
							
							if(list.get(x).charAt(y) == ')' ){
								
								if((!stack.isEmpty())){
									while((!stack.isEmpty()) && (stack.peek() != "(")){
									x1.add((String) stack.pop());
									}
									if((!stack.isEmpty())){
									stack.pop();
									}
								}
							}
						
					}
					while(!stack.isEmpty()){
						x1.add((String) stack.pop());
					}
					
					boolean first = true;
					for(int k=0; k<x1.size(); k++){
						
						if(Character.isDigit(x1.get(k).charAt(0))){
							num.push(x1.get(k));
						}
							if(!num.isEmpty()){
							
								if((x1.get(k).equals("*")||x1.get(k).equals("/")||x1.get(k).equals("+")||x1.get(k).equals("-")) && first){
									result = Double.parseDouble((String) num.pop());
									first = false;
								}
							
							/**
							if(k<x1.size()-1 && x1.get(k).equals("*") && x1.get(k+1).equals("*")){
								result = Math.pow(Double.parseDouble((String) num.pop()), result);
							}
							*/
							
							if(x1.get(k).equals("^")){
								result = (Math.pow(Double.parseDouble((String) num.pop()), result));
							}
							
							if(x1.get(k).equals("*")){
								result = Double.parseDouble((String) num.pop()) * result;
							}
							if(x1.get(k).equals("/")){
								result = result / Double.parseDouble((String) num.pop());
							}
							if(x1.get(k).equals("+")){
								result = Double.parseDouble((String) num.pop()) + result;
							}
							if(x1.get(k).equals("-")){
								result = Double.parseDouble((String) num.pop()) - result;
							}
							}
					}
					System.out.println(result);
				}
			}
			catch(NumberFormatException e){
				System.out.println(e);
			}
			in.close();
		}
		catch (FileNotFoundException e){
			System.out.println(e);
		}
	}
}
