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
		AnyType element;
		Node next;
		Node prev;

		public Node(AnyType element, Node next, Node prev) {	// Constructor for Node
			this.element = element;
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

	public void addFront(AnyType element) {
		Node newNode = new Node(element, head, null);
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		if (tail == null) {
			tail = newNode;
		}
		size++;
		System.out.println("adding: " + element);
	}

	public void addRear(AnyType element) {

		Node newNode = new Node(element, null, tail);
		if (tail != null) {
			tail.next = newNode;
		}
		tail = newNode;
		if (head == null) {
			head = newNode;
		}
		size++;
		System.out.println("adding: " + element);
	}

	public void iterateForward() {

		System.out.println("iterating forward..");
		Node newNode = head;
		while (newNode != null) {
			if (newNode.next != null)
				System.out.print(newNode.element + " -> ");
			else
				System.out.println(newNode.element);
			newNode = newNode.next;
		}
	}
	
	public AnyType removeFront() {
		if (size == 0)
			throw new NoSuchElementException();
		Node newNode = head;
		head = head.next;
		head.prev = null;
		size--;
		System.out.println("deleted: " + newNode.element);
		return newNode.element;
	}

	public AnyType removeRear() {
		if (size == 0)
			throw new NoSuchElementException(); 
		Node newNode = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		System.out.println("deleted: " + newNode.element);
		return newNode.element;
	}

	public void iterateBackward() {

		System.out.println("iterating backword..");
		Node newNode = tail;
		while (newNode != null) {
			if (newNode.prev != null)
				System.out.print(newNode.element + " -> ");
			else
				System.out.println(newNode.element);
			newNode = newNode.prev;
		}
	}

	

	public static void main(String argv[]) {

		/* This code will perform Doubly Linked List following  Basic Operation 
		 * addFirst(@param)
		 * addLast(@param)
		 * removeRear(@param)
		 * removeFront(@param)
		 * iterateForward();
		 * iterateBackward();
		 */
		
		// This is a generic code, you are required to using wrapper class object(Integer, Double.....)
		
		
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.addFront(10); 		// adding 10 to list 10
		dll.addFront(34);	 	// adding 34 to list 34 -> 10 (adding data in front of the list)
		dll.addRear(56);		// adding 56 to list 34 -> 10 -> 56
		dll.addRear(364);
		dll.iterateForward();
		dll.removeFront();
		dll.removeRear();
		dll.iterateBackward();
	}
}