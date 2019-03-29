package doubly_linked_list;

import java.util.NoSuchElementException;

public class DoublyLinkedList<AnyType> {

	private Node head;
	private Node tail;
	private int size;

	public DoublyLinkedList() {
		size = 0;
	}

	private class Node {
		AnyType data;
		Node next;
		Node prev;

		public Node(AnyType data, Node next, Node prev) {	// Constructor for Node
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addFront(AnyType data) {
		Node newNode = new Node(data, head, null);
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		if (tail == null) {
			tail = newNode;
		}
		size++;
		System.out.println("adding: " + data);
	}

	public void addRear(AnyType data) {

		Node newNode = new Node(data, null, tail);
		if (tail != null) {
			tail.next = newNode;
		}
		tail = newNode;
		if (head == null) {
			head = newNode;
		}
		size++;
		System.out.println("adding: " + data);
	}

	public AnyType removeFront() {
		if (size == 0)
			throw new NoSuchElementException();
		Node newNode = head;
		head = head.next;
		head.prev = null;
		size--;
		System.out.println("deleted: " + newNode.data);
		return newNode.data;
	}

	public AnyType removeRear() {
		if (size == 0)
			throw new NoSuchElementException(); 
		Node newNode = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		System.out.println("deleted: " + newNode.data);
		return newNode.data;
	}
	
	public void iterateForward() {

		System.out.println("iterating forward..");
		Node newNode = head;
		while (newNode != null) {
			if (newNode.next != null)
				System.out.print(newNode.data + " -> ");
			else
				System.out.println(newNode.data);
			newNode = newNode.next;
		}
	}


	public void iterateBackward() {

		System.out.println("iterating backword..");
		Node newNode = tail;
		while (newNode != null) {
			if (newNode.prev != null)
				System.out.print(newNode.data + " -> ");
			else
				System.out.println(newNode.data);
			newNode = newNode.prev;
		}
	}
}