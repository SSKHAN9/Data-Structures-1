package Project3.characters;

import java.util.Random;

public class archer extends GameCharacter {

	public archer(String Name) {
		super(Name);
	}

	public int attack() {
		super.attack();
		
		Random gen = new Random();
		
		int num = gen.nextInt(5);
		
		if (num == 2) {
			critHit = true;
			attack = attack * (12/10); 
		}
		
		return attack;
		
	}
	
	public String attackPhrase() {
		return name + " fires an arrow doing " + attack + " damage!";
	}
	

	public String toString() {
		String result = super.toString(); 
		
		result += " type = archer ";
		
		result += " Critical hit Rate: 20%";
		
		return result;
	}
	
	public void CriticalHit() {
		if (critHit == true) {
			System.out.println("Critical Hit");
		}
	}

}
