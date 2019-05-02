package max_heap;

public class Main {

	public static void main(String args[]) {
		
		Heap<Integer> myHeap = new Heap<>();
		
		System.out.println("Is Empty: " + myHeap.isEmpty());
		
		myHeap.insert(10);
		myHeap.insert(20);
		myHeap.insert(90);
		myHeap.insert(15);
		myHeap.insert(21);
		myHeap.insert(94);
		myHeap.insert(11);
		myHeap.insert(27);
		
		myHeap.print();
		System.out.println();
		System.out.println("Size: "+myHeap.size());
		System.out.println("Is Empty: " + myHeap.isEmpty());
		
		myHeap.delete();
		myHeap.print();
	}
	
}
