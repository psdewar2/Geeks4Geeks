public class LinkedList {
	Node head;
	Node tail;

	public LinkedList() {

	}

	public void append(Node newNode) {
		if (head == null) {
			head = tail = newNode;
			return;
		}
		tail.next = newNode; //creates reference from previous last node to newNode
		tail = newNode; //tail is now newNode

	}

	public void prepend(Node newNode) {
		if (head == null) { 
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		Node current = head;
		while (current != null) {
			str.append(current.getData() + "->");
			current = current.next;
		}
		str.append("null");
		return str.toString();
	}

	public static void main(String[] args) {
	}
}