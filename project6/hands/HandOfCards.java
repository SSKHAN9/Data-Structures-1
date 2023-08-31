package project6.hands;

import project6.cards.PlayingCard;

public interface HandOfCards {
	public void add(PlayingCard c);
	public void print();
	public int getValue();
}
