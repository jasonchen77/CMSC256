import java.util.Iterator;
import java.util.LinkedList;

/**
 * This is a Hashset program
 * @author Jason Chen
 *
 */
public class MyStringHash {

	private int size;
	private LinkedList[] table;
	
	/**
	 * Constructor
	 * @param size the size of array or m
	 */
	public MyStringHash(int size){
		this.size = size;
		table = new LinkedList[size];
	}
	/**
	 * 
	 * @param s the value to be add
	 * @return true if added successfully
	 */
	boolean add(String s){
		if (!contains(s)){
			int index = s.hashCode() % size;
			if(table[index]==null){
				table[index] = new LinkedList();
			}
			table[index].add(s);
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param s the value to be remove
	 * @return true if removed successfully
	 */
	boolean remove(String s){
		if (contains(s)){
			int index = s.hashCode() % size;
			table[index].remove(s);
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param s the value to be check
	 * @return true if contains the value
	 */
	boolean contains(String s){
		int index = s.hashCode() % size;
		if(table[index]!=null){
			Iterator itr = table[index].iterator();
			while(itr.hasNext()){
				Object element = itr.next();
				if (element.equals(s)){
					return true;
				}
			}
		}
		return false;
	}
}
