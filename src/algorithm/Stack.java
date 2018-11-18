package algorithm;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Stack implement in java using Arrau
 * 
 * @author harsmahe
 *
 * @param <E>
 */
public class Stack<E> implements IStack<E>{

	E[] stack;
	final int MAX_SIZE;
	int currIdx;

	@SuppressWarnings("unchecked")
	public Stack(int mAX_SIZE) {
		super();
		MAX_SIZE = mAX_SIZE;
		this.stack = (E[]) new Object[MAX_SIZE];
		this.currIdx = this.MAX_SIZE;
	}

	public void push(E data) {
		if (currIdx == 0) {
			throw new RuntimeException("Stack is full");
		}
		stack[currIdx - 1] = data;
		currIdx--;

	}

	public boolean isEmpty() {
		if (currIdx == MAX_SIZE) {
			return true;
		}
		return false;
	}

	public E pop() {
		if (currIdx == MAX_SIZE) {
			throw new EmptyStackException();
		}
		E element = stack[currIdx];
		stack[currIdx] = null;
		currIdx++;
		return element;
	}

	@Override
	public String toString() {
		return "Stack [stack=" + Arrays.toString(stack) + ", MAX_SIZE=" + MAX_SIZE + ", currIdx=" + currIdx + "]";
	}

	public static void main(String args[]) {
		IStack<Integer> stack = new Stack<>(5);
		stack.isEmpty();
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
