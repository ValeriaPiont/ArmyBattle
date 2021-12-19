package com.game.units;

public class Rookie extends Warrior {
    private static final int INIT_HEALTH = 50;
    private int attack = 1;

    public Rookie() {
        super(INIT_HEALTH);
    }

    @Override
    protected int getInitAttack() {
        return attack;
    }
}
