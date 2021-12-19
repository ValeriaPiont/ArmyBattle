package com.game.units;

import com.game.weapon.Weapon;

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
       // this.defence = this.defence + weapon.getDefence();
        this.defense = Math.max(0,this.defense + weapon.getDefence());

       // this.defence = getDefence() + weapon.getDefence(); //was
      //  this.vampirism = Math.max(0, this.vampirism + weapon.getVampirism());
    }

    @Override
    public void damage(HasAttack warrior) {
        setHealth(getHealth() - Math.max(0, warrior.getAttack() - defense));
    }

    @Override
    protected int getInitAttack() {
        return attack;
    }

    @Override
    public int getDefense() {
        return defense;
    }
}