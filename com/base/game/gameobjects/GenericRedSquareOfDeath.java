package com.base.game.gameobjects;

/**
 * A class for behavior specific to the Generic Red Square of Death enemy
 *
 * @author Jason Truskowski
 */
public class GenericRedSquareOfDeath extends Enemy {
	/**
	 * The size of the Generic Red Square of Death
	 */
	public static final int SIZE = 32;

	/**
	 * Constructor for a new G.R.S.O.D.
	 *
	 * @param xCoord Starting x-coordinate
	 * @param yCoord Starting y-coordinate
	 * @param experience Experience points
	 * @param strength Strength stat
	 * @param defense Defense stat
	 * @param threshold Level-up threshold
	 */
	public GenericRedSquareOfDeath(final float xCoord, final  float yCoord,final  int experience, final  int strength, final int defense, final int threshold) {
		super(experience, strength, defense, threshold);
		this.init(xCoord, yCoord, 1f, 0f, 0f, SIZE, SIZE, "Enemy");
		setAttackCoolDown(1000);
	}

	/**
	 * Causes the G.R.S.O.D. to attack the player
	 */
	@Override
	protected void attack() {
		getTarget().damage(getStrength() - getTarget().getDefense());//NOPMD
		System.out.println("The Generic Red Square of Death attacks! Your health: "
				+ getTarget().getHP()+"/"+getTarget().getMaxHP());//NOPMD
		restartAttackCoolDown();
	}
}
