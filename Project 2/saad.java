package Project3.characters;

public class saad extends GameCharacter {

	public saad(String Name) {
		super(Name);
	}

	public String toString() {
		return name + ": strength: " + strength + "/10 health: " + health + "/20"; 
	}
}
