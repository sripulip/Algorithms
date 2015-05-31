package dataStructures;

public class SinglyLinkedList<Anytype> {
	private Node first;
	private Node current;

	private class Node {
		private Anytype data;
		private Node next;

		private Node(Anytype data) {
			this.data = data;
			this.next = null;
		}
	}

	private void insert(Anytype data) {
		Node node = new Node(data);
		if (first == null) {
			node.next = null;
			first = node;
		} else {
			current = first;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

	private void reverseSLL() {
		Node reversedPart = null;
		Node current = first;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = reversedPart;
			reversedPart = current;
			current = next;
		}
		first = reversedPart;
	}

	private void printSLL() {
		current = first;
		while (!(current == null)) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		int[] a = { 4, 6, 1, 2, 8, 9 };
		for (int i = 0; i < a.length; i++) {
			sll.insert(a[i]);
		}
		System.out.println("Inserted Order:");
		sll.printSLL();
		sll.reverseSLL();
		System.out.println("Reverse Order (SLL Reversed):");
		sll.printSLL();
	}
}
