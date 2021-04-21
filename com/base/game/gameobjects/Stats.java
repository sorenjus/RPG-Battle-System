package com.base.game.gameobjects;

public class Stats {
	private float exp;
	private int hp;
	private int level;
	private boolean canLevel;

	public Stats(float exp, boolean canLevel) {
		this.canLevel = canLevel;

		if(canLevel) {
			this.exp = exp;
			this.level = 1;
		} else {
			this.exp = -1;
			this.level = (int)exp;
		}
		this.hp = getMaxHP();
	}

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
		if(!canLevel) {
			return level;
		}

		// TODO: Determine calculation for level if canLevel
		return level;
	}

	public void damage(int dmg) {
		
	}
}
