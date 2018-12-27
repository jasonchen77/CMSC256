import java.util.Stack;


/**
 * This program checks if Tree is a BST
 * @author Jason Chen
 *
 */
public class A3_Q1 {

	public static class BST<T extends Comparable<T>> {
		T root;
		BST<T> left;
		BST<T> right;
		BST<T> parent;
		//constructor
		public BST(){
			root = null;
			left = null;
			right = null;
			parent = null;
		}
		//constructor
		public BST(T e, BST<T> parent, BST<T> left, BST<T> right){
			this.root = e;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		
		//getters
				public T getElement() {
					return root;
				}
				public BST<T> getParent() {
					return parent;
				}
				public BST<T> getLeft() {
					return left;
				}
				public BST<T> getRight() {
					return right;
				}
				public BST<T> getRoot() {
					return rt;
				}
				//setters
				public void setElement(T e) {
					root = e;
				}
				public void setParent(BST<T> parentNode) {
					parent = parentNode;
				}
				public void setLeft(BST<T> left) {
					this.left = left;
				}
				public void setRight(BST<T> right) {
					this.right = right;
				}
		private int size = 0;
		BST<T> rt;
		protected BST<T> createNode(T e, BST<T> parent, BST<T> left, BST<T> right){
			return new BST<T>(e, parent, left, right);
		}
		 /* Add root node in the tree */
		 public BST<T> addRoot(T r) throws IllegalStateException{
		  if (size!=0){
		   throw new IllegalStateException("Not empty");
		  }
		  rt = createNode(r, null, null, null);
		  size = 1;
		  return rt;
		 }
		 //add the left child
		 public BST<T> addLeft(BST<T> p, T e){
			 if (p.left!=null){
				   throw new IllegalStateException("Not empty");
			 }
			 BST<T> child = createNode(e, p, null, null);
			 p.setLeft(child);
			 size++;
			 return child;
		 }
		 //add the right child
		 public BST<T> addRight(BST<T> p, T e){
			 if (p.right!=null){
				   throw new IllegalStateException("Not empty");
			 }
			 BST<T> child = createNode(e, p, null, null);
			 p.setRight(child);
			 size++;
			 return child;
		 }
		 
		boolean valid = true;
		boolean isValidBST( BST<T> Tree ){
			
				Stack<BST<T>> n = new Stack();
				n.push(Tree.getRoot());
				while(!n.isEmpty()){
					BST<T> first = n.pop();
					if(first.getLeft()!=null){
						//if parent is greater than left child, return false
						if(first.getElement().compareTo(first.getLeft().getElement())<0){
							valid = false;
						}
						n.push(first.getLeft());
					}
					if(first.getRight()!=null){
						//if parent is less than right child, return false
						if(first.getElement().compareTo(first.getRight().getElement())>0){
							valid = false;
						}
						n.push(first.getRight());
					}
				}
				return valid;
				
			/**
			//base case
			if (Tree.getRoot().getElement()==null){
				return valid;
			}
			//if root is less than left child or greater than right child, return false
			if((Tree.left!=null && (Tree.getRoot().getElement()).compareTo(Tree.getLeft().getElement())<0 )||
					(Tree.right!=null && (Tree.getRoot().getElement()).compareTo(Tree.getRight().getElement())>0)) {
				valid = false;
				return valid;
			}
			//call the recursion
			return isValidBST(Tree.left) && isValidBST(Tree.right);
			*/
			/**
			if(Tree.getLeft()!=null){
				return isValidBST(Tree.left);
			}
			else if(Tree.getRight()!=null){
				return isValidBST(Tree.right);
			}
			else {
				return valid;
			}
			*/
			
		}
	}
}
