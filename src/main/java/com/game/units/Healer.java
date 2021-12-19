package com.game.units;

import com.game.weapon.Weapon;

public class Healer extends Warrior {
    private static final int INIT_HEALTH = 60;
    private int healPower = 2;
    private int attack = 0;

    public Healer() {
        super(INIT_HEALTH);
    }

    @Override
    public void processActionForBehind(Warrior warrior) {
        heal(warrior);
        super.actionForBehind();
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        setHealth(getHealth() + weapon.getHealth());
        //this.healPower = this.healPower + weapon.getHealPower();
        this.healPower = Math.max(0, this.healPower + weapon.getHealPower());
    }

    @Override
    protected int getInitAttack() {
        return attack;
    }

    private void heal(Warrior warrior) {
        warrior.setHealth(Math.min(warrior.getHealth() + healPower, warrior.getInitHealth()));
    }
}
