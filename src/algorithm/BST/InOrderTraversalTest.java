package algorithm.BST;

import org.junit.Assert;
import org.junit.Test;

import algorithm.BST.Node.CreateTree;

public class InOrderTraversalTest {

	@Test
	public void inOrderTraversalTest() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[] { 2, 3, 1, 4, 5 });
		ITraverse<Integer> preOrder = new InOrderTraversal<>();
		preOrder.traverse(actual);
	}

	@Test
	public void inOrderTraversalPrintTest() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[] { 2, 3, 1, 4, 5 });
		ITraverse<Integer> preOrder = new InOrderTraversal<>();
		preOrder.printBinaryTree(actual, 0);
	}

	@Test
	public void nonRecursiveInOrderTraversalTest() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[] { 2, 3, 1, 4, 5 });
		ITraverse<Integer> inorder = new InOrderTraversal<>();
		inorder.nonRecursiveTraverse(actual);
	}

	@Test
	public void findLenghtTest() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[] { 1, 2, 3, 4, 5 });
		ITraverse<Integer> preorder = new InOrderTraversal<>();
		int actuallenght = preorder.findLenght(actual);
		Assert.assertEquals(5, actuallenght);

	}
}
