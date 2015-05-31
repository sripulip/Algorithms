package dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Anytype> implements Iterable<Anytype> {
	private Node first;
	private Node last;
	private Node current;

	private class Node {
		private Node prev;
		private Anytype data;
		private Node next;

		private Node(Anytype data) {
			this.data = data;
		}
	}

	void insert(Anytype data) {
		Node node = new Node(data);
		if (first == null) {
			node.prev = null;
			node.next = null;
			first = node;
			last = node;
		} else {
			last.next = node;
			node.prev = last;
			node.next = null;
			last = node;
		}
	}

	void reverseDLL() {
		Node temp = first;
		first = last;
		last = temp;
		Node current = first;
		while (current != null) {
			temp = current.next;
			current.next = current.prev;
			current.prev = temp;
			current = current.next;
		}
	}

	void printDLL() {
		current = first;
		while (!(current == null)) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println("\n");
	}

	@Override
	public Iterator<Anytype> iterator() {
		return new DLLIterator(first);
	}

	private class DLLIterator implements Iterator<Anytype> {

		public DLLIterator(Node first) {
			current = first;
		}

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public Anytype next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Anytype data = current.data;
			current = current.next;
			return data;
		}

	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		int[] a = { 4, 6, 1, 2, 8, 9 };
		for (int i = 0; i < a.length; i++) {
			dll.insert(a[i]);
		}
		System.out.println("Inserted Order:");
		Iterator<Integer> it = dll.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		dll.reverseDLL();
		System.out.println("\n\nReverse Order (DLL Reversed):");
		Iterator<Integer> it1 = dll.iterator();
		while (it1.hasNext()) {
			System.out.print(it1.next() + " ");
		}
	}
}
