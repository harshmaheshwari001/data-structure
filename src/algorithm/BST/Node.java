package algorithm.BST;

import java.util.Arrays;
/**
 * Tree Node data structure
 * @author Harsh Maheshwari
 *
 * @param <T>
 */
public class Node<T> {

	public T data;
	public Node<T> left;
	public Node<T> right;

	public Node() {
		super();
	}

	public Node(T data) {
		super();
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
	/**
	 * Static class to create Tree from passed array
	 * @author Harsh Maheshwari
	 *
	 * @param <T>
	 */
	public static class CreateTree<T> {

		public Node<T> getTree(T[] elements) {
			for (int i = 0; i < elements.length;) {
				Node<T> root = new Node<>();
				if (elements.length <= 1) {
					// set node
					root.setData(elements[0]);
					return root;
				}
				root.setLeft(getTree(Arrays.copyOfRange(elements, 0, elements.length / 2)));
				root.setRight(getTree(Arrays.copyOfRange(elements, (elements.length / 2) + 1, elements.length)));
				//set root node
				root.setData(elements[elements.length/2]);
				
				return root;
			}
			return null;
		}
	}
}
