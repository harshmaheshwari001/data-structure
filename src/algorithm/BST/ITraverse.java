package algorithm.BST;

public interface ITraverse<T> {

	public void traverse(Node<T> node);

	public void nonRecursiveTraverse(Node<T> node);

	public void printBinaryTree(Node<T> root, int level);
	
	public int findLenght(Node<T> root);
}
