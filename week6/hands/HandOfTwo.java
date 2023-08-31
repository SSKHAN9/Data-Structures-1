package week6.hands;

import week6.cards.PlayingCard;
import week6.hands.HandOfCards;

// HandOfTwo is a class implementing a hand of 2 cards using 2 variables
public class HandOfTwo implements HandOfCards {

	PlayingCard card1;
	PlayingCard card2;

	public void HandOf2() {
		card1 = null;
		card2 = null;
	}

	@Override
	public void add(PlayingCard c) {
		if (card1 == null)
			card1 = c;
		else if (card2 == null)
			card2 = c;
		// else hand is full, do nothing
	}

	@Override
	public void print() {
		if (card1 != null)
			System.out.println("Card 1: " + card1);
		if (card2 != null)
			System.out.println("Card 2: " + card2);
	}

	@Override
	public int getValue() {
		int total = 0;
		if (card1 != null) {
			total += card1.getValue();
		}
		if (card2 != null) {
			total += card2.getValue();
		}
		return total;
	}

}