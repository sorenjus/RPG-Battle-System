package com.base.game.gameobjects;

import com.base.engine.GameObject;

/**
 * A class for PlayerCharacters and Enemies that can battle each other
 *
 * @author Justin Sorensen, Jason Truskowski
 */
public class BattleObject extends GameObject {
	/**
	 * The battle stats of the BattleObject
	 */
	protected transient Stats stats;

	/**
	 * Returns the BattleObject's HP
	 *
	 * @return Current HP
	 */
	public int getHP() {
		if(stats.getHP() > getMaxHP()) {
			stats.setHP(getMaxHP());
		}

		return stats.getHP();
	}

	/**
	 * Returns the maximum HP the BattleObject can have
	 *
	 * @return Maximum HP
	 */
	public int getMaxHP() {
		return getLevel() * 10;
	}

	/**
	 * Returns the BattleObject's current level
	 *
	 * @return Current level
	 */
	public int getLevel() {
		return stats.getLevel();
	}

	/**
	 * Function returning the BattleObject's Strength stat
	 *
	 * @return Current strength
	 */
	public int getStrength() {
		return stats.getStrength();
	}

	/**
	 * Function returning the BattleObject's Defense stat
	 *
	 * @return Current defense
	 */
	public int getDefense() {
		return stats.getDefense();
	}

	/**
	 * Function returning the BattleObject's experience points
	 *
	 * @return Current amount of EXP
	 */
	public int getExperience() {
		return stats.getExperience();
	}

	/**
	 * Function returning how much EXP the BattleObject gives when defeated
	 *
	 * @return Amount of EXP awarded upon defeat
	 */
	public int getExpWorth () {
		return stats.getExpWorth();
	}

	/**
	 * Deals damage to a target
	 *
	 * @param dmg How much damage is being dealt
	 */
	public void damage(final int dmg) {
		stats.damage(dmg);
	}

	/**
	 * "Kills" the BattleObject by removing it from the game
	 */
	protected void die() {
		setDeleteTrue();
	}
}