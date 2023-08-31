package week6;

import week6.cards.Deck;

import week6.cards.PlayingCard;

import week6.hands.HandOfCards;

import week6.hands.LinkedListHand;

public class Driver {

      public static void main(String[] args) {

            Deck d = new Deck(52);

            LinkedListHand myList = new LinkedListHand();

            myList.addToFront(d.dealOne());

            myList.addToFront(d.dealOne());

            myList.addToFront(d.dealOne());

            myList.addToFront(d.dealOne());

            System.out.println(myList);

            System.out.println("Size of list: " + myList.size());

            System.out.println("First node in list " + myList.first());

            System.out.println("Last node in list " + myList.last());

            System.out.println("\n");

            if (myList.isEmpty()) {

                  System.out.println("List is empty");

            } else {

                  System.out.println("List is not empty");

            }

            System.out.println("\nRemove first and last nodes of the list:");

            PlayingCard front = myList.removeFirst();

            PlayingCard rear = myList.removeLast();

            System.out.println("Updated size of list: " + myList.size());

            System.out.println("Old front: " + front);

            System.out.println("Old rear: " + rear);

            System.out.println("New front: " + myList.first());

            System.out.println("New rear: " + myList.last());

            System.out.println(myList);

            System.out.println("\nRemove the rest:");

            rear = myList.removeLast();

            front = myList.removeFirst();

            System.out.println("Updated size of list: " + myList.size());

            System.out.println("Old front: " + front);

            System.out.println("Old rear: " + rear);

            System.out.println(myList);

            if (myList.isEmpty()) {

                  System.out.println("List is empty");

            } else {

                  System.out.println("List is not empty");

            }

      }

}