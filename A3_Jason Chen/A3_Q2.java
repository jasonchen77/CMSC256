import java.util.ArrayList;

/**
 * This is a priority queue program
 * @author Jason Chen
 *
 */
public class A3_Q2 {
	
	public static class MyPriorityQueue{
	private ArrayList<Integer> binMinHeap;
	public MyPriorityQueue( ){
	binMinHeap = new ArrayList<Integer>();
	binMinHeap.add(null);
	}
	// Removes and returns item in priority queue with smallest priority
	public Integer dequeue(){
	Integer toReturn = binMinHeap.get(1);
	binMinHeap.set(1,binMinHeap.remove(binMinHeap.size()-1));
	bubbleDown(1);
	return toReturn;
	}
	// Adds item to priority queue
	public void enqueue(Integer item){
	binMinHeap.add(item);
	bubbleUp(binMinHeap.size()-1);
	}
	//Swaps the elements at index1 and index2 of the binary min heap
	private void swap(int index1, int index2){
	int temp = binMinHeap.get(index1);
	binMinHeap.set(index1,binMinHeap.get(index2));
	
	binMinHeap.set(index2, temp);
	}
	//Bubbles up the element in the binary min heap array list at given index
	private void bubbleUp (int index){
	while((index)/2 > 0 && binMinHeap.get(index) <
	binMinHeap.get((index)/2)){
	swap(index, (index)/2);
	index = (index)/2;
	}
	}
	//Bubbles down the element in the binary min heap array list at given index
	private void bubbleDown (int index){
	int n = binMinHeap.size();
	while((index * 2+1) < n && (binMinHeap.get(index) >
	binMinHeap.get(index * 2+1))){
	if(binMinHeap.get(index * 2) > binMinHeap.get(index * 2+1)){
		swap((index * 2), (index * 2+1));
	}
	swap(index, index * 2);
	index = index * 2;
	}
	}
	}
}
