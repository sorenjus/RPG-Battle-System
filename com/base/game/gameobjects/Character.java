package com.base.game.gameobjects;

import com.base.engine.GameObject;
import org.lwjgl.input.Keyboard;
/**
 * @author Justin Sorensen
 *This class represents a character, which progresses as experience in gained through battle
 */
public class Character extends GameObject {

	//String containing the characters name//
	private String name;
	//Integer values containing various stats of the character//
	private int strength, defense, experience, level, hp;
	//Integer values representing the original HP, strength, and defense of the character//
	private int baseStrength, baseDefense, baseHP;
	//Integer of experience needed to reach the next level//
	private int levelThreshold;

	public static final float SIZE = 32;
/**
	 /*
	 * This constructor creates a new character
	 */
	public Character(float x, float y) {
		init(x,y,0.1f,1f,0.25f,SIZE,SIZE);
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

	/**
	 * Move the character and display character stats based on input key
	 */
	public void getInput(){
		if (Keyboard.isKeyDown(Keyboard.KEY_W)){ move(0, 1);}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)){ move (0, -1);}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)){ move (-1, 0);}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)){ move (1, 0);}
		if (Keyboard.isKeyDown(Keyboard.KEY_1)){ System.out.println(this.characterToString());}
	}

	private void move(float magX, float magY){
		this.x += getSpeed() * magX;
		this.y += getSpeed() * magY;
	}

	/**
	 * default speed the sprite moves on the map
	 * @return float
	 */
	public float getSpeed(){
		return 4f;
	}

	/**
	 * This constructor returns all of the details of the character
	 * @return String
	 */
	public String characterToString() {
		return "Name : " + this.name + "\nLevel : " + this.level + "\nHP : " + this.hp + "\nStrength : " + this.strength 
				+ "\nDefense : " + this.defense + "\nTo Next Level : " + (this.levelThreshold - this.experience);
	}
	
	/**
	 * Function returning the character's name
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Function returning the character's HP
	 * @return int
	 */
	public int getHP() {
		return this.hp;
	}
	
	/**
	 * Function returning the character's strength
	 * @return int
	 */
	public int getStrength() {
		return this.strength;
	}
	
	/**
	 * Function returning the character's defense
	 * @return int
	 */
	public int getDefense() {
		return this.defense;
	}
	
	/**
	 * Function returning the characters amount of experience
	 * @return int
	 */
	public int getExperience() {
		return this.experience;
	}
	
	/**
	 * This function raises the characters experience by the amount of experience gained
	 * in battle. It then evaluates if the amount of experience meets the current level threshold. 
	 * If so the character levels up
	 * @param battleExp battle experience
	 */
	public void setExperience(int battleExp) {
		this.experience += battleExp;
		if(this.experience >= this.levelThreshold) {
			this.levelUp();
		}
	}
	
	/**
	 * Function returning the characters experience threshold
	 * @return int
	 */
	public int getThreshold() {
		return this.levelThreshold;
	}
	
	/**
	 * Function returning the characters level
	 * @return int
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * Function increasing the charater's level
	 */

	private void levelUp() {
		this.level += 1;
		this.hp = incHP();
		this.strength = incStat(this.baseStrength);
		this.defense = incStat(this.baseDefense);
		this.levelThreshold = setThreshold() + 50;
	}

	/**
	 * Function returning a new threshold for leveling up
	 * @return int
	 */
	private int setThreshold() {
		return 25 * this.level * this.level - 25 * this.level;
	}

	/**
	 * Function returning an increase in stats
	 * @return int
	 */
	private int incStat(int stat) {
		return ((stat * this.level)/2 + 2);
	}

	/**
	 * Function returning an increase in HP
	 * @return int
	 */

	private int incHP() {
		return ((this.getStrength() * (200 * this.getLevel()))/100) + 30;
	}
}
