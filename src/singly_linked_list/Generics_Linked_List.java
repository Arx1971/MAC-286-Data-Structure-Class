package singly_linked_list;

public class Generics_Linked_List<AnyType> {

	Node<AnyType> head;

	public class Node<AnyType> {
		AnyType data;
		Node next;

		public Node(AnyType data) {

			this.data = data;
			next = null;

		}
	}

	public void display() {
		Node<AnyType> myNode = head;
		while (myNode != null) {
			System.out.println(myNode.data);
			myNode = myNode.next;
		}
	}

	public boolean isempty() {
		if (head == null)
			return true;
		else
			return false;
	}

	public void instantiate(AnyType newData) {
		System.out.println("List Instantiate With: " + newData);
		head = new Node<AnyType>(newData);
		head.next = null;
	}

	public void addnewData(AnyType newData) {
		if (isempty()) {
			instantiate(newData);
			return;
		}
		System.out.println(newData + " Inserted.");
		Node<AnyType> myNode = head;
		Node<AnyType> newNode = new Node<AnyType>(newData);
		while (myNode.next != null) {
			myNode = myNode.next;
		}
		myNode.next = newNode;
	}

	public void remove() {
		if (isempty()) {
			System.out.println("List is Empty: ");
		}
		System.out.println(head.data + " Remove From The list");
		head = head.next;
	}

	public void middleelements() {

		Node<AnyType> slow = head;
		Node<AnyType> fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow.data);

	}
}
