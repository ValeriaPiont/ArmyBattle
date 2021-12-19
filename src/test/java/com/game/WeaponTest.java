package com.game;

import com.game.units.*;
import com.game.weapon.Sword;
import com.game.weapon.Weapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeaponTest {
//    health - добавляет к максимальному и текущему запасу здоровья солдата указанное число
//    attack - добавляет к атаке солдата указанное число
//    defense - добавляет к защите солдата указанное число
//    vampirism - увеличивает вампиризм на указанное количество процентов
//    heal_power - увеличивает количество здоровья, которое восстанавливает лекарь при каждом исцелении на указанное число

    @Test
    @DisplayName("Test Weapon 1")
    public void testWeapon1(){
        var warrior = new Warrior();
        var vampire = new Vampire();

        warrior.equipWeapon(Weapon.builder().health(-10).attack(5).defence(0).vampirism(40).healPower(0).build());
        vampire.equipWeapon(Sword.getSword());

        assertTrue(Battle.fight(warrior, vampire));

    }

    @Test
    @DisplayName("Test Weapon 2")
    public void testWeapon2(){
        var defender = new Defender();
        var lancer = new Lancer();

        defender.equipWeapon(Weapon.getShield());
        lancer.equipWeapon(Weapon.getGreatAxe());

        assertFalse(Battle.fight(defender, lancer));

    }

    @Test
    @DisplayName("Test Weapon 3")
    public void testWeapon3(){
        var defender = new Defender();
        var lancer = new Lancer();

        defender.equipWeapon(Weapon.getShield());
        lancer.equipWeapon(Weapon.getGreatAxe());

        assertFalse(Battle.fight(defender, lancer));

    }

    @Test
    @DisplayName("Test Weapon 4")
    public void testWeapon4(){
        var defender = new Defender();
        var vampire = new Vampire();

        System.out.println(defender);
        //    Shield - health +20, attack -1, defense +2
        defender.equipWeapon(Weapon.getShield());
        //    MagicWand - health +30, attack +3, heal_power +3
        defender.equipWeapon(Weapon.getMagicWand());
        System.out.println(defender);
        System.out.println("-----------------");
        System.out.println(vampire);
        //    Shield - health +20, attack -1, defense +2
        vampire.equipWeapon(Weapon.getShield());
        //    Katana - health -20, attack +6, defense -5, vampirism +50%
        vampire.equipWeapon(Weapon.getKatana());
        System.out.println(vampire);
        System.out.println("-----------------");
        assertFalse(Battle.fight(defender, vampire));

    }


    @Test
    @DisplayName("Test Weapon 5")
    public void testWeapon5(){
        Army army = new Army();
        army.addUnits(Knight.class, 1);
        army.addUnits(Lancer.class, 1);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(Vampire.class, 1);
        enemyArmy.addUnits(Healer.class, 1);

        army.getUnit(0).equipWeapon(Weapon.getMagicWand());
        army.getUnit(1).equipWeapon(Weapon.getGreatAxe());

        enemyArmy.getUnit(0).equipWeapon(Weapon.getMagicWand());
        enemyArmy.getUnit(1).equipWeapon(Weapon.getGreatAxe());

        assertTrue(Battle.fight(army, enemyArmy));

    }



}
