package com.game.units;

import com.game.weapons.Weapon;

public class Defender extends Warrior implements HasDefense {
    private static final int START_HEALTH = 60;
    private int defense = 2;
    private int attack = 3;

    public Defender() {
        super(START_HEALTH);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        this.defense = Math.max(0, this.defense + weapon.getDefence());
    }

    @Override
    protected void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    protected void damage(HasAttack warrior) {
        setHealth(getHealth() - Math.max(0, warrior.getAttack() - defense));
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public String toString() {
        return "Defender";
    }
}