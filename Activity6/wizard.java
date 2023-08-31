package Project3.characters;

import java.util.Random;

public class wizard extends GameCharacter {

	public wizard(String Name) {
		super(Name);
	}
	
	public int attack() {
		super.attack();
		
		Random gen = new Random();
		
		int num = gen.nextInt(20);
		
		if (num > 1 && num < 9) {
			critHit = true;
			attack = attack * (12/10); 
		}
		
		return attack;
		
	}
	
	public String attackPhrase() {
		return name + " casts a spell doing " + attack + " damage!";
	}
	

	public String toString() {
		String result = super.toString(); 
		
		result += " type = wizard ";
		
		result += " Critical hit Rate: 35%";
		
		return result;
	}
	
	public void CriticalHit() {
		if (critHit == true) {
			System.out.println("Critical Hit");
		}
	}


}
