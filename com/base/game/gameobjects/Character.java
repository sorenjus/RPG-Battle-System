package com.base.game.gameobjects;

import com.base.engine.GameObject;
import com.base.engine.Sprite;
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
/*
	 * This is a basic constructor of a character when no parameters are given
	 */
	public Character(float x, float y) {
		init(x,y,0.1f,1f,0.25f,SIZE,SIZE);
	}

	/*
	 * This constructor creates a new character
	 * @param entry the name of the character

	public Character(String entry) {
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
	*/
	/*
	 * This constructor returns all of the details of the character
	 * @return String
	 */
	public String characterToString() {
		return "Name : " + this.name + "\nLevel : " + this.level + "\nHP : " + this.hp + "\nStrength : " + this.strength 
				+ "\nDefense : " + this.defense + "\nTo Next Level : " + (this.levelThreshold - this.experience);
	}
	
	/*
	 * Function returning the character's name
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Function returning the character's HP
	 * @return int
	 */
	public int getHP() {
		return this.hp;
	}
	
	/*
	 * Function returning the character's strength
	 * @return int
	 */
	public int getStrength() {
		return this.strength;
	}
	
	/*
	 * Function returning the character's defense
	 * @return int
	 */
	public int getDefense() {
		return this.defense;
	}
	
	/*
	 * Function returning the characters amount of experience
	 * @return int
	 */
	public int getExperience() {
		return this.experience;
	}
	
	/*
	 * This function raises the characters experience by the amount of experience gained
	 * in battle. It then evaluates if the amount of experience meets the current level threshold. 
	 * If so the character levels up
	 * @param battle experience
	 */
	public void setExperience(int battleExp) {
		this.experience += battleExp;
		if(this.experience >= this.levelThreshold) {
			this.levelUp();
		}
	}
	
	/*
	 * Function returning the characters experience threshold
	 * @return int
	 */
	public int getThreshold() {
		return this.levelThreshold;
	}
	
	/*
	 * Function returning the characters level
	 * @return int
	 */
	public int getLevel() {
		return this.level;
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
