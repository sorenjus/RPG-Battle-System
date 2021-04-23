package com.base.game.gameobjects;

/**
 * Class for managing the various stats of GameObjects
 *
 * @author Justin Sorensen, Jason Truskowski
 */
public class Stats {
	/**
	 * Numerical values for each stat
	 */
	private int exp, hp, level, strength, defense, baseHp, baseStr, baseDef, levelThreshold, expWorth;

	/**
	 * Whether the GameObject can level up
	 */
	private boolean canLevel;

	/**
	 * Constructor for a new set of stats
	 *
	 * @param exp Starting experience points
	 * @param str Starting strength
	 * @param def Starting defense
	 * @param th Starting level-up threshold
	 * @param expWorth How much EXP is given upon defeat
	 * @param canLevel Whether the GameObject can level up
	 */
	public Stats(int exp, int str, int def, int th, int expWorth, boolean canLevel) {
		this.canLevel = canLevel;
		this.strength = str;
		this.baseStr = str;
		this.defense = def;
		this.baseDef = def;
		this.levelThreshold = th;

		if(canLevel) {
			this.exp = exp;
			this.level = 1;
			this.expWorth = 0;
		} else {
			this.exp = -1;
			this.level = exp;
			this.expWorth = expWorth;
		}
		this.hp = getMaxHP();
	}

	/**
	 * Function returning the character's HP
	 *
	 * @return Current HP
	 */
	public int getHP() {
		if(hp > getMaxHP()) {
			hp = getMaxHP();
		}

		return hp;
	}

	/**
	 * Determines the maximum HP the GameObject can ever have
	 *
	 * @return Maximum HP
	 */
	public int getMaxHP() {
		return getLevel() * 10;
	}

	/**
	 * Returns the current level of the GameObject
	 *
	 * @return Current level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Function returning the GameObject's strength
	 *
	 * @return Strength stat
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * Function returning the GameObject's defense
	 *
	 * @return Defense stat
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Determines if the GameObject can level up
	 *
	 * @return Whether the GameObject can level up
	 */
	public boolean getCanLevel() {
		return canLevel;
	}

	/**
	 * Function returning the GameObject's amount of experience
	 *
	 * @return Experience points
	 */
	public int getExperience() {
		return exp;
	}

	/**
	 * Returns how much EXP the GameObject gives upon its defeat
	 *
	 * @return Amount of EXP given
	 */
	public int getExpWorth() {
		return expWorth;
	}

	/**
	 * This function raises the characters experience by the amount of experience gained
	 * in battle. It then evaluates if the amount of experience meets the current level threshold.
	 * If so, the character levels up
	 *
	 * @param battleExp battle experience
	 */
	public void setExperience(final int battleExp) {
		exp += battleExp;
		if (this.exp >= this.levelThreshold) {
			this.levelUp();
			System.out.println("Level Up! You're now Level " + getLevel());
			System.out.println("HP: " + getHP());
			System.out.println("Strength: " + getStrength());
			System.out.println("Defense: " + getDefense());
			System.out.println("EXP for next level: " + getThreshold());
		}
	}

	/**
	 * Function increases Character stats when threshold is met
	 */
	private void levelUp() {
		this.level += 1;
		this.hp = incHP();
		this.strength = incStat(this.baseStr);
		this.levelThreshold = returnThreshold(this.level);
	}

	/**
	 * Determines how much EXP is needed to level up to the next level
	 *
	 * @return Level threshold based on character level
	 */
	private int returnThreshold(int lvl) {
		return (25 * lvl * lvl) - (25 * lvl) + 50;
	}

	/**
	 * Changes the GameObject's current HP
	 *
	 * @param hp Desired HP
	 */
	public void setHP(int hp) {
		this.hp = hp;
	}

	/**
	 * Function returning the character's experience threshold
	 *
	 * @return Threshold to level up
	 */
	public int getThreshold() {
		return levelThreshold;
	}

	/**
	 * Increases Character stats
	 *
	 * @param stat The stat being increased
	 * @return The new value of the stat
	 */
	private int incStat(final int stat) {
		return (stat * this.level) / 2 + 2;
	}

	/**
	 * Increases Character HP
	 *
	 * @return New HP amount
	 */
	private int incHP() {
		return (this.getStrength() * (200 * this.getLevel())) / 100 + 30;
	}

	/**
	 * Deals damage to the target
	 *
	 * @param dmg The amount of HP being taken away
	 */
	public void damage(int dmg) {
		hp -= dmg;
	}
}
