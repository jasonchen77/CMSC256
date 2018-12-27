/**
 * Tester class for A3_Q3
 * @author Jason Chen
 *
 */

public class A3_Q3Tester {

	public static void main(String[] args){
		//create the arrays
		int[] array1 = {1, 1, 2, 3, 4, 5};
		int[] array2 = {1, 0, 1, 2, 3, 4};

		A3_Q3 a1 = new A3_Q3();
		//should return true
		System.out.println(a1.indexEquals(array1));
		A3_Q3 a2 = new A3_Q3();
		//should return false
		System.out.println(a2.indexEquals(array2));
	}
	
}
