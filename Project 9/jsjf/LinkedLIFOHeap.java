package jsjf;

import jsjf.exceptions.EmptyCollectionException;

/**
 * LinkedHeap implements a heap.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedLIFOHeap<T> extends LinkedBinaryTree<T> implements HeapADT<T> 
{
	public HeapNode<T> lastNode;
	private int counter = 0;
	private int size = 0;

	public LinkedLIFOHeap() 
	{
		super();
	}

	/**
	 * Adds the specified element to this heap in the appropriate
	 * position according to its key value. 
	 *
	 * @param obj the element to be added to the heap
	 */
	public void addElement(T obj) 
	{
		HeapNode<T> node = new HeapNode<T>(obj);
		counter++;
		node.count = counter;

		if (root == null)
			root=node;
		else
		{
			HeapNode<T> nextParent = getNextParentAdd(); 
			if (nextParent.getLeft() == null)
				nextParent.setLeft(node);
			else
				nextParent.setRight(node);

			node.setParent(nextParent);
		}
		lastNode = node;
		modCount++;

		if (size() > 1)
			heapifyAdd();
	}

	/**
	 * Returns the node that will be the parent of the new node
	 *
	 * @return the node that will be the parent of the new node
	 */
	private HeapNode<T> getNextParentAdd()
	{
		HeapNode<T> result = lastNode;

		while ((result != root) && (result.getParent().getLeft() != result))
			result = result.getParent();

		if (result != root)
			if (result.getParent().getRight() == null)
				result = result.getParent();
			else
			{
				result = (HeapNode<T>)result.getParent().getRight();
				while (result.getLeft() != null)
					result = (HeapNode<T>)result.getLeft();
			}
		else
			while (result.getLeft() != null)
				result = (HeapNode<T>)result.getLeft();

		return result;
	}

	/**
	 * Reorders this heap after adding a node.
	 */
	private void heapifyAdd()
	{
		T tempElement;
		int tempCount;
		HeapNode<T> next = lastNode;

		tempElement = next.getElement();
		tempCount = next.getCount();

		while ((next != root) && 
				(tempCount > (next.getParent().getCount())))
		{
			next.setElement(next.getParent().getElement());
			next.setCount(next.getParent().getCount());
			next = next.parent;
		}
		next.setElement(tempElement);
		next.setCount(tempCount);
	}

	/**
	 * Remove the element with the lowest value in this heap and
	 * returns a reference to it. Throws an EmptyCollectionException 
	 * if the heap is empty.
	 *
	 * @return the element with the lowest value in this heap
	 * @throws EmptyCollectionException if the heap is empty
	 */
	public T removeMin() throws EmptyCollectionException 
	{
		if (isEmpty())
			throw new EmptyCollectionException("LinkedHeap");

		T minElement =  root.getElement();

		if (size() == 1)
		{
			root = null;
			lastNode = null;
		}
		else
		{
			HeapNode<T> nextLast = getNewLastNode();
			if (lastNode.getParent().getLeft() == lastNode)
				lastNode.getParent().setLeft(null);
			else
				lastNode.getParent().setRight(null);

			((HeapNode<T>)root).setElement(lastNode.getElement());
			((HeapNode<T>)root).setCount(lastNode.getCount());
			lastNode = nextLast;
			heapifyRemove();
		}

		modCount++;
		return minElement;
	}

	/**
	 * Reorders this heap after removing the root element.
	 */
	private void heapifyRemove()
	{
		T tempElement;
		int tempCount;
		HeapNode<T> node = (HeapNode<T>)root;
		HeapNode<T> left = (HeapNode<T>)node.getLeft();
		HeapNode<T> right = (HeapNode<T>)node.getRight();
		HeapNode<T> next;

		if ((left == null) && (right == null))
			next = null;
		else if (right == null)
			next = left;
		else if (left.getCount() > (right.getCount()))
			next = left;
		else
			next = right;

		tempElement = node.getElement();
		tempCount = node.getCount();
		while ((next != null) && 
				((next.getCount() > (tempCount))))
		{
			node.setElement(next.getElement());
			node.setCount(next.getCount());
			node = next;
			left = (HeapNode<T>)node.getLeft();
			right = (HeapNode<T>)node.getRight();

			if ((left == null) && (right == null))
				next = null;
			else if (right == null)
				next = left;
			else if ((left.getCount()) > right.getCount())
				next = left;
			else
				next = right;
		}
		node.setElement(tempElement);
		node.setCount(tempCount);
	}

	/**
	 * Returns the node that will be the new last node after a remove.
	 *
	 * @return the node that will be the new last node after a remove
	 */
	private HeapNode<T> getNewLastNode()
	{
		HeapNode<T> result = lastNode;

		while ((result != root) && (result.getParent().getLeft() == result))
			result = result.getParent();

		if (result != root)
			result = (HeapNode<T>)result.getParent().getLeft();

		while (result.getRight() != null)
			result = (HeapNode<T>)result.getRight();

		return result;
	}

	/**
	 * Returns the element with the lowest value in this heap.
	 * Throws an EmptyCollectionException if the heap is empty.
	 *
	 * @return the element with the lowest value in this heap
	 * @throws EmptyCollectionException if the heap is empty
	 */
	public T findMin() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("LinkedHeap");

		return root.getElement();
	}
	
}
