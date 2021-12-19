package com.game;

import com.game.units.*;
import com.game.weapons.Weapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WarlordTest {

     @Test
     @DisplayName("first fight: both of armies have Warlord")
     void fight1_shouldReturnTrue() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warlord.class, 1);
        army1.addUnits(Warrior.class, 2);
        army1.addUnits(Lancer.class, 2);
        army1.addUnits(Healer.class, 2);

        army2.addUnits(Warlord.class, 1);
        army2.addUnits(Vampire.class, 1);
        army2.addUnits(Healer.class, 2);
        army2.addUnits(Knight.class, 2);

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));

    }

    @Test
    @DisplayName("second fight: both of armies have Warlord")
    void fight2_shouldReturnFalse() {
       Army army1 = new Army()
                        .addUnits(Warrior.class, 2)
                        .addUnits(Lancer.class, 2)
                        .addUnits(Defender.class, 1)
                        .addUnits(Warlord.class, 3);
       Army army2 = new Army()
                        .addUnits(Warlord.class, 2)
                        .addUnits(Vampire.class, 1)
                        .addUnits(Healer.class, 5)
                        .addUnits(Knight.class, 2);

        army1.moveUnits();
        army2.moveUnits();
        assertFalse(Battle.fight(army1, army2));
    }


    @Test
    @DisplayName("third fight: both of armies have Warlord, weapons: Sword and Shield")
    void fight3_shouldReturnTrue() {
        Army army1 = new Army()
                .addUnits(Warrior.class, 2)
                .addUnits(Lancer.class, 3)
                .addUnits(Defender.class, 1)
                .addUnits(Warlord.class, 4);

        Army army2 = new Army()
                .addUnits(Warlord.class, 1)
                .addUnits(Vampire.class, 1)
                .addUnits(Rookie.class, 1)
                .addUnits(Knight.class, 1);

        army1.getUnit(0).equipWeapon(Weapon.getSword());
        army2.getUnit(0).equipWeapon(Weapon.getShield());
        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("fourth fight: both of armies have Warlord, weapons: Sword and Shield")
    void fight4_shouldReturnFalse() {
        Army army1 = new Army()
                .addUnits(Warrior.class, 2)
                .addUnits(Lancer.class, 3)
                .addUnits(Defender.class, 1)
                .addUnits(Warlord.class, 1);

        Army army2 = new Army()
                .addUnits(Warlord.class, 5)
                .addUnits(Vampire.class, 1)
                .addUnits(Rookie.class, 1)
                .addUnits(Knight.class, 1);

        army1.getUnit(0).equipWeapon(Weapon.getSword());
        army2.getUnit(0).equipWeapon(Weapon.getShield());
        army1.moveUnits();
        army2.moveUnits();

        assertFalse(Battle.straightFight(army1, army2));
    }

}
