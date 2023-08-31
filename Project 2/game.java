package Project3.characters;

public class game {

	public static void main(String[] args) {
		
		Mario ch1 = new Mario("Mario");
		Legolas ch2 = new Legolas("Legolas");
		int round = 0;
		int points = 0;
		boolean end = false;
		
		System.out.println("Starting game");
		
		System.out.println();
		
		while (end == false) {
			
			
				System.out.println("Round " + round + ":" +  "\t" + ch1.toString() + "\t" + ch2.toString());
				points = ch1.attack();
				System.out.println(ch1.getName() + " swings the Wrench of Power with " + points + " points.");
				if (ch2.dodge() == true) {
					System.out.println(ch2.getName() + " jumps over wrench!");
				} else if (ch2.dodge() == false) {
					ch2.hit(points);
					System.out.println(ch2.getName() + " health reduced by " + points);
				}
				points = ch2.attack();
				System.out.println(ch2.getName() + " swings the Wrench of Power with " + points + " points.");
				if (ch1.dodge() == true) {
					System.out.println(ch1.getName() + " ducks into a pipe!");
				} else if (ch1.dodge() == false) {
					ch1.hit(points);
					System.out.println(ch1.getName() + " health reduced by " + points);
				}	
			
			round++;
				
			System.out.println();
			
			if(ch1.isAlive() == false || ch2.isAlive() == false) {
			end = true;
			
			}
		}
		
		if (ch1.isAlive() == false) {
			System.out.println(ch1.getName() + " has been defeated!");
		} else if (ch2.isAlive() == false) {
			System.out.println(ch2.getName() + " has been defeated!");
		}

	}

}
