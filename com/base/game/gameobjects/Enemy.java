package com.base.game.gameobjects;

import com.base.engine.GameObject;
import com.base.engine.Physics;

public class Enemy extends BattleObject {
	private Stats enStats;
	private BattleObject target;
	protected float attackRange = 50f;

	public Enemy(float x, float y, int exp, int str, int def, int th) {
		enStats = new Stats(exp, str, def, th, false);
		target = null;
	}

	public static int levelToExp(int level) {
		return 0;
	}

	@Override
	public void update() {
		if(target == null) {
			look();
		} else if(Physics.inLineOfSight(this, target) &&
				Physics.getDistance(xCoordinate, yCoordinate, getTarget().getX(), getTarget().getY()) <= attackRange) {
				attack();
		} else {
			chase();
		}

		if(enStats.getHP() <= 0) {
			die();
		}
	}

	protected void attack() {

	}

	protected void look() {

	}

	protected GameObject getTarget() {
		return target;
	}

	protected void setTarget(BattleObject go) {
		target = go;
	}

	protected void chase() {

	}

	protected void die() {

	}
}
