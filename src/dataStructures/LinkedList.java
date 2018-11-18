package dataStructures;

public class LinkedList {

	static class Node {
		int data;
		Node next;

		public Node() {
			super();
		}

		public Node(int data) {
			super();
			this.data = data;
		}

	}

	public Node slot(Node current, int k) {
		int count = 0;
		Node prev = null, next = null;
		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		return prev;
	}
	/**
	 * Reverse a linked list
	 * for example  if  list = 1->2->3->4->5->6
	 * then it will reverse list as = 6->5->4->3->2->1
	 * @param current
	 * @return
	 */
	public Node reverse(Node current) {
		if (current == null)
			return current;

		Node prev = null, next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		current = prev;
		return current;
	}
	/**
	 * Reverse a linked list in slot. slot size is decided by K value.
	 * for example  if k=2 and list = 1->2->3->4->5->6
	 * then it will reverse list as = 2->1->4->3->6->5
	 * @param root
	 * @param k
	 * @return
	 */
	public Node reverseSlot(Node root, int k) {
		if (root == null)
			return root;

		Node prev = null, next = null, current = root;
		int count = 0;
		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		if (next != null) {
			Node output = reverseSlot(next, k);
			root.next = output;
		}
		return prev;
	}

	/**
	 * print list
	 * 
	 * @param node
	 */
	public void printNode(Node node) {

		if (node == null)
			return;
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {

		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		n.next.next.next.next = new Node(5);
		n.next.next.next.next.next = new Node(6);
		LinkedList a = new LinkedList();
		n=a.reverse(n);
		a.printNode(n);

		
	}

}
