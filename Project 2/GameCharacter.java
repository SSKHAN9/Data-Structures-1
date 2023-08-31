package Project3.characters;

import java.util.Random;

public abstract class GameCharacter {
	
	protected String name;
	protected int health = 20;
	protected int strength = 10;
	
	public GameCharacter(String Name) {
		name = Name;
	}
	public int attack() {
		Random gen = new Random();
		
		int attack = gen.nextInt(10) + 1;
		
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
	

}
