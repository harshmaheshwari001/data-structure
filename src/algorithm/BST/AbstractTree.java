package algorithm.BST;
/**
 * 
 * @author Harsh Maheshwari
 *
 * @param <T>
 */
public class AbstractTree<T> {

	public void printBinaryTree(Node<T> root, int level) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		printBinaryTree(root.getRight(), level + 1);
		if (level != 0) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("|\t");
			}
			System.out.println("|------(" + root.getData()+")");
		} else {
			System.out.println("("+root.getData()+")");
		}
		printBinaryTree(root.getLeft(), level + 1);

	}
}
