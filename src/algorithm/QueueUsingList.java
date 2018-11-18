package algorithm;

import java.util.LinkedList;;

public class QueueUsingList<E> implements IQueue<E>{

	LinkedList<E> queue;

	public QueueUsingList(LinkedList<E> queue) {
		super();
		this.queue = queue;
	}

	public void enQueue(E e) {
		queue.add(e);
	}

	public E deQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return queue.removeFirst();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public String toString() {
		return "QueueUsingList [queue=" + queue + "]";
	}

	public static void main(String args[]) {
		IQueue<Integer> queue = new QueueUsingList<>(new LinkedList<>());
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
