import java.util.LinkedList;
import java.util.Queue;

/**
 * This program prints the result of breadth first search of adjacency matrix.
 * @author Jason
 *
 */
public class A5_Q1 {
	//Constructor
	public A5_Q1(){
		
	}
	
	/**
	 * 
	 * @param aMatrix the adjacency matrix to be traversed
	 * @param source the starting vertex
	 */
	public static void BFS(int[][] aMatrix, int source){
		int rowLength = aMatrix[source].length;
		//create a new array to keep record of which one is visited
		int[] visited = new int[rowLength];
		//if vistited change 0 to 1
		visited[source] = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		int e;
		
		while(!q.isEmpty()){
			e = q.remove();
			System.out.print(e + " ");
			//go through each element in the row
			for(int i=0; i<rowLength; i++){
				if(aMatrix[e][i]==1 && visited[i]==0){
					q.add(i);
					visited[i]=1;
				}
			}
		}
	}
	
}
