public class Node {
	private Object o;
	private Node next;

	public Node(Object obj) {
		this.o = obj;
		this.next = null;
	}

	public Object getData() {
		return o;
	}

	public String printList() { //can't set this to a final variable
		Node current = this;
		String str = "";
		while (current != null) {
			str += String.valueOf(current.o) + "->";
			current = current.next;
		}
		return str += "null";
	}
}
