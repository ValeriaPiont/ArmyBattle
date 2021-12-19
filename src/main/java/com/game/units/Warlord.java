package com.game.units;

import com.game.weapon.Weapon;

public class Warlord extends Warrior implements HasDefense {
    private static final int INIT_HEALTH = 100;
    private int defense = 2;
    private int attack;

    public Warlord() {
        super(INIT_HEALTH);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        this.defense = Math.max(0,this.defense + weapon.getDefence());
      //  this.defence = getDefence() + weapon.getDefence();

    }

    @Override
    protected int getInitAttack() {
        return attack;
    }

    @Override
    public void damage(HasAttack warrior) {
        setHealth(getHealth() - Math.max(0, warrior.getAttack() - getDefense()));
    }

    @Override
    public int getDefense() {
        return defense;
    }
}
