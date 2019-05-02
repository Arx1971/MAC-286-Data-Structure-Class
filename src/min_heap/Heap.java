package min_heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap <T extends Comparable<T>>{

	private ArrayList<T> list;
	
	public Heap(){
		list = new ArrayList<T>();
	}
	
	public void add(T newData) {
		list.add(newData);
		siftup();
	}
	
	private void siftup() {
		int k = list.size() - 1;
		while(k > 0) {
			int parentidx = (k-1)/2;
			T child = list.get(k);
			T parent = list.get(parentidx);
			
			if(child.compareTo(parent) < 0) {
				list.set(parentidx, child);
				list.set(k, parent);
				k = parentidx;
			}
			else return;
		}
	}
	
	public void print() {
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	public T delete() throws NoSuchElementException {
		if(list.size() == 0) throw new NoSuchElementException();
		if(list.size() == 1) {
			return list.remove(0);
		}
		T temp = list.get(0);
		list.set(0, list.remove(list.size()-1));
		siftDown();
		return temp;
	}
	
	private void siftDown() {
		int k = 0;
		int l = 2*k + 1;
		while(l < list.size()) {
			int min = l, r = l+1;
			if(r < list.size()) {
				if(list.get(r).compareTo(list.get(l)) < 0) {
					min++;
				}
			}
			if(list.get(min).compareTo(list.get(k)) < 0) {
				T parent= list.get(k);
				list.set(k, list.get(min));
				list.set(min, parent);
				k = min;
				l = 2*k+1;
			}
			else {
				 return;
			}
		}
	}
}
