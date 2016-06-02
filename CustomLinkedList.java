public class CustomLinkedList {
	Node head;
	Node tail;

	public CustomLinkedList() {}

	public CustomLinkedList(Node head) {
		this.head = head;
		this.tail = head;
	}

	public void insert(int index, Node newNode) {
		if (index == 0) {
			prepend(newNode);
			return;
		}

		if (head != null) {
			Node prev = (Node) getPrevious(index);
			newNode.next = prev.next;
			prev.next = newNode;
		} else {
			System.out.println("There are no nodes in this list.");
		}
	}

	public void append(Node newNode) {
		if (head == null) {
			head = tail = newNode;
			return;
		}
		tail.next = newNode; //creates reference from previous last node to newNode
		tail = newNode; //newNode is now the tail
	}

	public void prepend(Node newNode) {
		if (head == null) { 
			head = tail = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public Node removeHead() {
		Node removed = head;
		head = head.next;
		return removed;
	}

	public Node removeTail() {
		if (getSize() == 1) {
			removeHead();
		} else {
			Node newTail = getPrevious(getSize()-1);
			if (newTail != null) {
				Node removed = tail;
				tail = newTail;
				tail.next = null;
				return removed;
			}
		}
		return null;
	}

	public void removeAt(int index) {
		if (isEmpty()) {
			System.out.println("There are no nodes in this list to remove.");
			return;
		}

		if (index == 0) {
			removeHead();
		} else if (index == getSize() - 1) {
			removeTail();
		} else {
			Node prev = getPrevious(index);
			Node current = prev.next;
			prev.next = current.next;
			current.next = null;
		}

	}

	public Node getPrevious(int index) {
		if (index > 0) {
			Node prev = head;
			int count = 0;
			while (count < index - 1) {
				prev = prev.next;
				count++;
			}
			if (prev == null) {
				System.out.println("Index " + index + " exceeds the size of this list (" + 
				getSize() + ").");
			}
			return prev;
		} else if (index == 0) {
			System.out.println("The head does not have a previous node.");
		} else {
			System.out.println("This list is empty.");
		}
		return null;
	}

	public int getSize() {
		int count = 0;
		Node current = head;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		if (isEmpty()) return "There are no nodes in this list.";
		Node current = head;
		while (current != null) {
			str.append(current.data + "->");
			current = current.next;
		}
		str.append("null");
		return str.toString();
	}
}