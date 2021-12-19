package com.game.units;

public class Knight extends Warrior {
	private static final int INIT_HEALTH = 50;
	private int attack = 7;

	public Knight() {
		super(INIT_HEALTH);
	}

	@Override
	protected int getInitAttack() {
		return attack;
	}
}
