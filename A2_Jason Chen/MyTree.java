import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author Jason Chen
 *
 * @param <E> the generic type
 */
public class MyTree<E> {

	public static class Node<E> {
		private int element;
		private Node<E> parent;
		private LinkedList <Node<E>> children;
		
		//constructor
		public Node() {
			super();
			children = new LinkedList<Node<E>>();
			parent = null;
		}
		//constructor with parameter
		public Node(int e, Node<E> parent, LinkedList <Node<E>> children){
			this();
			element = e;
			this.parent = parent;
			this.children = children;
		}
		//getters
		public int getElement() {
			return element;
		}
		public Node<E> getParent() {
			return parent;
		}
		public LinkedList <Node<E>> getChildren() {
			return children;
		}
		//setters
		public void setElement(int e) {
			element = e;
		}
		public void setParent(Node<E> parentNode) {
			parent = parentNode;
		}
		public void setChildren(LinkedList <Node<E>> children) {
			this.children = children;
		}
		public void addChild(Node<E> ch){
			children.add(ch);
		}
	}
	
	private Node<E> root;
	private int size = 0;
	
	protected Node<E> createNode(int e, Node<E> parent, LinkedList <Node<E>> children){
		return new Node<E>(e, parent, children);
	}
	
	/* Add root node in the tree */
	public Node<E> addRoot(int r) throws IllegalStateException{
		if (size!=0){
			throw new IllegalStateException("Not empty");
		}
		root = createNode(r, null, new LinkedList<MyTree.Node<E>>());
		size = 1;
		return root;
	}
	
	public Node<E> getRoot() {
		return root;
	}
	
	/* add a child node to the right most positions.
	* @param node the parent node which will have a new child node.
	* @param c the element of the new child.
	* @return the new child node.
	*/
	public Node<E> addChild(Node<E> node, int c) {
		Node<E> parent = node;
		Node<E> child = createNode(c, parent, new LinkedList<MyTree.Node<E>>());
		parent.addChild(child);
		size++;
		return child;
	}
	/* Returns true if the tree is a complete tree */
	public boolean isComplete(){
		boolean full = true;
		Queue<Node<E>> n = new LinkedList<Node<E>>();
		n.add(root);
		int upperSize = root.getChildren().size();
		while(!n.isEmpty()){
			Node<E> first = n.remove();
			if(first.getChildren() != null){
				if(upperSize != first.getChildren().size()){
					full = false;
				}else{
					full = true;
				}
			}
			for(Node<E> child : first.getChildren()){
				if(child.getChildren().size()!=0){
				n.add(child);
				}
			}
		}
		return full;
	}
	
	/* Returns true if the tree is a full tree */
	public boolean isFull() {
		boolean full = true;
		Queue<Node<E>> n = new LinkedList<Node<E>>();
		n.add(root);
		int upperSize = root.getChildren().size();
		while(!n.isEmpty()){
			Node<E> first = n.remove();
			if(first.getChildren() != null){
				if(upperSize != first.getChildren().size()){
					full = false;
				}else{
					full = true;
				}
			}
			for(Node<E> child : first.getChildren()){
				if(child.getChildren().size()!=0){
				n.add(child);
				}
			}
		}
		return full;
	}
	
	/* Print the preorder traversal result of the tree.
	* @param r the root node of the subtree to be traversed
	*/
	public void preOrderTraversal(Node<E> r) {
		Stack<Node<E>> n = new Stack();
		n.push(r);
		while(!n.isEmpty()){
			Node<E> first = n.pop();
			System.out.print(first.getElement() + ", ");
			for(int i = first.children.size()-1; i>=0; i--){
				Node<E> child = first.getChildren().get(i);
				n.push(child);
			}
		}
		System.out.println();
	}
	/* Print the postorder traversal result of the tree.
	* @param r the root node of the subtree to be traversed
	*/
	public void postOrderTraversal(Node r) {
		Stack<Node<E>> n = new Stack();
		Queue<Node<E>> q = new LinkedList<Node<E>>();
		n.push(r);
		while(!n.isEmpty()){
			Node<E> first = n.pop();
			//System.out.print(first.getElement() + ", ");
			int j = 0;
			for(int i = first.children.size()-1; i>=0; i--){
				Node<E> child = first.getChildren().get(i);
				n.push(child);
				Node<E> ch = first.getChildren().get(j);
				q.add(ch);
				j++;
			}
			
		}
		q.add(r);
		while(!q.isEmpty()){
			Node<E> num = q.remove();
			System.out.print(num.getElement() + ", ");
		}
		System.out.println();
	}
	/* Print the breath-first traversal result of the tree.
	* @param r the root node of the subtree to be traversed
	*/
	public void breathFirstTraversal(Node<E> r) {
		/**
		if (r==null){
			return;
		}
		r.getChildren().get(index)
		Queue 
		System.out.print(r.element + ", ");
		while(r.children.iterator().hasNext()){
			breathFirstTraversal(r.children.iterator().next());
		}
		*/
		Queue<Node<E>> n = new LinkedList<Node<E>>();
		n.add(r);
		while(!n.isEmpty()){
			Node<E> first = n.remove();
			System.out.print(first.getElement() + ", ");
			for(Node<E> child : first.getChildren()){
				n.add(child);
			}
		}
		System.out.println();
	}
	
}
