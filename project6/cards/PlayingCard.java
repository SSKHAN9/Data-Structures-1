package project6.cards;
import java.util.Random;

public class PlayingCard {

	private final static String suits[] = {"None", "H", "S", "D", "C"};
	private final static String ranks[] = {"Joker", "A", "2", "3", "4", "5", "6", "7", "8", "9", 
											"10", "J", "Q", "K"};
	private int rank;
	private int suit;
	
	// Default constructor 
	public PlayingCard ()
	{
		chooseRandomCardValue();
	}
	
	public PlayingCard (int rank, int suit)
	{
		this.rank = 0;
		this.suit = 0;
		if ( (suit > 0) && (suit < suits.length) ) {
			if ( (rank > 0) && (rank < ranks.length) ) {
				this.suit = suit;
				this.rank = rank;
			}
		}
	}
	
	public PlayingCard (String rank, String suit)
	{
		this.rank = find_entry(rank, ranks);
		this.suit = find_entry(suit, suits);
	}	
	
	private static int find_entry(String value, String values[]) 
	{
		int ret = 0;
		for (int ii=0;ii<values.length;ii++)
		{
			if (value.toUpperCase() == values[ii].toUpperCase()) 
				ret = ii;
		}
		return ret;
	}

	private void chooseRandomCardValue()	
	{
		Random randNum = new Random();
		rank = randNum.nextInt(ranks.length-1) + 1;
		suit = randNum.nextInt(suits.length-1) + 1;
	}
	
	// Getters 
	public int getRank() {
		return rank;
	}
	public int getSuit() {
		return suit;
	}
	public String getRankName() {
		return ranks[rank];
	}
	public String getSuitName() {
		return suits[suit];
	}
	
	// Allow card to be printed nicely
	public String toString ()
	{
		return ("" + ranks[rank] + suits[suit]);
	}
	
	public int getValue() {
		int ret = 0;
		if (rank == 1)
			ret = 11;
		else
			ret = Math.min(rank, 10);
		return ret;
	}

}
