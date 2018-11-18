package algorithm.BST;
/**
 * 
 * @author Harsh Maheshwari
 *
 * @param <T>
 */
public class LevelOrderTraversal<T> extends AbstractTree<T> {
	/**
	 * Get height of the tree
	 * 
	 * @param node
	 * @return
	 */
	public int getHeight(Node<Integer> node) {
		if (node == null) {
			return 0;
		}
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;

	}

	public void printLevelOrder(Node<Integer> node) {
		int height = getHeight(node);
		for (int i = 1; i <= height; i++) {
			printGivenLevel(node, i);
		}
	}

	public void printGivenLevel(Node<Integer> node, int level) {
		if (node == null) {
			return;

		} else if (level == 1) {
			System.out.println(node.data);
		} else if (level > 1) {
			printGivenLevel(node.getLeft(), level - 1);
			printGivenLevel(node.getRight(), level - 1);
		}
	}

	public int sumChild(Node<Integer> root) {
		int rootValue = 0;
		if (root == null)
			return 0;
		else {
			System.out.println("root.data" + root.data);
			rootValue = root.data;
			root.data = sumChild(root.getLeft()) + sumChild(root.getRight());
			return rootValue + root.data;
		}

	}

	public Node<Integer> formTreeWithChilrenSumOnly(Node<Integer> root) {
		if (root == null)
			return root;
		else {
			root.data = sumChild(root.getLeft()) + sumChild(root.getRight());
			return root;
		}
	}

	public Node<Integer> formTreeWithNodesWeight(Node<Integer> root) {
		if (root == null)
			return root;
		else {
			root.data = sumChild(root.getLeft()) + sumChild(root.getRight());
			return root;
		}
	}

	public static void main(String args[]) {
		LevelOrderTraversal<Integer> tree = new LevelOrderTraversal<>();
		final Node<Integer> node = new Node<>();
		node.data = 10;
		node.left = new Node<Integer>(-2);
		node.right = new Node<>(6);
		node.left.left = new Node<>(8);
		node.left.right = new Node<>(-4);
		node.right.left = new Node<>(7);
		node.right.right = new Node<>(5);
		// node.right.left = new Node<>(6);
		// node.right.right = new Node<>(7);
		// node.left.left.right = new Node<>(10);
		// node.left.left.right.left = new Node<>(11);
		tree.printBinaryTree(node, 0);
		// System.out.println(tree.getHeight(node));
		System.out.println();
		tree.formTreeWithChilrenSumOnly(node);
		tree.printBinaryTree(node, 0);

		System.out.println();
		Node<Integer> root1 = tree.formTreeWithNodesWeight(node);
		tree.printBinaryTree(root1, 0);
		// tree.printLevelOrder(node);

	}
}
