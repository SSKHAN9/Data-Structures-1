package week6.hands;

import java.util.Iterator;

import java.util.NoSuchElementException;

import week6.cards.PlayingCard;

public class LinkedListHand implements Iterable<PlayingCard>, HandOfCards {

      private ListNode head;

      private ListNode tail;

      private int size;

      private class ListNode {

            private PlayingCard element;

            private ListNode next;

            public ListNode(PlayingCard element, ListNode next) {

                  this.element = element;

                  this.next = next;

            }

      }

      public LinkedListHand() {

            size = 0;

            head = tail = null;

      }

      /******* Implement this method *******/

      public void addToFront(PlayingCard e) {

            // Create a new node that has the old head as its next

            ListNode newNode = new ListNode(e, head);

            // The head should refer to the new node (which is now the first node)

            head = newNode;

            if (head.next == null) {

                  // updating tail node

                  tail = head;

            }

            size++;

      }

      /******* Implement this method *******/

      public void addToRear(PlayingCard e) {

            // if the list was empty, addToFront

            // Otherwise, create a new tail

            if (isEmpty()) {

                  // adding as both head and tail

                  head = new ListNode(e, null);

                  tail = head;

            } else {

                  // appending to tail and updating tail

                  tail.next = new ListNode(e, null);

                  tail = tail.next;

            }

            size++;

      }

      /******* Implement this method *******/

      public PlayingCard removeFirst() {

            if (isEmpty()) {

                  throw new NoSuchElementException("Empty list");

            }

            // storing element at head

            PlayingCard item = head.element;

            // advancing head

            head = head.next;

            // if head is null. list became empty

            if (head == null) {

                  // updating all variables

                  tail = null;

                  size = 0;

                  // returning removed item

                  return item;

            }

            // else just decrementing size and returning item

            size--;

            return item;

      }

      /******* Implement this method *******/

      public PlayingCard removeLast() {

            if (isEmpty()) {

                  throw new NoSuchElementException("Empty list");

            }

            // Get the element from the head node

            // if there is only one element, remove it

            // Otherwise, find the new tail, traverse from the head

            PlayingCard item = head.element;

            if (head.next == null) {

                  //list became empty

                  head = null;

                  tail = null;

                  size = 0;

                  return item;

            }

            ListNode current = head;

            //finding node before tail

            while (current.next != tail) {

                  current = current.next;

            }

            //storing the value of tail

            item = tail.element;

            //removing tail

            current.next = null;

            //updating tail

            tail = current;

            size--;

            return item;

      }

      public int size() {

            return size;

      }

      public boolean isEmpty() {

            return (size == 0);

      }

      @Override

      public String toString() {

            String ret = "head -> ";

            // Traverse the lis

            ListNode current = head;

            while (current != null) {

                  ret += current.element + " -> ";

                  current = current.next;

            }

            return ret += "tail";

      }

      public PlayingCard first() {

            if (isEmpty()) {

                  throw new NoSuchElementException("Empty list");

            }

            return head.element;

      }

      public PlayingCard last() {

            if (isEmpty()) {

                  throw new NoSuchElementException("Empty list");

            }

            return tail.element;

      }

      @Override

      public Iterator iterator() {

            return new LinkedListIterator(head);

      }

      private class LinkedListIterator implements Iterator {

            private ListNode current;

            public LinkedListIterator(ListNode start) {

                  this.current = start;

            }

            @Override

            public boolean hasNext() {

                  return (current != null);

            }

            @Override

            public PlayingCard next() {

                  if (!hasNext()) {

                        throw new NoSuchElementException("Empty list");

                  }

                  PlayingCard ret = current.element;

                  current = current.next;

                  return ret;

            }

            @Override

            public void remove() {

            }

      }

	@Override
	public void add(PlayingCard c) {
		
	}

	@Override
	public void print() {
		
	}

	@Override
	public int getValue() {
		return 0;
	}
	}
