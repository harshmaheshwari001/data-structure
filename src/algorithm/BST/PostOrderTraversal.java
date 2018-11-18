package algorithm.BST;

import java.util.Stack;
/**
 * 
 * @author Harsh Maheshwari
 *
 * @param <T>
 */
public class PostOrderTraversal<T> extends AbstractTree<T> implements ITraverse<T> {
	/**
	 * 
	 * Left ,Right and Root
	 * 
	 */
	@Override
	public void traverse(Node<T> node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		traverse(node.getLeft());
		traverse(node.getRight());
		System.out.println(node.getData());
	}

	/**
	 * 1.1 Create an empty stack 2.1 Do following while root is not NULL a) Push
	 * root's right child and then root to stack. b) Set root as root's left
	 * child. 2.2 Pop an item from stack and set it as root. a) If the popped
	 * item has a right child and the right child is at top of stack, then
	 * remove the right child from stack, push the root back and set root as
	 * root's right child. b) Else print root's data and set root as NULL. 2.3
	 * Repeat steps 2.1 and 2.2 while stack is not empty.
	 * 
	 * 
	 * 
	 */
	@Override
	public void nonRecursiveTraverse(Node<T> root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;

		Stack<Node<T>> stack = new Stack<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				stack.push(root);
				root = root.left;
			}

			// Check for empty stack
			if (stack.empty())
				return;
			root = stack.pop();

			if (!stack.empty() && stack.peek() == root)
				root = root.right;

			else {

				System.out.print(root.data + " ");
				root = null;
			}
		}

	}
	public void printLeftTree(Node<T> root){
		if(root ==null) return;
		 
		 System.out.println(root.getData());
		 
		 printLeftTree(root.getLeft());
		 printLeftTree(root.getRight());
	}

	public static void main(String args[]) {
		PostOrderTraversal<Integer> tree = new PostOrderTraversal<>();
		Node<Integer> node = new Node<>();
		node.data = 1;
		node.left = new Node<Integer>(2);
		node.right = new Node<>(3);
		node.left.left = new Node<>(4);
		node.left.right = new Node<>(5);
		node.right.left = new Node<>(6);
		node.right.right = new Node<>(7);
		node.left.left.right = new Node<>(10);
		node.left.left.right.left = new Node<>(11);
		tree.nonRecursiveTraverse(node);
		System.out.println();
		tree.printBinaryTree(node, 0);
		System.out.println();
		System.out.println(tree.findLenght(node));
		System.out.println();
		System.out.println(tree.findHeight(node, 0));
		System.out.println();
		tree.printLeftTree(node.getLeft());
	}

	/**
	 * find length of Tree Using in POST Order way
	 */
	@Override
	public int findLenght(Node<T> node) {
		// TODO Auto-generated method stub
		int lenght = 0;
		if (node == null)
			return lenght;
		int leftlenght = findLenght(node.getLeft());
		int rightlenght = findLenght(node.getRight());

		return leftlenght + rightlenght + 1;
	}

	public int findHeight(Node<T> node, int level) {
		//System.out.println("level - " + level);
		if (node == null) {
			//System.out.println("level - " + level);
			return level;
		}
		int lh = findHeight(node.getLeft(), level + 1);
		int rh = findHeight(node.getRight(), level + 1);
		System.out.printf("\nMath.max(lh, rh) = [%s]", Math.max(lh, rh));
		return Math.max(lh, rh);
	}
}
