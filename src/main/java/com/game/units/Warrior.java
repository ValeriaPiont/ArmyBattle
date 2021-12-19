package com.game.units;

import com.game.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Warrior implements HasAttack {

    private static final int START_HEALTH = 50;
    private static final int DEFAULT_WARRIOR_ATTACK = 5;
    private int initHealth;
    private int health;

    private Warrior behindWarrior;
    private final List<Weapon> weaponList = new ArrayList<>();

    protected Warrior(int health) {
        this.health = health;
        this.initHealth = health;
    }

    public Warrior() {
        this(START_HEALTH);
    }

    public static Warrior of(String clazz) {
        return switch (clazz) {
            case "Warrior" -> new Warrior();
            case "Knight" -> new Knight();
            case "Defender" -> new Defender();
            case "Vampire" -> new Vampire();
            case "Lancer" -> new Lancer();
            case "Healer" -> new Healer();
            case "Warlord" -> new Warlord();
            case "Rookie" -> new Rookie();
            default -> throw new IllegalArgumentException("Invalid Warrior type");
        };
    }


    public void actionForBehind() {
        if (Objects.nonNull(this.getBehindWarrior())) {
            this.getBehindWarrior().processActionForBehind(this);
        }
    }

    public void processActionForBehind(Warrior warrior) {
        if (Objects.nonNull(warrior.getBehindWarrior())) {
            warrior.getBehindWarrior().actionForBehind();
        }
    }

    protected void setHealth(int health) {
        this.health = health;
    }


    public void equipWeapon(Weapon weapon) {
        this.weaponList.add(weapon);
        this.initHealth = getInitHealth() + weapon.getHealth();
        setHealth(getHealth() + weapon.getHealth());
    }

    public int getAttack() {
        if (getInitAttack() == 0){
            return 0;
        }
        return getInitAttack() + weaponList.stream().mapToInt(Weapon::getAttack).sum();
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public void damage(HasAttack warrior) {
        setHealth(getHealth() - warrior.getAttack());
    }

    public void attack(Warrior warrior) {
        warrior.damage(this);
        actionForBehind();
    }

    protected Warrior getBehindWarrior() {
        return behindWarrior;
    }

    public void setBehindWarrior(Warrior behindWarrior) {
        this.behindWarrior = behindWarrior;
    }

    protected int getInitHealth() {
        return initHealth;
    }

    public int getHealth() {
        return health;
    }

    protected int getInitAttack() {
        return DEFAULT_WARRIOR_ATTACK;
    }

}
