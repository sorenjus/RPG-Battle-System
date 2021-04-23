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
	private int experience, healthPoints, level, strength, defense, baseHp, baseStr, baseDef, levelThreshold, expWorth;

	/**
	 * Whether the GameObject can level up
	 */
	private final boolean canLevel;

	/**
	 * Constructor for a new set of stats
	 *
	 * @param experience Starting experience points
	 * @param strength Starting strength
	 * @param defense Starting defense
	 * @param threshold Starting level-up threshold
	 * @param expWorth How much EXP is given upon defeat
	 * @param canLevel Whether the GameObject can level up
	 */
	public Stats(final int experience, final int strength, final int defense, final int threshold, final int expWorth, final boolean canLevel) {
		this.canLevel = canLevel;
		this.strength = strength;
		this.baseStr = strength;
		this.defense = defense;
		this.baseDef = defense;
		this.levelThreshold = threshold;

		if(canLevel) {
			this.experience = experience;
			this.level = 1;
			this.expWorth = 0;
		} else {
			this.experience = -1;
			this.level = experience;
			this.expWorth = expWorth;
		}
		this.healthPoints = getMaxHP();
	}

	/**
	 * Function returning the character's HP
	 *
	 * @return Current HP
	 */
	public int getHP() {
		if(healthPoints > getMaxHP()) {
			healthPoints = getMaxHP();
		}

		return healthPoints;
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
		return experience;
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
		experience += battleExp;
		if (this.experience >= this.levelThreshold) {
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
		this.healthPoints = incHP();
		this.strength = incStat(this.baseStr);
		this.levelThreshold = returnThreshold(this.level);
	}

	/**
	 * Determines how much EXP is needed to level up to the next level
	 *
	 * @return Level threshold based on character level
	 */
	private int returnThreshold( final int lvl) {
		return 25 * lvl * lvl - 25 * lvl + 50;
	}

	/**
	 * Changes the GameObject's current HP
	 *
	 * @param healthPoints Desired HP
	 */
	public void setHP( final int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public void setDefense(  final int defense) {
		this.defense = defense;
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

	public void setStrength( final int strength) {
		this.strength = strength;
	}

	/**
	 * Deals damage to the target
	 *
	 * @param dmg The amount of HP being taken away
	 */
	public void damage( final int dmg) {
		healthPoints -= dmg;
	}
}
