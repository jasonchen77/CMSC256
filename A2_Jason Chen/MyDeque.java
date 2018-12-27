import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MyDeque class
 * @author Jason Chen
 *
 */
public class MyDeque<E> implements Deque<E>{
	
	//instance variables
	private E[] deque;
	private int max;
	private int head = 0;
	private int tail = 0;
	private int size = 0;
	
	//constructor
	public MyDeque(int cap) {
		max = cap;
		deque = (E[]) new Object[max];
	}

	/**
	 * 
	 * @param c the Collection that will add to Deque
	 * @return true if added, false if not
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean added = true;
		for(E e : c){
			if (!add(e)) {
				added = false;
			}
		}
		return added;
	}

	/**
	 * clear the Deque
	 */
	@Override
	public void clear() {
		deque = null;
	}

	/**
	 * 
	 * @param c the Collection to be checked
	 * @return true if constains all
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		 for (Object e : c) {
			 if (!contains(e)) {
				 return false;
			 }
		 }
		    return true;
	}

	//true if empty
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * 
	 * @param c the elements to be removed
	 * @return true if removed
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean removed = true;
		for(Object e : c){
			if (!remove(e)) {
				removed = false;
			}
		}
		return removed;
	}

	/**
	 * 
	 * @param c the new elements
	 * @return true if added
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		E[] temp = (E[]) new Object[max];
		int i = 0;
		if (c != null){
			for (Object e : c){
				temp[i] = (E) e;
			}
			clear();
			deque = temp;
			return true;
		}
		return false;
	}

	//return the array
	@Override
	public Object[] toArray() {
		return toArray(deque);
	}

	/**
	 * 
	 * @param a the new array
	 * @return the new array
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		int i = 0;
		for(E e : deque){
			a[i] = (T) e;
			i++;
		}
		return a;
	}

	/**
	 * 
	 * @param e element to be added
	 * @return true if added
	 * @throws IllegalStateException
	 */
	@Override
	public boolean add(E e) throws IllegalStateException{
		if (size == max){
			throw new IllegalStateException("Over Capacity");
			//return false;
		}
		else {
			deque[size] = e;
			size++;
			tail = size;
			return true;
		}
	}

	/**
	 * 
	 * @param e the element to be added
	 */
	@Override
	public void addFirst(E e) throws IllegalStateException{
		if (size == max){
			throw new IllegalStateException("Over Capacity");
		}
		else {
			E[] temp = (E[]) new Object[max];
			temp[0] = e;
			for(int i=0; i<max; i++){
				if ((i+1)==max){
					break;
				}
				temp[i+1] = deque[i];
			}
			deque = temp;
			size++;
			tail = size;
		}
	}

	/**
	 * 
	 * @param e the element to be added
	 */
	@Override
	public void addLast(E e) throws IllegalStateException{
		if (size == max){
			throw new IllegalStateException("Over Capacity");
		}
		else {
			deque[size] = e;
			size++;
			tail = size;
		}
	}

	/**
	 * 
	 * @param o the object to be checked
	 * @return true if contains
	 */
	@Override
	public boolean contains(Object o) {
		boolean contain = false;
		for(int i=0; i<size; i++) {
			if (deque[i].equals(o)) {
				contain = true;
			}
		}
		return contain;
	}

	//iterator in descending order
	@Override
	public Iterator<E> descendingIterator() {
		Iterator<E> ite = new Iterator<E>(){
			
			private int current = size;
			
			@Override
            public boolean hasNext() {
                return current > 0 && deque[current] != null;
            }
			
			@Override
			public E next() {
				return deque[current--];
			}
		};
		return ite;
	}

	//returns the first element
	@Override
	public E element() {
		return (deque[head]);
	}

	//returns the first element
	@Override
	public E getFirst() {
		return (deque[head]);
	}

	//returns the last element
	@Override
	public E getLast() {
		return (deque[size-1]);
	}

	//the iterator
	@Override
	public Iterator<E> iterator() {
		Iterator<E> ite = new Iterator<E>(){
			
			private int current = 0;
			
			@Override
            public boolean hasNext() {
                return current < size && deque[current] != null;
            }
			
			@Override
			public E next() {
				return deque[current++];
			}
		};
		return ite;
	}

	/**
	 * 
	 * @param e the element to be added
	 * @return true if added
	 */
	@Override
	public boolean offer(E e) {
		if (size == max){
			System.out.println("Over Capacity");
			return false;
		}
		else {
			deque[size] = e;
			size++;
			tail = size;
			return true;
		}
	}

	/**
	 * 
	 * @param e the element to be added
	 * @return true if added
	 */
	@Override
	public boolean offerFirst(E e) {
		if (size == max){
			System.out.println("Over Capacity");
			return false;
		}
		else {
			E[] temp = (E[]) new Object[max];
			temp[0] = e;
			for(int i=0; i<max; i++){
				if ((i+1)==max){
					break;
				}
				temp[i+1] = deque[i];
			}
			deque = temp;
			size++;
			tail = size;
			return true;
		}
	}

	/**
	 * 
	 * @param e the element to be added
	 * @return true if added
	 */
	@Override
	public boolean offerLast(E e) {
		if (size == max){
			System.out.println("Over Capacity");
			return false;
		}
		else {
			deque[size] = e;
			size++;
			tail = size;
			return true;
		}
	}

	//returns the first element
	@Override
	public E peek() {
		if(size==0){
			return null;
		}else {
			return (deque[head]);
		}
	}

	//returns the first element
	@Override
	public E peekFirst() {
		if(size==0){
			return null;
		}else {
			return (deque[head]);
		}
	}

	//returns the last element
	@Override
	public E peekLast() {
		if(size==0){
			return null;
		}else {
			return (deque[size-1]);
		}
	}

	//removes and returns the first element
	@Override
	public E poll() {
		if (size==0) {
			return null;
		}
		else {
			E tempHead = deque[head];
			E[] temp = (E[]) new Object[max];
			for (int i=0; i<size; i++) {
				if((i+1)==max){
					break;
				}
				temp[i] = deque[i+1];
			}
			size--;
			deque = temp;
			return tempHead;
		}
	}

	//returns and removes the first element
	@Override
	public E pollFirst() {
		if (size==0) {
			return null;
		}
		else {
			E tempHead = deque[head];
			E[] temp = (E[]) new Object[max];
			for (int i=0; i<size; i++) {
				if((i+1)==max){
					break;
				}
				temp[i] = deque[i+1];
			}
			size--;
			deque = temp;
			return tempHead;
		}
	}

	//returns and removes the last element
	@Override
	public E pollLast() {
		if (isEmpty()) {
			return null;
		}
		else {
			E tempLast = deque[size];
			deque[size] = null;
			size--;
			return tempLast;
		}
	}

	//returns and removes the first element
	@Override
	public E pop() throws NoSuchElementException{
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		else {
			E tempHead = deque[head];
			E[] temp = (E[]) new Object[max];
			for (int i=0; i<size; i++) {
				if((i+1)==max){
					break;
				}
				temp[i] = deque[i+1];
			}
			size--;
			deque = temp;
			return tempHead;
		}
	}

	/**
	 * 
	 * @param e the element to be added
	 */
	@Override
	public void push(E e) throws IllegalStateException{
		if (size == max){
			throw new IllegalStateException("Over Capacity");
		}
		else {
			E[] temp = (E[]) new Object[max];
			temp[0] = e;
			for(int i=0; i<max; i++){
				if((i+1)==max){
					break;
				}
				temp[i+1] = deque[i];
			}
			deque = temp;
			size++;
			tail = size;
		}
	}

	//removes and returns the first element
	@Override
	public E remove() throws NoSuchElementException{
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		else {
			E tempHead = deque[head];
			E[] temp = (E[]) new Object[max];
			for (int i=0; i<size; i++) {
				if ((i+1)==max){
					break;
				}
				temp[i] = deque[i+1];
			}
			size--;
			deque = temp;
			return tempHead;
		}
	}

	/**
	 * 
	 * @param o the object to be removed
	 * @return true if removed
	 */
	@Override
	public boolean remove(Object o) {
		boolean removed = false;
		int timesRemoved = 0;
		for(int i=0; i<(size-1); i++) {
			if ((deque[size-1])!=null && deque[size-1].equals(o)){
				deque[size-1] = null;
				timesRemoved++;
				removed = true;
			}
			if (deque[i]!=null && deque[i].equals(o)) {
				for(int j=i; j<(size-1); j++){
				deque[j] = deque[j+1];
				}
				timesRemoved++;
				removed = true;
			}
		}
		size -= timesRemoved;
		return removed;
	}

	//return and removes first element
	@Override
	public E removeFirst() throws NoSuchElementException{
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		else {
			E tempHead = deque[head];
			E[] temp = (E[]) new Object[max];
			for (int i=0; i<size; i++) {
				if((i+1)==max){
					break;
				}
				temp[i] = deque[i+1];
			}
			size--;
			deque = temp;
			return tempHead;
		}
	}

	/**
	 * 
	 * @param o the first object to be removed
	 * @return true if removed
	 */
	@Override
	public boolean removeFirstOccurrence(Object o) {
		boolean removed = false;
		boolean first = true;
		int timesRemoved = 0;
		for(int i=0; i<size-1; i++) {
			if ((i+1)==max && deque[i].equals(o)){
				deque[i]=null;
				timesRemoved++;
				removed = true;
			}
			else if (deque[i].equals(o) && first) {
				deque[i] = null;
				deque[i] = deque[i+1];
				i--;
				timesRemoved++;
				first = false;
				removed = true;
			}
		}
		size -= timesRemoved;
		return removed;
	}

	//returns and removes last element
	@Override
	public E removeLast() throws NoSuchElementException{
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		else {
			E tempLast = deque[size];
			deque[size] = null;
			size--;
			return tempLast;
		}
	}

	/**
	 * 
	 * @param o the last occurrence of object to be removed
	 * @return true if removed
	 */
	@Override
	public boolean removeLastOccurrence(Object o) {
		boolean removed = false;
		boolean first = true;
		int timesRemoved = 0;
		for(int i=size-1; i>1; i--) {
			if ((i-1)==0 && deque[i-1].equals(o)){
				deque[i-1]=null;
				timesRemoved++;
				removed = true;
				for(int j=0; j<size; j++){
					deque[j] = deque[j+1];
				}
			}
			else if (deque[i].equals(o) && first) {
				for (int j=i; j<size-1; j++){
					deque[j] = deque[j+1];
				}
				timesRemoved++;
				first = false;
				removed = true;
			}
		}
		size--;
		return removed;
	}

	//returns the size of Deque
	@Override
	public int size() {
		return this.size;
	}
	
	
}
