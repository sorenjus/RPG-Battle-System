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
	 * @param x Starting x-coordinate
	 * @param y Starting y-coordinate
	 * @param exp Experience points
	 * @param str Strength stat
	 * @param def Defense stat
	 * @param th Level-up threshold
	 */
	public GenericRedSquareOfDeath(float x, float y, int exp, int str, int def, int th) {
		super(exp, str, def, th);
		this.init(x, y, 1f, 0f, 0f, SIZE, SIZE, "Enemy");
		setAttackCoolDown(1000);
	}

	/**
	 * Causes the G.R.S.O.D. to attack the player
	 */
	@Override
	protected void attack() {
		getTarget().damage(getStrength() - getTarget().getDefense());
		System.out.println("The Generic Red Square of Death attacks! Your health: "
				+ getTarget().getHP()+"/"+getTarget().getMaxHP());
		restartAttackCoolDown();
	}
}
