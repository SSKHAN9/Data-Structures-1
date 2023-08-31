package jsjf;

public class HeapQueue<T> implements QueueADT<T> {
	

	LinkedHeap<T> heap;
	
	public HeapQueue(){
		heap = new LinkedHeap<T>();
	}
	
	@Override
	public void enqueue(T element) {
		
		heap.addElement(element);
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return heap.removeMin();
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return heap.getRootElement();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return heap.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return heap.getHeight();
	}

}
