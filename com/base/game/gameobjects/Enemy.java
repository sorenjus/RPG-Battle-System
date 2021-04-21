package com.base.game.gameobjects;

import com.base.engine.GameObject;
import com.base.engine.Physics;
import com.base.game.Cooldown;

public class Enemy extends BattleObject {
	private Stats enStats;
	private BattleObject target;
	private float attackRange;
	private Cooldown attackCoolDown;

	public Enemy(float x, float y, int exp, int str, int def, int th) {
		enStats = new Stats(exp, str, def, th, false);
		target = null;
		attackRange = 50f;
		attackCoolDown = new Cooldown(0);
		attackCoolDown.stop();
	}

	public static int levelToExp(int level) {
		return 0;
	}

	@Override
	public void update() {
		if(target == null) {
			look();
		} else if(attackCoolDown.isCooldownOver() && Physics.inLineOfSight(this, target) &&
				Physics.getDistance(xCoordinate, yCoordinate, getTarget().getX(), getTarget().getY()) <= attackRange) {
				attack();
		} else {
			chase();
		}

		if(enStats.getHP() <= 0) {
			die();
		}
	}

	public void setAttackRange(int dist) {
		attackRange = dist;
	}

	public void setAttackCoolDown(int time) {
		attackCoolDown = new Cooldown(time);
		attackCoolDown.stop();
	}

	public void restartAttackCoolDown() {
		attackCoolDown.start();
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
