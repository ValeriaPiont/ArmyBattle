package com.game.units;

public class Rookie extends Warrior {
    private static final int START_HEALTH = 50;
    private int attack = 1;

    public Rookie() {
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
        return "Rookie";
    }
}
