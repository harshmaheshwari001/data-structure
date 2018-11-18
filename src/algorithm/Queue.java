package algorithm;

import java.util.Arrays;

public class Queue<E> implements IQueue<E>{

	E[] queue;
	final int MAX_SIZE;
	int elementCount = 0;

	@SuppressWarnings("unchecked")
	public Queue(final int maxSize) {
		this.MAX_SIZE = maxSize;
		queue = (E[])new Object[this.MAX_SIZE];
	}

	public void enQueue(E e) {
		if (elementCount == MAX_SIZE) {
			throw new RuntimeException("Queue is already full!!");
		}
		queue[elementCount] = e;
		elementCount++;
	}

	public E deQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		for (int i = 0; i < queue.length; i++) {
			if (queue[i] != null) {
				E e = queue[i];
				queue[i] = null;
				return e;
			}
		}
		return null;
	}

	public boolean isEmpty() {
		if (elementCount == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Queue [queue=" + Arrays.toString(queue) + ", MAX_SIZE=" + MAX_SIZE + ", elementCount=" + elementCount
				+ "]";
	}

	public static void main(String args[]) {

		IQueue<Integer> queue = new Queue<>(5);
		for (int i = 0; i < 5; i++) {
			queue.enQueue((i + 1) * 10);
			System.out.println(queue);
		}
		for (int i = 0; i < 5; i++) {
			queue.deQueue();
			System.out.println(queue);

		}

	}
}
