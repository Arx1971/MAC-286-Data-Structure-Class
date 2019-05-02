package min_heap;

public class Main {

	public static void main(String args[]) {
		
		Heap <Integer> myHeap = new Heap<>();
		myHeap.add(20);
		myHeap.add(30);
		myHeap.add(40);
		myHeap.add(10);
		myHeap.add(70);
		myHeap.add(80);
		
		myHeap.print();
		
		myHeap.delete();
		System.out.println();
		myHeap.print();
	}
	
}
