package max_heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap <T extends Comparable<T>>{
	
	private ArrayList<T> list;
	
	public Heap() {
		list = new ArrayList<T>();
	}
	
	private void siftUp() {
		int k = list.size() - 1;
		while(k > 0) {
			int p = (k-1) / 2;
			T item = list.get(k);
			T parent = list.get(p);
			if(item.compareTo(parent) > 0) {
				list.set(k, parent);
				list.set(p, item);
				k = p;
			}
			else return;
		}
	}
	
	private void siftDown() {
		
		int k = 0;
		int l = 2*k + 1;
		while(l < list.size()) {
			int max = l, r = l + 1;
			if(r < list.size()) {
				if(list.get(r).compareTo(list.get(l)) > 0) {
					max++;
				}
			}
			if(list.get(k).compareTo(list.get(max)) < 0) {
				T temp = list.get(k);
				list.set(k, list.get(max));
				list.set(max, temp);
				k = max;
				l = 2*k + 1;
			}
			else return;
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
	
	public void insert(T data) {
		list.add(data);
		siftUp();
	}
	
	public void print() {
		for(int i=0; i<list.size();i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}
	
}
