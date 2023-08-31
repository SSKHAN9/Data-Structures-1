package Project3.characters;

public class Legolas extends GameCharacter {

	public Legolas(String Name) {
		super(Name);
	}

	public String toString() {
		return name + ": strength: " + strength + "/10 health: " + health + "/20"; 
	}
	
}
