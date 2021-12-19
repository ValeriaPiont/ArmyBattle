package com.game;

import com.game.units.Defender;
import com.game.units.Knight;
import com.game.units.Vampire;
import com.game.units.Warrior;
import com.game.units.Healer;
import com.game.units.Lancer;

import com.game.weapons.Sword;
import com.game.weapons.Weapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeaponTest {

    @Test
    @DisplayName("fightWithWeapon1: weapon(health -10, attack 5, vampirism 40), Sword")
    void fightWithWeapon1_shouldReturnTrue(){
        var warrior = new Warrior();
        var vampire = new Vampire();

        warrior.equipWeapon(Weapon.builder().health(-10).attack(5).defence(0).vampirism(40).healPower(0).build());
        vampire.equipWeapon(Sword.getSword());

        assertTrue(Battle.fight(warrior, vampire));

    }


    @Test
    @DisplayName("fightWithWeapon2: Shield, GreatAxe")
    void fightWithWeapon2_shouldReturnFalse(){
        var defender = new Defender();
        var lancer = new Lancer();

        defender.equipWeapon(Weapon.getShield());
        lancer.equipWeapon(Weapon.getGreatAxe());

        assertFalse(Battle.fight(defender, lancer));

    }

    @Test
    @DisplayName("fightWithWeapon3: Shield, GreatAxe")
     void fightWithWeapon3_shouldReturnFalse(){
        var defender = new Defender();
        var lancer = new Lancer();

        defender.equipWeapon(Weapon.getShield());
        lancer.equipWeapon(Weapon.getGreatAxe());

        assertFalse(Battle.fight(defender, lancer));

    }

    @Test
    @DisplayName("fightWithWeapon4: Shield, MagicWand")
    void fightWithWeapon4_shouldReturnFalse(){
        var defender = new Defender();
        var vampire = new Vampire();

        defender.equipWeapon(Weapon.getShield());
        defender.equipWeapon(Weapon.getMagicWand());

        vampire.equipWeapon(Weapon.getShield());
        vampire.equipWeapon(Weapon.getKatana());

        assertFalse(Battle.fight(defender, vampire));
    }


    @Test
    @DisplayName("fightWithWeapon4: MagicWand, GreatAxe, MagicWand, GreatAxe")
    void fightWithWeapon5_shouldReturnTrue(){
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
