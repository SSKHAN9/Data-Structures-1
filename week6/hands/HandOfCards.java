package week6.hands;

import week6.cards.PlayingCard;

public interface HandOfCards {
	public void add(PlayingCard c);
	public void print();
	public int getValue();
}
