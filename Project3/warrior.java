package Project3.characters;

import java.util.Random;

public class warrior extends GameCharacter {

	public warrior(String Name) {
		super(Name);
		
	}
	
	public int attack() {
		super.attack();
		
		Random gen = new Random();
		
		int num = gen.nextInt(10);
		
		if (num > 2 && num < 9) {
			critHit = true;
			attack = attack * (12/10); 
		}
		
		return attack;
		
	}
	
	public String attackPhrase() {
		return name + " swings the sword doing " + attack + " damage!";
	}

	public String toString() {
		String result = super.toString(); 
		
		result += " type = warrior ";
		
		result += " Critical hit Rate: 60%";
		
		return result;
	}
	
	public void CriticalHit() {
		if (critHit == true) {
			System.out.println("Critical Hit");
		}
	}


}
