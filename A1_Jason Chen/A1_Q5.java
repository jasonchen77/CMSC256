import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This program calculates how many boxes can fit.
 * @author Jason Chen
 *
 */

public class A1_Q5 {
	public static void main(String[] args){
		try{
			//Please change the file path if needed
			FileReader reader = new FileReader("input1.txt");
			Scanner in = new Scanner(reader);
			String[] col = in.next().split("#");
			//get the box number
			int number = Integer.parseInt(col[0]);
			int [][] box = new int[number][3];
			List<String> nums = new ArrayList<String>();
			String[] j;
			//put the numbers into an ArrayList
			for(int x=1; x<(number+1); x++){
				int z = 0;
					j = col[x].split(",");
					nums.add(j[z]);
					z++;
					nums.add(j[z]);
					z++;
					nums.add(j[z]);
					z++;
			}
			int y = 0;
			//put the dimensions into an Array
			for(int x=0; x<number; x++){
				box[x][0] = Integer.parseInt(nums.get(y));
				y++;
				box[x][1] = Integer.parseInt(nums.get(y));
				y++;
				box[x][2] = Integer.parseInt(nums.get(y));
				y++;
			}
			int boxNum = 0;
			for(int x=0; x<number-1; x++){
				if(((box[x][0]<box[x+1][0])&&(box[x][1]<box[x+1][1])&&(box[x][2]<box[x+1][2])) ||
						((box[x][0]<box[x+1][1])&&(box[x][1]<box[x+1][2])&&(box[x][2]<box[x+1][0])) ||
						((box[x][0]<box[x+1][2])&&(box[x][1]<box[x+1][0])&&(box[x][2]<box[x+1][1])) ||
						(box[x][0]<box[x+1][2])&&(box[x][1]<box[x+1][1])&&(box[x][2]<box[x+1][0])
						){
					boxNum++;
				}
			}
			System.out.println(boxNum+1);
			in.close();
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
			
		}
}
