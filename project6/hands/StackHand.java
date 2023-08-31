package project6.hands;

import project6.cards.PlayingCard;
import project6.jsjf.LinkedStack;

public class StackHand implements HandOfCards {
	
	LinkedStack<String> hand = new LinkedStack<String>();
	private int value;
	

	@Override
	public void add(PlayingCard c) {
		value = c.getValue();
		
		hand.push(Integer.toString(value));
		
	}

	

	@Override
	public int getValue() {
		return value;
	}



	@Override
	public void print() {
		System.out.println(hand.toString());
		
	}
	
	public int play() {
		
		value = Integer.parseInt(hand.peek());
		
		hand.pop();
		
		return value;
		
	}
	
	public int size() {
		return hand.size();
	}
	
	public boolean isEmpty() {
		return hand.isEmpty();
	}

}
