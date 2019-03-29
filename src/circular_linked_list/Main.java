package circular_linked_list;

public class Main {
	public static void main(String[] args) {
		CircularLinkedList<Integer> circularlist = new CircularLinkedList<Integer>();
		circularlist.addFront(3);
		circularlist.addFront(2);
		circularlist.addFront(1);
		circularlist.display();
		circularlist.remove();
		circularlist.display();
		circularlist.addRear(4);
		circularlist.display();
		System.out.println("Size: " + circularlist.getSize());
	}
}
