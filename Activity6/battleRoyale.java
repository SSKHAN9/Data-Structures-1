package Project3.characters;

import java.util.ArrayList;
import java.util.Random;

public class battleRoyale {

	public static void main(String[] args) {
		
		int round = 0;
		int points = 0;
		boolean end = false;
		Random gen = new Random();
		int ch1, ch2;
		ArrayList<String> players = new ArrayList<String>();
			
			GameCharacter[] characters = {
					new warrior("Mike"),
					new archer("Alex"),
					new wizard("Cole"),
					new wrestler("Kim")
			};
			
			for (int i = 0; i < characters.length; i++) {
				players.add(characters[i].getName());
			}
			
			
		while (end == false) {
			ch1 = 0;
			ch2 = 0;
			
			while (ch1 == ch2 || (characters[ch1].isAlive() == false || characters[ch2].isAlive() == false)) {
				ch1 = gen.nextInt(4);
				ch2 = gen.nextInt(4);
				
			}
			
				System.out.println("Round " + round + ":" +  "\t" + characters[ch1].toString() + "\t" + characters[ch2].toString());
				points = characters[ch1].attack();
				System.out.println(characters[ch1].attackPhrase());
				if (characters[ch2].dodge() == true) {
					System.out.println(characters[ch2].getName() + " dodges the attack!");
				} else if (characters[ch2].dodge() == false) {
					characters[ch2].hit(points);
					characters[ch2].CriticalHit();
					System.out.println(characters[ch2].getName() + " health reduced by " + points);
				}
				
				if (characters[ch2].isAlive() == true) {
				points = characters[ch2].attack();
				System.out.println(characters[ch2].attackPhrase());
				if (characters[ch1].dodge() == true) {
					System.out.println(characters[ch1].getName() + " dodges the attack!");
				} else if (characters[ch1].dodge() == false) {
					characters[ch1].hit(points);
					System.out.println(characters[ch1].getName() + " health reduced by " + points);
				}	
				} else if (characters[ch2].isAlive() ==  false) {
					System.out.println(characters[ch2].getName() + " is defeated!");
				}
			
			round++;
				
			System.out.println();
			
			
			
			if (characters[0].isAlive() == false && characters[1].isAlive() == false && characters[2].isAlive() == false ) {
				end = true;
			} else if (characters[0].isAlive() == false && characters[2].isAlive() == false && characters[3].isAlive() == false ) {
				end = true;
			} else if (characters[0].isAlive() == false && characters[1].isAlive() == false && characters[3].isAlive() == false ) {
				end = true;
			} else if (characters[3].isAlive() == false && characters[1].isAlive() == false && characters[2].isAlive() == false ) {
				end = true;
			}
			
			}

			for (int i = 0; i < players.size(); i++) {
				
				for (int j = 0; j < characters.length; j++) {
				
				if(players.get(i) ==  characters[j].getName() && characters[j].isAlive() == false && players.size() > 1) {
				
					players.remove(i);
					
				}
				}
						
				}
		
		for (int i = 0; i < 4; i++) {
				System.out.println(characters[i].toString());
		}
			
		System.out.println();
		
		for (int i = 0; i < 4; i++) {
			if (characters[i].isAlive() == true) {
				System.out.println(players.get(0) + " is the last one standing.");
			}
		}

		}
	}
