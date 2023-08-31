package Project3.characters;

import java.util.Random;

public abstract class GameCharacter {
	
	protected String name;
	protected int health = 20;
	protected int strength = 10;
	protected boolean critHit = false;
	protected int attack;
	
	public GameCharacter(String Name) {
		name = Name;
	}
	public int attack() {
		Random gen = new Random();
		
		attack = gen.nextInt(10) + 1;
		
		return attack;		
	}
	
	public boolean dodge() {
		Random gen = new Random();
		int num = gen.nextInt(11);
		
		if (num == 7) {
			return true;
		} else
			return false;
	}
	
	public void hit(int points) {
		health -= points;
		
		if (health <= 0) {
			health = 0;
		}
	}
	
	public boolean isAlive() {
		if (health <= 0) {
			return false;
		} else if (health > 0) {
			return true;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name + ": strength: " + strength + "/10 health: " + health + "/20"; 
	}

	public void CritHit() {
		if (critHit == true) {
			System.out.println( "Critical Hit!");
		}

	}
	
	public abstract String attackPhrase();
	
	public abstract void CriticalHit();
}
