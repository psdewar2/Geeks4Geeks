public class BinaryTree {
	static Node root;

	public BinaryTree() {

	}

	public void addNode(int data) { //method for BSTs
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent;
		while(true) {
			parent = current;

			if (data < (int)current.data) {
				current = current.leftChild;

				if (current == null) {
					parent.leftChild = newNode;
					return;
				}
			} else {
				current = current.rightChild;

				if (current == null) {
					parent.rightChild = newNode;
					return;
				}
			}
		}
	}

	//breadth first search algorithm for BSTs
	public Node findNode(int data) {
		Node parent;
		if (root != null) {
			Node current = root;

			while (data != (int)current.data) {
				parent = current;
				if (data < (int)current.data) {
					current = current.leftChild;
					if (current == null) {
						System.out.println("Node " + data + " doesn't exist.");
						return null;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						System.out.println("Node " + data + " doesn't exist.");
						return null;
					}
				}
			}
			System.out.println("Found node " + (int) current.data);
			return current;
		}
		return null;
		
	}

	//depth first traversal algorithms
	public void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}

	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.leftChild);
			System.out.print(node.data + " ");
			inOrder(node.rightChild);
		}
	}

	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			System.out.print(node.data + " ");
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.addNode(8);
		bt.addNode(3);
		bt.addNode(10);
		bt.addNode(1);
		bt.addNode(6);
		bt.addNode(14);
		bt.addNode(4);
		bt.addNode(7);
		bt.addNode(13);
		bt.preOrder(root);
		System.out.println();
		bt.inOrder(root);
		System.out.println();
		bt.postOrder(root);
		System.out.println();

		//			50
		//		25		75
		//    15  30	  85
		//pre: 50 25 15 30 75 85
		//in:  15 25 30 50 75 85
		//post:15 30 25 85 75 50

	}
}