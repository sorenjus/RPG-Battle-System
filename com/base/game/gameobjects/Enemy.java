package com.base.game.gameobjects;

import com.base.engine.GameObject;
import com.base.engine.Main;
import com.base.engine.Physics;
import com.base.game.Cooldown;

import java.util.ArrayList;

/**
 * A class for behaviors specific to Enemies
 *
 * @author Jason Truskowski
 */
public class Enemy extends BattleObject {
	/**
	 * What the Enemy is currently trying to attack
	 */
	private BattleObject target;

	/**
	 * The distance and strength of the Enemy's attacks
	 */
	private int attackRange, attackPower;

	/**
	 * How long the Enemy has to wait between attacks
	 */
	private Cooldown attackCoolDown;

	/**
	 * Factor by which the Enemy is slower than the PlayerCharacter
	 */
	public static final float SLOWDOWN = 0.5f;

	/**
	 * Maximum distance the Enemy can see potential targets from
	 */
	public static float vision = 150f;

	/**
	 * Constructor for a new Enemy
	 *
	 * @param experience The Enemy's experience points
	 * @param strength How much damage the Enemy deals
	 * @param defense How much damage the Enemy can nullify at a time
	 * @param threshold The level threshold of the Enemy
	 */
	public Enemy(final int experience, final int strength, final int defense, final int threshold) {
		stats = new Stats(experience, strength, defense, threshold, 50,false);
		target = null;
		attackRange = 50;
		attackCoolDown = new Cooldown(0);
		attackCoolDown.stop();
	}

	/**
	 * Determines the Enemy's next behavior
	 */
	@Override
	public void update() {
		if(target == null || target.getHP() <= 0) {
			look();
		} else if(Physics.inLineOfSight(this, target) &&
				Physics.getDist(xCoordinate, yCoordinate, getTarget().getX(), getTarget().getY()) <= attackRange) {
			if(attackCoolDown.isCooldownOver())
			{
				attack();
			}
		} else {
			chase();
		}

		if(stats.getHP() <= 0)
		{
			die();
		}
	}

	/**
	 * Changes the enemy's attack range
	 *
	 * @param dist Desired attack range
	 */
	public void setAttackRange(final int dist) {
		attackRange = dist;
	}

	/**
	 * Changes the cooldown time between Enemy attacks
	 *
	 * @param time Desired cooldown time
	 */
	public void setAttackCoolDown( final int time) {
		attackCoolDown = new Cooldown(time);
		attackCoolDown.stop();
	}

	/**
	 * Allows the Enemy to attack again after their cooldown is up
	 */
	public void restartAttackCoolDown() {
		attackCoolDown.start();
	}

	/**
	 * Returns the Enemy's attack power
	 *
	 * @return Attack power
	 */
	public int getAttackPower() {
		return attackPower;
	}

	/**
	 * Changes the Enemy's attack power
	 *
	 * @param dmg Desired attack power
	 */
	public void setAttackPower(final int dmg) {
		attackPower = dmg;
	}

	/**
	 * Makes the Enemy attack (overridden for each specific enemy)
	 */
	protected void attack() { }

	/**
	 * Changes the distance the Enemy can see the player from
	 *
	 * @param vis Desired vision
	 */
	public void setVision(final float vis) {
		vision = vis;
	}

	/**
	 * Makes the Enemy search for a target until one is in range
	 */
	protected void look() {
		final ArrayList<GameObject> seen = Main.inRadius(getX(), getY(), vision);

		for(final GameObject seenOb : seen) {
			if(seenOb instanceof PlayerCharacter) {
				setTarget((BattleObject)seenOb);
			}
		}
	}

	/**
	 * Returns the Enemy's current target
	 *
	 * @return Current target
	 */
	protected BattleObject getTarget() {
		return target;
	}

	/**
	 * Changes the Enemy's target
	 *
	 * @param gameobject New target
	 */
	protected void setTarget(final BattleObject gameobject) {
		target = gameobject;
	}

	/**
	 * Changes the Enemy's position to get closer to its target
	 */
	protected void chase() {
		float speedX = getTarget().getX() - getX();
		float speedY = getTarget().getY() - getY();
		final float speedCap = 4f * SLOWDOWN;

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
}
