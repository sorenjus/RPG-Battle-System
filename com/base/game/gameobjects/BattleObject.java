package com.base.game.gameobjects;

import com.base.engine.GameObject;

public class BattleObject extends GameObject {
	protected Stats stats;

	/**
	 * Function returning the character's HP
	 *
	 * @return int
	 */
	public int getHP() {
		if(stats.getHP() > getMaxHP()) {
			stats.setHP(getMaxHP());
		}

		return stats.getHP();
	}

	public int getMaxHP() {
		return getLevel() * 10; // arbitrary value, may change for balance
	}

	public int getLevel() {
		if(!stats.getCanLevel()) {
			return stats.getLevel();
		}

		// TODO: Determine calculation for level if canLevel
		return stats.getLevel();
	}

	/**
	 * Function returning the character's strength
	 *
	 * @return int
	 */
	public int getStrength() {
		return stats.getStrength();
	}

	/**
	 * Function returning the character's defense
	 *
	 * @return int
	 */
	public int getDefense() {
		return stats.getDefense();
	}

	/**
	 * Function returning the characters amount of experience
	 *
	 * @return int
	 */
	public int getExperience() {
		return stats.getExperience();
	}

	public void damage(int dmg) {
		stats.damage(dmg);
	}

	protected void die() {
		setDeleteTrue();
	}
}