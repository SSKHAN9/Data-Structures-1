package week5.hands;

import java.util.ArrayList;
import java.util.Iterator;

import week5.cards.PlayingCard;

public class ArrayListHand implements HandOfCards, Iterable<PlayingCard> {

    ArrayList<PlayingCard> hand;
    private int value;

    public ArrayListHand() {
        hand = new ArrayList<>();
        
        value = 0;
    }

    // adds the PlayingCard to the ArrayList
    @Override
    public void add(PlayingCard c) {
    	
    	value = c.getValue();

        //adding card to myHand

        hand.add(c);

  }


    // Prints each card in the hand
    @Override
    public void print() {
    	for (int ii=0; ii<hand.size(); ii++) {
			System.out.println("Card " + (1+ii) + ": " + hand.get(ii));
		}
    }

    @Override
    public Iterator<PlayingCard> iterator() {
        return hand.iterator();
    }

	@Override
	public int getValue() {
		return value;
	}
}

