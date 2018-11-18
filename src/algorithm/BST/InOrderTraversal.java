package algorithm.BST;

import java.util.Stack;

/**
 * 
 * 
 * @author harsmahe
 *
 * @param <T>
 */
public class InOrderTraversal<T> extends AbstractTree<T> implements ITraverse<T> {
	/**
	 * Left, Root, Right
	 */
	@Override
	public void traverse(Node<T> node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		traverse(node.getLeft());
		System.out.print(node.getData() + " , ");
		traverse(node.getRight());
	}

	@Override
	public void nonRecursiveTraverse(Node<T> node) {
		System.out.println();
		// TODO Auto-generated method stub
		if (node == null)
			return;
		Stack<Node<T>> stack = new Stack<>();
		while (true) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}

			if (stack.isEmpty()) {
				break;
			}

			node = stack.pop();
			System.out.print(node.getData() + " , ");
			node = node.getRight();

		}
		return;
	}

	/**
	 * Find length of Left,Root & right recursively
	 */
	@Override
	public int findLenght(Node<T> root) {
		int lenght = 0;
		if (root == null) {
			return lenght;
		}
		// TODO Auto-generated method stub
		return findLenght(root.getLeft()) + 1 + findLenght(root.getRight());
	}

}
