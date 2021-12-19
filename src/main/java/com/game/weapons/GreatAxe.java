package com.game.weapons;

public class GreatAxe extends Weapon {
    private static final int HEALTH = -15;
    private static final int ATTACK = 5;
    private static final int DEFENCE = -2;
    private static final int VAMPIRISM = 10;
    private static final int HEAL_POWER = 0;

    private static GreatAxe instance;

    public GreatAxe() {
        super(HEALTH, ATTACK, DEFENCE, VAMPIRISM, HEAL_POWER);
    }

    public static GreatAxe getInstance() {
        if (instance == null) {
            instance = new GreatAxe();
        }
        return instance;
    }
}
