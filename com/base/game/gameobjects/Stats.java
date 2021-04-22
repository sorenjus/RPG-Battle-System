package com.base.game.gameobjects;

public class Stats {
	private int exp, hp, level, strength, defense, baseHp, baseStr, baseDef, levelThreshold;
	private boolean canLevel;

	public Stats(int exp, int str, int def, int th, boolean canLevel) {
		this.canLevel = canLevel;
		this.strength = str;
		this.baseStr = str;
		this.defense = def;
		this.baseDef = def;
		this.levelThreshold = th;

		if(canLevel) {
			this.exp = exp;
			this.level = 1;
		} else {
			this.exp = -1;
			this.level = exp;
		}
		this.hp = getMaxHP();
	}

	/**
	 * Function returning the character's HP
	 *
	 * @return int
	 */
	public int getHP() {
		if(hp > getMaxHP()) {
			hp = getMaxHP();
		}

		return hp;
	}

	public int getMaxHP() {
		return getLevel() * 10; // arbitrary value, may change for balance
	}

	public int getLevel() {
		return level;
	}

	/**
	 * Function returning the character's strength
	 *
	 * @return int
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * Function returning the character's defense
	 *
	 * @return int
	 */
	public int getDefense() {
		return defense;
	}

	public boolean getCanLevel() {
		return canLevel;
	}

	/**
	 * Function returning the characters amount of experience
	 *
	 * @return int
	 */
	public int getExperience() {
		return exp;
	}

	/**
	 * This function raises the characters experience by the amount of experience gained
	 * in battle. It then evaluates if the amount of experience meets the current level threshold.
	 * If so the character levels up
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
		this.defense = incStat(this.baseDef);
		this.levelThreshold = returnThreshold() + 50;
	}

	/**
	 * Level threshold is set based on character level
	 *
	 * @return int
	 */
	private int returnThreshold() {
		return 25 * this.level * this.level - 25 * this.level;
	}

	/**
	 * Function reducing the characters healthpoint
	 */
	public void decHP(){
		hp = hp - 10;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}

	/**
	 * Function returning the characters experience threshold
	 *
	 * @return int
	 */
	public int getThreshold() {
		return levelThreshold;
	}

	/**
	 * Increases Character stats
	 *
	 * @param stat Character stat
	 * @return int
	 */
	private int incStat(final int stat) {
		return (stat * this.level) / 2 + 2;
	}

	/**
	 * Increase Character HP
	 *
	 * @return int
	 */
	private int incHP() {
		return (this.getStrength() * (200 * this.getLevel())) / 100 + 30;
	}

	public void damage(int dmg) {
		hp -= dmg;
	}
}
