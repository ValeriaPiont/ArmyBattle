package com.game.weapons;

public class Sword extends Weapon {
    private static final int HEALTH = 5;
    private static final int ATTACK = 2;
    private static final int DEFENCE = 0;
    private static final int VAMPIRISM = 0;
    private static final int HEAL_POWER = 0;

    private static Sword instance;

    private Sword() {
        super(HEALTH, ATTACK, DEFENCE, VAMPIRISM, HEAL_POWER);
    }

    public static Sword getInstance() {
        if (instance == null) {
            instance = new Sword();
        }
        return instance;
    }
}
