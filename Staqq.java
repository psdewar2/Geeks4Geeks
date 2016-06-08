import java.util.*;
public class Staqq {
	LinkedList<Integer> q1;
	LinkedList<Integer> q2;
	static int count;

	Staqq() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	public void push(int data) { //O(n)
		while(!q1.isEmpty())
			q2.offer(q1.poll());

		q1.offer(data);
		count++;

		while(!q2.isEmpty())
			q1.offer(q2.poll());
	}

	public String pop() {
		if (!q1.isEmpty()) {
			count--;
			return String.valueOf(q1.poll());
		}

		return "Stack is empty";
	}

	public String top() {
		if (!q1.isEmpty())
			return String.valueOf(q1.peek());

		return "Stack is empty";
	}

	public int size() {
		return count;
	}

	public static void main(String[] args) {
		Staqq newStack = new Staqq();
		newStack.push(3);
		newStack.push(5);
		System.out.println(newStack.top());
		newStack.push(7);
		newStack.push(4);
		System.out.println(newStack.top());
		newStack.pop();
		System.out.println(newStack.top());
		System.out.println(newStack.size());
	}
}