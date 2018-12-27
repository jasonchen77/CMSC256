/**
 * This program checks if A[i] = i
 * @author Jason Chen
 *
 */

public class A3_Q3 {
	
	//constructor
	public A3_Q3(){
		
	}
	//return false if not equal, true if equal
	public boolean indexEquals(int[] a){
		int start = 0;						//c1 1
		int end = a.length-1;				//c2 1
		while(start<=end){					//c3 logn+1
			int mid = (start+end)/2;		//c4 logn
			if(a[mid]==mid){				//c5 logn
				//true if equal
				return true;				//c6 logn
			}
			else if(a[mid]<mid){			//c7 logn
				//cut in half
				end = mid -1;				//c8 logn
			}
			else if (a[mid]>mid){			//c9 logn
				//cut in half
				start = mid + 1;			//c10 logn
			}
		}
		return false;						//c11 1
	}
	//Total = c1+c2+(logn+1)*c3+(logn)*c4+(logn)*c5+(logn)*c7+(logn)*c9+max((logn)*c6,(logn)*c8,(logn)*c10)+c11
	//O(logn)
	/**
	boolean equals = false;					//c1 1
	public boolean indexEquals(int[] a){	
		for(int i=0; i<Math.log(a.length); i++){		//c2 log(n)+1
			if(a[i] == i){					//c3 1
				equals = true;				//c4 1
			}
		}
		return equals;						//c5 1
	}

//total = log(n)+5  O(log(n))
*/

}