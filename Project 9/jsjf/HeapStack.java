package jsjf;

public class HeapStack<T> implements StackADT<T> {

	private int addCount = 0;  
	
	LinkedLIFOHeap<T> heap;
	
	public HeapStack() {
		 heap = new LinkedLIFOHeap<T>();
	}

	@Override
	public void push(T element) {
		heap.addElement(element);
	}

	@Override
	public T pop() {
		return heap.removeMin();
	}

	@Override
	public T peek() {
		return heap.findMin();
	}

	@Override
	public boolean isEmpty() {
		if (heap.size() == 0) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public int size() {
		return heap.size();
	}

	public String toString() {
		return heap.toString();
		
	}
	
}

