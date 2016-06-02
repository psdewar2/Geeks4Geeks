import java.util.*;

public class Stack {
	//implement stack using linked list
	//Properties: 1. LIFO (only access top) 
	LinkedList list;
	Node top;
	public Stack() {
		list = new LinkedList();
	}

	public void push(Object o) {
		Node newNode = new Node(o);
		top = newNode;
		list.append(newNode);
	}

	public Node pop() {
		if (isEmpty()) return null;
		Node removed = list.removeTail();
		top = list.tail;
		return removed;
	}

	public Node peek() {
		if (isEmpty()) return null;
		return top;	
	}

	public int size() {
		return list.getSize();
	}

	public boolean isEmpty() {
		if (list.isEmpty()) {
			System.out.println("There is no data in this stack.");
		}
		return list.isEmpty();
	}
}

// public class Stack {
// 	//implement stack using queues
// 	private Queue<Integer> q1;
// 	private Queue<Integer> q2;
// 	int size;

// 	public Stack() {
// 		q1 = new LinkedList<Integer>();
// 		q2 = new LinkedList<Integer>();
// 		size = 0;
// 	}

// 	//O(n) version for push
// 	public void push(int data) {
// 		if (q1.isEmpty()) {
// 			q1.add(data);
// 		} else {
// 			while (!q1.isEmpty()) {
// 				q2.add(q1.poll());
// 			}
// 			q1.add(data);
// 			while (!q2.isEmpty()) {
// 				q1.add(q2.poll());
// 			}
// 			size = q1.size();
// 		}
// 		System.out.println("PUSH: Stack's top now: " + top());
// 	}

// 	public int pop() {
// 		if (q1.size() > 0) {
// 			int poppedTop = q1.poll();
// 			System.out.println("POP(" + poppedTop + "):  Stack's top now: " + this.top());
// 			return poppedTop;
// 		}
// 		System.out.println("Nothing to pop.");
// 		return -1;
		
// 	}

// 	public int top() {
// 		if (!q1.isEmpty()) return q1.peek();
// 		System.out.println("Stack is empty.");
// 		return -1;
// 	}

// 	public int size() {
// 		return q1.size();
// 	}


// }