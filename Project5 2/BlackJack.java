package week5;

import week5.cards.PlayingCard;
import week5.hands.ArrayListHand;
import week5.hands.ArrayHand;
import week5.hands.BagHand;
import java.util.Scanner;


public class BlackJack {

		public static void main(String[] args) {
			
			int val1;
			int val2;
			boolean quit = false;
			String exit;
			
			Scanner scan = new Scanner(System.in);
			  
	        while (quit != true) {
	        	
	        ArrayListHand h1 = new ArrayListHand();
		    ArrayHand h2 = new ArrayHand();
		    BagHand h3 = new BagHand();
	        	
	        PlayingCard p1 = new PlayingCard();
		    PlayingCard p2 = new PlayingCard();
		    PlayingCard p3 = new PlayingCard();
		    PlayingCard p4 = new PlayingCard();
		    PlayingCard p5 = new PlayingCard();
		    PlayingCard p6 = new PlayingCard();
		        
	        	
	        
	        h1.add(p2); 
	        h1.add(p5);
	        
	        System.out.println("ArrayList Hand: ");
	        System.out.println();
	        System.out.println("Cards: ");
	        h1.print();
	        System.out.println();
	        val1 = h1.getValue();
	        if (val1 == 21) {
	        	System.out.println("BLACKJACK!");
	        } else {
	        System.out.println("value: " + val1);
	        }
	        System.out.println();
	        
	        h2.add(p1); 
	        h2.add(p4);
	        
	        System.out.println("Array Hand: ");
	        System.out.println();
	        System.out.println("Cards: ");
	        h2.print();
	        System.out.println();
	        val2 = h2.getValue();
	        if (val2 == 21) {
	        	System.out.println("BLACKJACK!");
	        } else {
	        System.out.println("value: " + val2);
	        }
	        System.out.println();
	        
	        h3.add(p3); 
	        h3.add(p6);
	        h3.print();
	        
	        System.out.println();
	        
	        System.out.println("Want to play one more round? Y/N");
	        exit = scan.nextLine();
	        
	        if (exit.equalsIgnoreCase("N")) {
	        	quit = true;
	        } 
	        	
	        
	}
		}

}
