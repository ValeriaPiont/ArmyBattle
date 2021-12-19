package com.game.units;

import com.game.weapons.Weapon;

public class Vampire extends Warrior {
    private static final int START_HEALTH = 40;
    private int vampirism = 50;
    private int attack = 4;

    public Vampire() {
        super(START_HEALTH);
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    protected void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        this.vampirism = Math.max(0, this.vampirism + weapon.getVampirism());
    }

    @Override
    public void attack(Warrior warrior) {
        int damage = warrior.getHealth();
        super.attack(warrior);
        damage = damage - warrior.getHealth();

        setHealth(Math.min(getHealth() + damage * vampirism / 100, getStartHealth()));

    }

    @Override
    public String toString() {
        return "Vampire";
    }
}
