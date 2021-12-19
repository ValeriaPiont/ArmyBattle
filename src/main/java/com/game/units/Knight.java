package com.game.units;

public class Knight extends Warrior {
    private static final int START_HEALTH = 50;
    private int attack = 7;

    public Knight() {
        super(START_HEALTH);
    }

    @Override
    protected void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
