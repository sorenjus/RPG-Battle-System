package game;

/**
 * @author Justin Sorensen
 *
 */
public class character {
	
	String name;
	int strength, defense, experience, level, hp;
	int baseStrength, baseDefense, baseHP;
	int levelThreshold;
	
	public static void main(String[] args) {
		character newChar = new character("Peter");
		System.out.println(newChar.characterToString());
		newChar.levelUp();
		System.out.println(newChar.characterToString());
		newChar.levelUp();
		System.out.println(newChar.characterToString());
		newChar.levelUp();
		System.out.println(newChar.characterToString());
		newChar.levelUp();
		System.out.println(newChar.characterToString());
		newChar.levelUp();
		newChar.setExperience(50);
		System.out.println(newChar.characterToString());
	}

	public character() {
		name = "Char";
		level = 0;
		hp = 0;
		strength = 0;
		defense = 0;
		experience = 0;	
	}
	
	public character(String entry) {
		name = entry;
		level = 1;
		baseStrength = 5;
		strength = baseStrength;
		baseHP = incHP();
		hp = baseHP;
		baseDefense = 5;
		defense = baseDefense;
		experience = 0;
		levelThreshold = 50;
	}
	
	public String characterToString() {
		return "Name : " + this.name + "\nLevel : " + this.level + "\nHP : " + this.hp + "\nStrength : " + this.strength 
				+ "\nDefense : " + this.defense + "\nTo Next Level : " + (this.levelThreshold - this.experience);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	public int getDefense() {
		return this.defense;
	}
	
	public int getExperience() {
		return this.experience;
	}
	
	public void setExperience(int battleExp) {
		this.experience += battleExp;
		if(this.experience >= this.levelThreshold) {
			this.levelUp();
		}
	}
	
	public int getThreshold() {
		return this.levelThreshold;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setName(String charName) {
		this.name = charName;
	}
	
	private void levelUp() {
		this.level += 1;
		this.hp = incHP();
		this.strength = incStat(this.baseStrength);
		this.defense = incStat(this.baseDefense);
		this.levelThreshold = setThreshold() + 50;
	}
	
	private int setThreshold() {
		return 25 * this.level * this.level - 25 * this.level;
	}
	
	private int incStat(int stat) {
		return ((stat * this.level)/2 + 2);
	}
	
	private int incHP() {
		return ((this.getStrength() * (200 * this.getLevel()))/100) + 30;
	}
}