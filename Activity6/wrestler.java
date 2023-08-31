package Project3.characters;

import java.util.Random;

public class wrestler extends GameCharacter {

	public wrestler(String Name) {
		super(Name);
	}
	
	public int attack() {
		super.attack();
		
		Random gen = new Random();
		
		int num = gen.nextInt(5);
		
		if (num == 3 || num == 1) {
			critHit = true;
			attack = attack * (12/10); 
		}
		
		return attack;
		
	}
	
	public String attackPhrase() {
		return name + " launches a punch doing " + attack + " damage!";
	}
	
	

	public String toString() {
		String result = super.toString(); 
		
		result += " type = wrestler ";
		
		result += " Critical hit Rate: 40%";
		
		return result;
	}
	
	public void CriticalHit() {
		if (critHit == true) {
			System.out.println("Critical Hit");
		}
	}
}
