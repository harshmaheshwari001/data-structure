package algorithm;

import java.util.EmptyStackException;
import java.util.LinkedList;
/**
 * Stack implement using LinkedList
 * @author harsmahe
 *
 * @param <E>
 */
public class StackUsingLinkedList<E> implements IStack<E> {

	final LinkedList<E> stack;

	public StackUsingLinkedList(LinkedList<E> stack) {
		super();
		this.stack = stack;
	}

	public E pop() {
		if(stack.isEmpty()){
			throw new EmptyStackException();
		}
		return stack.removeLast();
	}

	public void push(E e) {
		stack.add(e);
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}
	

	@Override
	public String toString() {
		return "StackUsingLinkedList [stack=" + stack + "]";
	}

	public static void main(String args[]) {
		IStack<Integer> stack = new StackUsingLinkedList<>(new LinkedList<>());
		for (int i = 0; i < 5; i++) {
			stack.push((i + 1) * 10);
			System.out.println(stack);
		}
		for (int i = 0; i < 5; i++) {
			stack.pop();
			System.out.println(stack);
		}
	}
}
