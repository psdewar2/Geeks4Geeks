import java.util.*;

public class Stack {
	//implement stack using queues
	private Queue<Integer> q1;
	private Queue<Integer> q2;
	int top, size;

	public Stack() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
		size = 0;
	}

	//O(n) version for push
	public void push(int data) {
		if (q1.isEmpty()) {
			q1.add(data);
			return;
		}
		while (!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		q1.add(data);
		top = data;
		while (!q2.isEmpty()) {
			q1.add(q2.poll());
		}
		size = q1.size();
	}

	public int pop() {
		if (q1.size() > 0) {
			int poppedTop = q1.poll();
			top = q1.peek();
			return poppedTop;
		}
		System.out.println("Nothing to pop.");
		return -1;
		
	}

	public int top() {
		return top;
	}

	public int size() {
		return q1.size();
	}

	public static void main(String[] args) {
		Stack s1 = new Stack();
		s1.push(9);
		s1.push(5);
		System.out.println("Stack's top: " + s1.top());
		s1.pop();
		System.out.println("Stack's top now: " + s1.top());
		s1.push(7);
		s1.push(53);
		System.out.println("Stack's top: " + s1.top());
		s1.pop();
		s1.pop();
		s1.pop();
		s1.pop();
		s1.pop();
	}
}