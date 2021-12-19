package com.game.weapons;

public class Katana extends Weapon {
    private static final int HEALTH = -20;
    private static final int ATTACK = 6;
    private static final int DEFENCE = -5;
    private static final int VAMPIRISM = 50;
    private static final int HEAL_POWER = 0;

    private static Katana instance;

    public Katana() {
        super(HEALTH, ATTACK, DEFENCE, VAMPIRISM, HEAL_POWER);
    }

    public static Katana getInstance() {
        if (instance == null) {
            instance = new Katana();
        }
        return instance;
    }
}
