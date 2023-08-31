package cards;
// Card class
// Constructor creates a joker, deal() method sets a rank & suit.
import java.util.Random;

public class PlayingCard {

	public final static String suits[] = {"X", "H", "S", "D", "C"};
	public final static String ranks[] = {"Joker", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
											"10", "J", "Q", "K"};
	private int rank;
	private int suit;
	
	// Default constructor makes the card a Joker initially
	public PlayingCard ()
	{
		rank = 0;
		suit = 0;
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
	
	public PlayingCard (int rank, int suit)
	{
		this.rank = rank;
		this.suit = suit;
	}

	// Getters & Setters
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void setRank(String rank) {
		this.rank = find_entry(rank, ranks);
	}

	public int getValue() {
		int ret = 0;
		if (rank == 1)
			ret = 11;
		else
			ret = Math.min(rank, 10);
		return ret;
	}
	
	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}
	
	public void setSuit(String suit) {
		this.suit = find_entry(suit, suits);
	}
	
	// Allow card to be printed nicely
	public String toString ()
	{
		return (ranks[rank] + suits[suit]);
	}
	
}
