package algorithm.BST;

import org.junit.Assert;
import org.junit.Test;

import algorithm.BST.Node.CreateTree;
/**
 * 
 * @author Harsh Maheshwari
 *
 */
public class PreOrderTraversalTest {

	
	@Test
	public void taversalTest() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[] { 1,2,3,4,5 });
		ITraverse<Integer> preOrder = new PreOrderTraversal<>();
		preOrder.traverse(actual);
	}

	@Test
	public void printTreeTest() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[] {1,2,3,4,5 });
		ITraverse<Integer> preOrder = new PreOrderTraversal<>();
		preOrder.printBinaryTree(actual, 0);
	}

	@Test
	public void nonRecursiveInOrderTraversalTest() {
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[] { 2, 3, 1, 4, 5 });
		ITraverse<Integer> preOrder = new PreOrderTraversal<>();
		preOrder.nonRecursiveTraverse(actual);
	}

	@Test
	public void findLenghtTest(){
		Node.CreateTree<Integer> bst = new CreateTree<>();
		Node<Integer> actual = bst.getTree(new Integer[]{1,2,3,4,5});
		ITraverse<Integer> preorder = new PreOrderTraversal<>();
		int actuallenght = preorder.findLenght(actual);
		Assert.assertEquals(5, actuallenght);
		
		
	}
}
