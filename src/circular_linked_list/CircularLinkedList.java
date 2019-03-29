package circular_linked_list;

import java.util.NoSuchElementException;

public class CircularLinkedList<AnyType> {

	public int size;
	public Node head = null;
	public Node tail = null;

	public CircularLinkedList() {
		size = 0;
	}

	class Node {
		AnyType data;
		Node next;

		public Node(AnyType data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public void addFront(AnyType data) {
		Node n = new Node(data);
		if (size == 0) {
			head = tail = n;
			n.next = head;
		} else {
			Node newNode = head;
			n.next = newNode;
			head = n;
			tail.next = head;
		}
		size++;
		
		System.out.println(data + " Added into the front");
		
	}

	public void addRear(AnyType data) {
		if (isEmpty()) {
			addFront(data);
		} else {
			Node n = new Node(data);
			tail = tail.next = n;
			tail.next = head;
			size++;
		}
		System.out.println(data + " Added into the rear");
	}

	public void remove() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			System.out.println("\ndeleting node " + head.data + " from start");
			head = head.next;
			tail.next = head;
			size--;
		}
	}

	// print the linked list
	public void display() {
		System.out.print("Circular Linked List:");
		Node newNode = head;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			do {
				System.out.print(" " + newNode.data);
				newNode = newNode.next;
			} while (newNode != head);
		}
		System.out.println();
	}

}
