package com.base.game.gameobjects;

import com.base.engine.GameObject;
import com.base.engine.Main;
import com.base.engine.Physics;
import com.base.game.Cooldown;

import java.util.ArrayList;

public class Enemy extends BattleObject {
	private BattleObject target;
	private float attackRange;
	private Cooldown attackCoolDown;
	private int attackPower;
	public static final float SLOWDOWN = 0.5f;
	public static float vision = 150f;

	public Enemy(float x, float y, int exp, int str, int def, int th) {
		stats = new Stats(exp, str, def, th, false);
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
		} else if(Physics.inLineOfSight(this, target) &&
				Physics.getDistance(xCoordinate, yCoordinate, getTarget().getX(), getTarget().getY()) <= attackRange) {
			if(attackCoolDown.isCooldownOver()) {
				attack();
			}
		} else {
			chase();
		}

		if(stats.getHP() <= 0) {
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

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int dmg) {
		attackPower = dmg;
	}

	protected void attack() {

	}

	public void setVision(float vis) {
		vision = vis;
	}

	protected void look() {
		ArrayList<GameObject> seen = Main.inRadius(getX(), getY(), vision);

		for(GameObject seenOb : seen) {
			if(seenOb instanceof PlayerCharacter) {
				setTarget((BattleObject)seenOb);
			}
		}
	}

	protected BattleObject getTarget() {
		return target;
	}

	protected void setTarget(BattleObject go) {
		target = go;
	}

	protected void chase() {
		float speedX = getTarget().getX() - getX();
		float speedY = getTarget().getY() - getY();
		float speedCap = 4f * SLOWDOWN;

		if(speedX > speedCap) {
			speedX = speedCap;
		} else if(speedX < -speedCap) {
			speedX = -speedCap;
		}
		if(speedY > speedCap) {
			speedY = speedCap;
		} else if(speedY < -speedCap) {
			speedY = -speedCap;
		}

		setX(getX() + speedX);
		setY(getY() + speedY);
	}

	protected void die() {
		setDeleteTrue();
	}
}
