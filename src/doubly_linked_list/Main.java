package doubly_linked_list;

public class Main {

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
		
		
		DoublyLinkedList<Integer> doublylinkedlist = new DoublyLinkedList<Integer>();
		doublylinkedlist.addFront(10); 		// adding 10 to list 10
		doublylinkedlist.addFront(34);	 	// adding 34 to list 34 -> 10 (adding data in front of the list)
		doublylinkedlist.addRear(56);		// adding 56 to list 34 -> 10 -> 56
		doublylinkedlist.addRear(364);
		doublylinkedlist.iterateForward();
		doublylinkedlist.removeFront();
		doublylinkedlist.removeRear();
		doublylinkedlist.iterateBackward();
	}
	
}
