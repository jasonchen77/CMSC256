/**
 * This is a quick sort program
 * @author Jason Chen
 *
 */
public class MyQuicksort {

	private static int[] array;
	//Constructor
	public MyQuicksort(){
		
	}
	public static int[] quicksort(int[] a){
		array = a;
		return sort(array, 0, array.length-1);
	}
	/**
	 * 
	 * @param a the array to be sorted
	 * @param start the start index
	 * @param end the end index
	 * @return the sorted array
	 */
	public static int[] sort(int[] a, int start, int end){
		if (a==null || a.length==0){
			return a;
		}
		if (start>end){
			return a;
		}
		int x = start;
		int y = end;
		//the pivot
		int pivot = a[start+(end-start)/2];
		while(x<=y){
			while(a[x]>pivot){
				x++;
			}
			while(a[y]<pivot){
				y--;
			}
			if(x<=y){
				swap(a, x, y);
				x++;
				y--;
			}
		}
		if(start<y){
			sort(a, start, y);
		}
		if(x<end){
			sort(a, x, end);
		}
		return a;
	}
	
	/**
	public static int[] sort(int[] a, int start, int end){
		int div = start;
		int pivot = a[(end)/2];
		for(int p=start; p<=end; p++){
			if(a[p]>pivot){
				swap(a, div++, p);
			}
		}
		//swap(a, div, end/2);
		if(start<div){
			sort(a, start, div);
		}
		if(div<end-1){
			sort(a, div, end-1);
		}
		return a;
	}
	*/
	//the swap method
	private static void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
