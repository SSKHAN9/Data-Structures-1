package project6;
import java.util.Scanner;
import project6.cards.PlayingCard;
import project6.hands.StackHand;

public class WarGame {

	public static void main(String[] args) {
		
		StackHand player1 = new StackHand();
		StackHand player2 = new StackHand();
		
		int player1_score = 0, player1_card;
		int player2_score = 0, player2_card;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many cards in each hand?");
		int count = scan.nextInt();
		
		for (int i = 0; i < count; i++ ) {
			PlayingCard p1 = new PlayingCard();
			PlayingCard p2 = new PlayingCard();
			
			player1.add(p1);
			player2.add(p2);
		}
		
		while (player1.isEmpty() != true) {
			player1_card = player1.play();
			player2_card = player2.play();
			
			System.out.println("Player 1's card is " + player1_card);
			System.out.println("Player 2's card is " + player2_card);
			
			if (player1_card > player2_card) {
				player1_score++;
				System.out.println("Player 1's card is higher than Player 2's. Player 1 wins!");
			} else if (player1_card < player2_card) {
				player2_score++;
				System.out.println("Player 2's card is higher than Player 1's. Player 2 wins!");
			} else if (player1_card == player2_card) {
				System.out.println("Player 2's card is the same as Player 1's. it's a Draw!");
			} 
			
		}
		
		System.out.println("Player 1's score is " + player1_score + ".");
		System.out.println("Player 2's score is " + player2_score + ".");
		
		if (player1_score > player2_score) {
			System.out.println("The winner is Player 1");
		} else if (player1_score < player2_score) {
			System.out.println("The winner is Player 2");
		} else if (player1_score == player2_score) {
			System.out.println("The game was a draw2");
		}
	}

}
