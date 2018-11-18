package algorithm.BST;

import org.junit.Assert;
import org.junit.Test;

import algorithm.BST.Node.CreateTree;

public class PostOrderTraversalTest {

	@Test
	public void postOrderTraversalTest() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[] { 2, 3, 1, 4, 5 });
		ITraverse<Integer> preOrder = new PostOrderTraversal<>();
		preOrder.traverse(actual);
	}

	@Test
	public void printTreeTest() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[] { 2, 3, 1, 4, 5 });
		ITraverse<Integer> postOrder = new PostOrderTraversal<>();
		postOrder.printBinaryTree(actual, 0);
	}

	@Test
	public void nonRecursiveTraverseTest() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[] { 2, 3, 1, 4, 5 });
		ITraverse<Integer> postOrder = new PostOrderTraversal<>();
		postOrder.nonRecursiveTraverse(actual);
	}

	@Test
	public void findLengthTest() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[] { 2, 3, 1, 4, 5 });
		ITraverse<Integer> postOrder = new PostOrderTraversal<>();
		int actualLenght = postOrder.findLenght(actual);
		Assert.assertEquals(5, actualLenght);

	}
}
