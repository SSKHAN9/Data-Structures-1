package jsjf;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.EmptyCollectionException;
import jsjf.exceptions.NonComparableElementException;

public class LinkedBSTOrderedSet<T> implements OrderedSetADT<T>{
	
	protected BinaryTreeNode<T> root;
	protected int modCount;

	public LinkedBSTOrderedSet() {
		root = null;
	}

	@Override
	public void addElement(T element) {
		if (!(element instanceof Comparable))
			throw new NonComparableElementException("LinkedBinarySearchTree");

		Comparable<T> comparableElement = (Comparable<T>)element;

		if (root==null) {
			root = new BinaryTreeNode<T>(element);
		}
		else if(findNode(element, root)==null) {
			addElement(element, root);
		}
		
	}

	private void addElement(T element, BinaryTreeNode<T> node) 
	{
		Comparable<T> comparableElement = (Comparable<T>)element;

		if (comparableElement.compareTo(node.getElement()) < 0)
		{
			if (node.getLeft() == null) 
				node.setLeft(new BinaryTreeNode<T>(element));
			else
				addElement(element, node.getLeft());
		}
		else
		{
			if (node.getRight() == null) 
				node.setRight(new BinaryTreeNode<T>(element));
			else
				addElement(element, node.getRight());
		}
	}
	@Override
	public T removeElement(T targetElement) {
		// TODO Auto-generated method stub
		T result = null;

		if (root==null)
			throw new ElementNotFoundException("LinkedBinarySearchTree");
		else
		{
			BinaryTreeNode<T> parent = null;
			if (((Comparable<T>)targetElement).equals(root.element)) 
			{ // Remove the root
				result =  root.element;
				BinaryTreeNode<T> inOrderSuccessor = replacement(root);
				if (inOrderSuccessor == null)
					root = null;
				else 
				{
					root.element = inOrderSuccessor.element;
					root.setRight(inOrderSuccessor.right);
					root.setLeft(inOrderSuccessor.left);
				}
			}
			else 
			{ // Look for the target in a sub-tree               
				parent = root;
				if (((Comparable<T>)targetElement).compareTo(root.element) < 0)
					result = removeElement(targetElement, root.getLeft(), parent);
				else
					result = removeElement(targetElement, root.getRight(), parent);
			}
		}

		return result;
	}
	
	private T removeElement(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent)
			throws ElementNotFoundException 
	{
		T result = null;

		if (node == null)
			throw new ElementNotFoundException("LinkedBinarySearchTree");
		else
		{
			if (((Comparable<T>)targetElement).equals(node.element)) 
			{   // remove the current node
				result =  node.element;
				BinaryTreeNode<T> inOrderSuccessor = replacement(node);
				// Decide if current node is left or right child of the parent
				if (parent.right == node)
					parent.right = inOrderSuccessor;
				else 
					parent.left = inOrderSuccessor;
			}
			else 
			{   // Look for the target in a sub-tree            
				parent = node;
				if (((Comparable<T>)targetElement).compareTo(node.element) < 0)
					result = removeElement(targetElement, node.getLeft(), parent);
				else
					result = removeElement(targetElement, node.getRight(), parent);
			}
		}

		return result;
	}

	private BinaryTreeNode<T> replacement(BinaryTreeNode<T> root2) {
		BinaryTreeNode<T> result = null;

		// No children
		if ((root.left == null) && (root.right == null))
			result = null;

		// One child - left
		else if ((root.left != null) && (root.right == null))
			result = root.left;

		// One child - right
		else if ((root.left == null) && (root.right != null))
			result = root.right;

		else
		{
			BinaryTreeNode<T> current = root.right;
			BinaryTreeNode<T> parent = root;

			while (current.left != null)
			{
				parent = current;
				current = current.left;
			}

			// Set the replacement's left subtree to the root's left subtree
			current.left = root.left;
			if (root.right != current)
			{
				parent.left = current.right;
				current.right = root.right;
			}

			result = current;
		}

		return result;
	}

	@Override
	public T find(T targetElement) {
		T result = null;
        
        if (root==null)
                throw new EmptyCollectionException("LinkedBinarySearchTree");
        else 
        {       
                if (((Comparable<T>)targetElement).equals(root.element)) 
                        result = root.element;
        
        }
        
        return result;
	}
	
	protected BinaryTreeNode<T> findNode(T targetElement, 
			BinaryTreeNode<T> next)
	{
		if (next == null)
			return null;

		if (next.getElement().equals(targetElement))
			return next;

		BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());

		if (temp == null)
			temp = findNode(targetElement, next.getRight());

		return temp;
	}

	@Override
	public T findMin() {
		T result = null;
        
        if (root == null)
                throw new EmptyCollectionException("LinkedBinarySearchTree");
        else 
        {       
                if (root.left == null)
                {
                        result = root.element;
                }
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;
                while(root.left != null)
                {
                        parent = current;
                        current = current.left;
                        result = current.element;
                }
        }
        return result;  
	}
	@Override
	public T findMax() {
		T result = null;
        
        if (root==null)
                throw new EmptyCollectionException("LinkedBinarySearchTree");
        else 
        { 
                if (root.right == null)
                {
                        result = root.element;
                }
                else 
                {
                        while(root.right != null)
                        {
                                BinaryTreeNode<T> current = root.right;
                                BinaryTreeNode<T> parent = root;
                        
                                parent = current;
                                current = current.left;
                                result = current.element;;
                        }
                }
        }
        return result;  // temp
	}

	@Override
	public boolean contains(T targetElement) {
		T result = null;
        
        if (root==null)
                throw new EmptyCollectionException("LinkedBinarySearchTree");
        else
        {       
                if (((Comparable<T>)targetElement).equals(root.element)) 
                        return true;
        else
        {
        return false;
        }
        }
	}

	@Override
	public Iterator<T> iterator()
	{
		return iteratorInOrder();
	}
	
	public Iterator<T> iteratorInOrder()
	{
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		inOrder(root, tempList);

		return new TreeIterator(tempList.iterator());
	}
	private class TreeIterator implements Iterator<T>
	{
		private int expectedModCount;
		private Iterator<T> iter;

		/**
		 * Sets up this iterator using the specified iterator.
		 *
		 * @param iter the list iterator created by a tree traversal
		 */
		public TreeIterator(Iterator<T> iter)
		{
			this.iter = iter;
			expectedModCount = modCount;
		}

		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 *
		 * @return  true if this iterator has at least one more element to deliver
		 *          in the iteration
		 * @throws  ConcurrentModificationException if the collection has changed
		 *          while the iterator is in use
		 */
		public boolean hasNext() throws ConcurrentModificationException
		{
			if (!(modCount == expectedModCount))
				throw new ConcurrentModificationException();

			return (iter.hasNext());
		}

		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iterator is empty
		 */
		public T next() throws NoSuchElementException
		{
			if (hasNext())
				return (iter.next());
			else 
				throw new NoSuchElementException();
		}

		/**
		 * The remove operation is not supported.
		 * 
		 * @throws UnsupportedOperationException if the remove operation is called
		 */
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	public String toString() 
	{
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inOrder(root, tempList);
        
        return tempList.toString();
	}
	protected void inOrder(BinaryTreeNode<T> node, 
			ArrayUnorderedList<T> tempList) 
	{
		if (node != null)
		{
			inOrder(node.getLeft(), tempList);
			tempList.addToRear(node.getElement());
			inOrder(node.getRight(), tempList);
		}
	}
}
