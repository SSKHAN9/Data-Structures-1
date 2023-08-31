package Project3.characters;

public class Mario extends GameCharacter {

	public Mario(String Name) {
		super(Name);
	}
	
	public String toString() {
		return name + ": strength: " + strength + "/10 health: " + health + "/20"; 
	}

}
