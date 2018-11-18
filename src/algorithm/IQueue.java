package algorithm;

public interface IQueue<E> {

	public void enQueue(E e);
	public E deQueue();
	public boolean isEmpty();
}
