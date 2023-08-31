package week6.hands;

import week6.cards.PlayingCard;
import week6.hands.HandOfCards;

//ArrayHand is a class implementing a hand of cards using an array
public class ArrayHand implements HandOfCards {

	private PlayingCard hand[];
	private int count;
	
	public ArrayHand () {
		this(2);
	}
	
	public ArrayHand(int length) {
		count = 0;
		hand = new PlayingCard[length];
		for (int ii=0;ii<length;ii++)
			hand[ii] = null;
	}
	
	@Override
	public void add(PlayingCard c) {
		if (count < hand.length) {
			hand[count] = c;
			count ++;
		}
		// else hand is full so do nothing
	}

	@Override
	public void print() {
		for (int ii=0; ii<hand.length; ii++) {
			System.out.println("Card " + ii + ": " + hand[ii]);
		}
	}

	@Override
	public int getValue() {
		int total = 0;
		for (int ii=0; ii<hand.length; ii++) {
			total += hand[ii].getValue();
		}
		return total;
	}
}
