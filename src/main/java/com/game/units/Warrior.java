package com.game.units;

import com.game.weapons.Weapon;

import java.util.Objects;

public class Warrior implements HasAttack {

    private static final int START_HEALTH = 50;
    private int attack = 5;
    private final int startHealth;
    private int health;
    private Warrior behindWarrior;

    protected Warrior(int health) {
        this.health = health;
        this.startHealth = health;
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
            default -> throw new IllegalArgumentException("Invalid warrior type");
        };
    }

    public void equipWeapon(Weapon weapon) {
        setHealth(getHealth() + weapon.getHealth());
        setAttack(getAttack() + weapon.getAttack());
    }

    protected void damage(HasAttack warrior) {
        setHealth(getHealth() - warrior.getAttack());
    }

    public void attack(Warrior warrior) {
        warrior.damage(this);
        actionForBehind();
    }

    protected void actionForBehind() {
        if (Objects.nonNull(this.getBehindWarrior())) {
            this.getBehindWarrior().processActionForBehind(this);
        }
    }

    protected void processActionForBehind(Warrior warrior) {
        if (Objects.nonNull(warrior.getBehindWarrior())) {
            warrior.getBehindWarrior().actionForBehind();
        }
    }


    public int getAttack() {
        return attack;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    protected Warrior getBehindWarrior() {
        return behindWarrior;
    }

    public void setBehindWarrior(Warrior behindWarrior) {
        this.behindWarrior = behindWarrior;
    }

    protected int getStartHealth() {
        return startHealth;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Warrior";
    }
}
