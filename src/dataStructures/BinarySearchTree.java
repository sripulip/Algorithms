package dataStructures;

public class BinarySearchTree {

	private Node root = null;

	private class Node {

		private Node lChild;
		private Node rChild;
		private int data;

		private Node(int data) {
			this.data = data;
			this.lChild = null;
			this.rChild = null;
		}
	}

	public BinarySearchTree() {
		root = null;
	}

	public void insert(int data) {
		root = insertNode(root, data);
	}

	private Node insertNode(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else if (data < node.data) {
			node.lChild = insertNode(node.lChild, data);
		} else if (data > node.data) {
			node.rChild = insertNode(node.rChild, data);
		}
		return node;
	}

	public void print() {
		System.out.println("PreOrder: ");
		preOrder(root);
		System.out.println("\n\nInOrder: ");
		inOrder(root);
		System.out.println("\n\nPostOrder: ");
		postOrder(root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.lChild);
		preOrder(node.rChild);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.lChild);
		System.out.print(node.data + " ");
		inOrder(node.rChild);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.lChild);
		postOrder(node.rChild);
		System.out.print(node.data + " ");
	}

	public boolean isBST(BinarySearchTree bst) {
		return isBSTutil(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBSTutil(Node node, int minValue, int maxValue) {

		if (node == null)
			return true;

		if ((node.data > minValue) && (node.data < maxValue)
				&& isBSTutil(node.lChild, minValue, node.data)
				&& isBSTutil(node.rChild, node.data, maxValue))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int[] input = { 8, 3, 1, 6, 4, 7, 10, 14, 13 };
		for (int i = 0; i < input.length; i++) {
			bst.insert(input[i]);
		}
		bst.print();
		System.out.println("\n\n" + bst.isBST(bst));
	}
}
