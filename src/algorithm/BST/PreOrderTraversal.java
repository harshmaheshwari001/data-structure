package algorithm.BST;

import java.util.Stack;
/**
 * 
 * @author Harsh Maheshwari
 *
 * @param <T>
 */
public class PreOrderTraversal<T> extends AbstractTree<T> implements ITraverse<T> {

	Node<T> root;

	public PreOrderTraversal() {
		super();
	}

	public PreOrderTraversal(Node<T> root) {
		super();
		this.root = root;
	}

	/**
	 * Root,Left,Right
	 * 
	 */
	@Override
	public void traverse(Node<T> node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		System.out.println(node.getData());
		traverse(node.getLeft());
		traverse(node.getRight());

	}

	/**
	 * Find maximum from a tree
	 * 
	 * @param node
	 * @return
	 */
	public Integer findMax(Node<T> node) {
		Integer max = Integer.MIN_VALUE;
		if (node == null) {
			return max;
		}
		if ((Integer) node.getData() > (Integer) max) {
			max = (Integer) node.getData();
		}
		Integer leftMax = findMax(node.getLeft());
		Integer righMax = findMax(node.getRight());

		if (leftMax > righMax && leftMax > max) {
			return leftMax;
		} else if (righMax > leftMax && righMax > max) {
			return righMax;
		} else {
			return max;
		}
	}

	/**
	 * Find minimum from a tree
	 * 
	 * @param node
	 * @return
	 */
	public Integer findMin(Node<T> node) {
		Integer min = Integer.MAX_VALUE;
		if (node == null) {
			return min;
		}
		if ((Integer) node.getData() < min) {
			min = (Integer) node.getData();
		}
		Integer leftMin = findMax(node.getLeft());
		Integer righMin = findMax(node.getRight());

		if (leftMin < righMin && leftMin < min) {
			return leftMin;
		} else if (righMin < leftMin && righMin < min) {
			return righMin;
		} else {
			return min;
		}
	}

	@Override
	public void nonRecursiveTraverse(Node<T> node) {
		// TODO Auto-generated method stub
		if (node == null)
			return;
		Stack<Node<T>> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			node = stack.pop();
			System.out.println(node.getData());

			if (node.getRight() != null) {
				stack.push(node.getRight());
			}
			if (node.getLeft() != null) {
				stack.push(node.getLeft());
			}
		}

	}

	/**
	 * find length of Root ,left & right tree recursively
	 */
	@Override
	public int findLenght(Node<T> root) {
		int lenght = 0;
		if (root == null) {
			return lenght;
		}
		// TODO Auto-generated method stub
		return 1 + findLenght(root.getLeft()) + findLenght(root.getRight());
	}
}
