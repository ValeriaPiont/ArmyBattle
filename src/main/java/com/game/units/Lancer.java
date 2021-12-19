package com.game.units;

import java.util.Objects;

public class Lancer extends Warrior {
    private static final int INIT_HEALTH = 50;
    private int attack = 6;

    public Lancer() {
        super(INIT_HEALTH);
    }

    @Override
    protected int getInitAttack() {
        return attack;
    }

    @Override
    public void attack(Warrior warrior) {
        int healthDecrease = warrior.getHealth();
        super.attack(warrior);
        healthDecrease = healthDecrease - warrior.getHealth();
        int decay = 50;
        int attackForSecond = healthDecrease * decay / 100;
        if (!Objects.isNull(warrior.getBehindWarrior())) {
            warrior.getBehindWarrior().damage(() -> attackForSecond);
        }
    }
}
