public class Node {
	Object o;
	Node next;

	public Node(Object obj) {
		this.o = obj;
		this.next = null;
	}

	public Object getData() {
		return o;
	}

	public Node getNext() {
		return next;
	}

}
