package algorithm.BST;

import org.junit.Assert;

import algorithm.BST.Node.CreateTree;

public class BSTTest {

	// @Test
	public void createTree() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[] { 2, 3, 1, 4, 5 });
		System.out.println(actual);
		Node<Integer> expected = new Node<>(1);
		expected.setLeft(new Node<Integer>(2));
		expected.setRight(new Node<Integer>(3));

		Assert.assertEquals(expected, actual);
	}

	

	


	

	//@Test
	public void findMax() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> node = bst.getTree(new Integer[] { 2, 3, 1, 4, 5 });
		PreOrderTraversal<Integer> preOrder = new PreOrderTraversal<>();
		Integer actual = preOrder.findMax(node);
		Integer expected = 5;
		Assert.assertEquals(expected, actual);
	}

//	@Test
	public void findMin() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> node = bst.getTree(new Integer[] { 2, 3, 1, 4, 5 });
		PreOrderTraversal<Integer> preOrder = new PreOrderTraversal<>();
		Integer actual = preOrder.findMin(node);
		Integer expected = 1;
		Assert.assertEquals(expected, actual);
	}
}
