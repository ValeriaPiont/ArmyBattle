package com.game.units;

import java.util.Objects;

public class Lancer extends Warrior {
    private static final int START_HEALTH = 50;
    private int attack = 6;
    private static int weakening = 50;

    public Lancer() {
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
    public void attack(Warrior warrior) {
        int decreasing = warrior.getHealth();
        super.attack(warrior);
        decreasing = decreasing - warrior.getHealth();
        int attackForBehind = decreasing * weakening / 100;

        Warrior warriorBehind = warrior.getBehindWarrior();

        if (Objects.nonNull(warriorBehind)) {
            warriorBehind.damage(() -> attackForBehind);
        }
    }

    @Override
    public String toString() {
        return "Lancer";
    }
}
