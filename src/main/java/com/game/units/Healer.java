package com.game.units;

import com.game.weapons.Weapon;

public class Healer extends Warrior {
    private static final int START_HEALTH = 60;
    private int healPower = 2;
    private int attack = 0;

    public Healer() {
        super(START_HEALTH);
    }

    @Override
    protected void processActionForBehind(Warrior warrior) {
        heal(warrior);
        super.actionForBehind();
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        setHealth(getHealth() + weapon.getHealth());
        this.healPower = Math.max(0, this.healPower + weapon.getHealPower());
    }

    @Override
    public int getAttack() {
        return attack;
    }

    private void heal(Warrior warrior) {
        warrior.setHealth(Math.min(warrior.getHealth() + healPower, warrior.getStartHealth()));
    }

    @Override
    public String toString() {
        return "Healer";
    }
}
