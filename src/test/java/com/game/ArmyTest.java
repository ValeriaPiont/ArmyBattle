package com.game;

import com.game.units.*;
import com.game.weapon.Shield;
import com.game.weapon.Sword;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {
    @ParameterizedTest(name = "[{index}] | expected = {0} | firstArmy = {1} | secondArmy = {2} | ")
    @MethodSource("fightDataProvider_fights1")
    @DisplayName("fights between warriors and warriors")
    void fights1(boolean expected, Army army1, Army army2) {
        assertEquals(expected, Battle.fight(army1, army2));
    }

    static Stream<Arguments> fightDataProvider_fights1() {
        return Stream.of(
                //battle 4
                Arguments.of(true, new Army()
                                .addUnits(Warrior.class, 20),
                        new Army()
                                .addUnits(Warrior.class, 21)),
                //battle 6
                Arguments.of(true, new Army()
                                .addUnits(Warrior.class, 11),
                        new Army()
                                .addUnits(Warrior.class, 7)),
                //battle 5
                Arguments.of(true, new Army()
                                .addUnits(Warrior.class, 10),
                        new Army()
                                .addUnits(Warrior.class, 11))
        );
    }

    @ParameterizedTest(name = "[{index}] | expected = {0} | firstArmy = {1} | secondArmy = {2} | ")
    @MethodSource("fightDataProvider_fights2")
    @DisplayName("fights between warriors and defenders")
    void fights2(boolean expected, Army army1, Army army2) {
        assertEquals(expected, Battle.fight(army1, army2));
    }

    static Stream<Arguments> fightDataProvider_fights2() {
        return Stream.of(
                //battle 7
                Arguments.of(true, new Army()
                                .addUnits(Warrior.class, 5)
                                .addUnits(Defender.class, 4)
                                .addUnits(Defender.class, 5),
                        new Army()
                                .addUnits(Warrior.class, 4)),
                //battle 8
                Arguments.of(true, new Army()
                                .addUnits(Defender.class, 5)
                                .addUnits(Warrior.class, 20)
                                .addUnits(Defender.class, 4),
                        new Army()
                                .addUnits(Warrior.class, 21)),
                //battle 9
                Arguments.of(true, new Army()
                                .addUnits(Warrior.class, 10)
                                .addUnits(Defender.class, 5)
                                .addUnits(Defender.class, 10),
                        new Army()
                                .addUnits(Warrior.class, 5)),
                //battle 10
                Arguments.of(false, new Army()
                                .addUnits(Defender.class, 2)
                                .addUnits(Warrior.class, 1)
                                .addUnits(Defender.class, 1),
                        new Army()
                                .addUnits(Warrior.class, 5))
        );
    }


    @ParameterizedTest(name = "[{index}] | expected = {0} | firstArmy = {1} | secondArmy = {2} | ")
    @MethodSource("fightDataProvider_fights3")
    @DisplayName("fights between warriors, defenders, vampires")
    void fights3(boolean expected, Army army1, Army army2) {
        assertEquals(expected, Battle.fight(army1, army2));
    }

    static Stream<Arguments> fightDataProvider_fights3() {
        return Stream.of(
                //battle 11
                Arguments.of(false, new Army()
                                .addUnits(Defender.class, 5)
                                .addUnits(Vampire.class, 6)
                                .addUnits(Warrior.class, 7),
                        new Army().addUnits(Warrior.class, 6)
                                .addUnits(Defender.class, 6)
                                .addUnits(Vampire.class, 6)),
                //battle 12
                Arguments.of(false, new Army()
                                .addUnits(Defender.class, 2)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Warrior.class, 4),
                        new Army().addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Vampire.class, 3)),
                //battle 13
                Arguments.of(true, new Army()
                                .addUnits(Defender.class, 11)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Warrior.class, 4),
                        new Army().addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Vampire.class, 3)),
                //battle 14
                Arguments.of(true, new Army()
                                .addUnits(Defender.class, 9)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Warrior.class, 8),
                        new Army().addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Vampire.class, 13))

        );
    }


    @ParameterizedTest(name = "[{index}] | expected = {0} | firstArmy = {1} | secondArmy = {2} | ")
    @MethodSource("fightDataProvider_fights4")
    @DisplayName("fights between warriors, defenders, vampires, lancers")
    void fights4(boolean expected, Army army1, Army army2) {
        assertEquals(expected, Battle.fight(army1, army2));
    }

    static Stream<Arguments> fightDataProvider_fights4() {
        return Stream.of(
                //battle 15
                Arguments.of(false, new Army()
                                .addUnits(Lancer.class, 5)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 2),
                        new Army().addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Vampire.class, 6)
                                .addUnits(Lancer.class, 5)),
                //battle 11
                Arguments.of(true, new Army()
                                .addUnits(Lancer.class, 7)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 2),
                        new Army().addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Vampire.class, 6)
                                .addUnits(Lancer.class, 4))
        );
    }

    @ParameterizedTest(name = "[{index}] | expected = {0} | firstArmy = {1} | secondArmy = {2} | ")
    @MethodSource("fightDataProvider_fights5")
    @DisplayName("fights between warriors, defenders, vampires, lancers, healers")
    void fights5(boolean expected, Army army1, Army army2) {
        assertEquals(expected, Battle.fight(army1, army2));
    }

    static Stream<Arguments> fightDataProvider_fights5() {
        return Stream.of(
                ///battle 17
                Arguments.of(true, new Army()
                                .addUnits(Lancer.class, 7)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Healer.class, 1)
                                .addUnits(Warrior.class, 4)
                                .addUnits(Healer.class, 1)
                                .addUnits(Defender.class, 2),
                        new Army().addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Healer.class, 1)
                                .addUnits(Vampire.class, 6)
                                .addUnits(Lancer.class, 4)),
               // battle 18
                Arguments.of(false, new Army()
                                .addUnits(Lancer.class, 1)
                                .addUnits(Warrior.class, 3)
                                .addUnits(Healer.class, 1)
                                .addUnits(Warrior.class, 4)
                                .addUnits(Healer.class, 1)
                                .addUnits(Knight.class, 2),
                        new Army().addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Healer.class, 1)
                                .addUnits(Vampire.class, 6)
                                .addUnits(Lancer.class, 4))
        );
    }


    @Test
    public void test() {
        Army army1 = new Army();
        Army army2 = new Army();
        army1.addUnits(Lancer.class, 1);

        army2.addUnits(Warrior.class, 1);
        army2.addUnits(Knight.class, 1);



    }

//
//    @Test
//    void battleTestArmyFightWithWarlordFirst() {
//        Army army_1 = new Army()
//                .addUnits("Warlord", 1)
//                .addUnits("Warrior", 2)
//                .addUnits("Lancer", 2)
//                .addUnits("Healer", 2)
//                .addUnits("Healer", 1);
//        Army army_2 = new Army()
//                .addUnits("Warlord", 1)
//                .addUnits("Vampire", 1)
//                .addUnits("Healer", 2)
//                .addUnits("Knight", 2);
//        army_1.moveUnits();
//        army_2.moveUnits();
//
//        var result = Battle.fight(army_1, army_2);
//
//        assertTrue(result);
//    }
//
//    @Test
//    void battleTestArmyFightWithWarlordSecond() {
//        Army army_1 = new Army()
//                .addUnits("Warrior", 2)
//                .addUnits("Lancer", 2)
//                .addUnits("Defender", 1)
//                .addUnits("Warlord", 3);
//        Army army_2 = new Army()
//                .addUnits("Warlord", 2)
//                .addUnits("Vampire", 1)
//                .addUnits("Healer", 5)
//                .addUnits("Knight", 2);
//
//        army_1.moveUnits();
//        army_2.moveUnits();
//
//        var result = Battle.fight(army_1, army_2);
//
//        assertFalse(result);
//    }
//
//    @Test
//    void battleTestArmyFightWithWarlordThird() {
//        Army army_1 = new Army()
//                .addUnits("Warrior", 2)
//                .addUnits("Lancer", 3)
//                .addUnits("Defender", 1)
//                .addUnits("Warlord", 4);
//
//        Army army_2 = new Army()
//                .addUnits("Warlord", 1)
//                .addUnits("Vampire", 1)
//                .addUnits("Rookie", 1)
//                .addUnits("Knight", 1);
//
//        army_1.getUnits().get(0).equipWeapon(Sword.getInstance());
//        army_2.getUnits().get(0).equipWeapon(Shield.getInstance());
//        army_1.moveUnits();
//        army_2.moveUnits();
//
//        var result = Battle.fight(army_1, army_2);
//
//        assertTrue(result);
//    }
//
//    @Test
//    void battleTestArmyFightWithWarlordForth() {
//        Army army_1 = new Army()
//                .addUnits("Warrior", 2)
//                .addUnits("Lancer", 3)
//                .addUnits("Defender", 1)
//                .addUnits("Warlord", 1);
//
//        Army army_2 = new Army()
//                .addUnits("Warlord", 5)
//                .addUnits("Vampire", 1)
//                .addUnits("Rookie", 1)
//                .addUnits("Knight", 1);
//
//        army_1.getUnits().get(0).equipWeapon(Sword.getInstance());
//        army_2.getUnits().get(0).equipWeapon(Shield.getInstance());
//        army_1.moveUnits();
//        army_2.moveUnits();
//
//        var result = Battle.straightFight(army_1, army_2);
//
//        assertFalse(result);
//    }

}
