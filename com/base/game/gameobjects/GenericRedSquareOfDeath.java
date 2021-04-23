package com.base.game.gameobjects;

public class GenericRedSquareOfDeath extends Enemy {
	public static final int SIZE = 32;

	public GenericRedSquareOfDeath(float x, float y, int exp, int str, int def, int th) {
		super(x, y, exp, str, def, th);
		this.init(x, y, 1f, 0f, 0f, SIZE, SIZE, "Enemy");
		setAttackCoolDown(1000);
	}

	@Override
	protected void attack() {
		getTarget().damage(getStrength() - getTarget().getDefense());
		System.out.println("The Generic Red Square of Death attacks! " + getTarget().getHP()+"/"+getTarget().getMaxHP());
		restartAttackCoolDown();
	}
}
