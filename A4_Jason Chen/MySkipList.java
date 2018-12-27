/**
 * This is a Skip List program
 * @author Jason Chen
 *
 * @param <T> The data type
 */

public class MySkipList<T extends Comparable<T>> {

	private Node head = null;
	private Node bottom = null;
	private Node tail = null;
	private int size;
	private int infinity;
	
	//Constructor
	public MySkipList(int infinity){
		this.infinity = infinity;
		bottom = new Node(0, null, null);
		bottom.next = bottom.below = bottom;
		tail = new Node(infinity, null, null);
		tail.next = tail;
		head = new Node(infinity, tail, bottom);
		size=0;
	}
	/**
	 * 
	 * @param e the element to search
	 * @return true if contains the element
	 */
	public boolean skipSearch(T e){
		Node current = head;
		//while(current.below!=bottom){
			//current = current.below;
			while(e.compareTo((T)current.element)>0 && current.next!=tail){
				current = current.next;
				if(e.equals(current.element)){
					return true;
				}
			}
		//}
		return false;
	}
	
	/**
	 * 
	 * @param e the element to insert
	 */
	public void skipInsert(T e){
		Node current = head;
		while (current.below != bottom){
			current = current.below;
			while(e.compareTo((T)current.element)>0 && current.next!=tail){
				current = current.next;
			}
		}
		Node temp = new Node(e, current.next, current.below);
		current.setNext(temp);
		size++;
	}
	/**
	 * 
	 * @param e the element to remove
	 */
	public void skipRemove(T e){
		Node current = head;
		//while(current.below!=bottom){
			//current = current.below;
			while(e.compareTo((T)current.element)>0 && current.next!=tail){
				current = current.next;
				if(e.equals(current.element)){
					current.next.setPrevious(current.next);
					size--;
				}
			}
		//}
	}
	
	//Node class
	private static class Node<T>{
		private T element;
		private Node<T> next = null;
		private Node<T> previous = null;
		private Node<T> above = null;
		private Node<T> below = null;
		public Node(T element, Node next, Node below){
			this.element = element;
			this.next = next;
			this.below = below;
		}
		public T getElement() {
			return element;
		}
		public void setElement(T element) {
			this.element = element;
		}
		public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
		public Node<T> getPrevious() {
			return previous;
		}
		public void setPrevious(Node<T> previous) {
			this.previous = previous;
		}
		public Node<T> getAbove() {
			return above;
		}
		public void setAbove(Node<T> above) {
			this.above = above;
		}
		public Node<T> getBelow() {
			return below;
		}
		public void setBelow(Node<T> below) {
			this.below = below;
		}
	}
}
