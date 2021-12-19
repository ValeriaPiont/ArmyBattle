package com.game;


import com.game.units.Defender;
import com.game.units.Knight;
import com.game.units.Vampire;
import com.game.units.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    public static class Rookie extends Warrior {
        private static int attack = 1;

        public int getAttack() {
            return attack;
        }
    }

    @Test
    void test1() {
        //arrange
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();

        //act
        var res1 = Battle.fight(chuck, bruce);
        var res2 = Battle.fight(dave, carl);

        //assert
        assertTrue(res1);
        assertFalse(res2);
    }

    @Test
    void test2() {
        //arrange
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();

        //act
        Battle.fight(chuck, bruce);
        Battle.fight(dave, carl);

        //assert
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
    }

    @Test
    @DisplayName("Warrior&Knight")
    void fight1() {
        var chuck = new Warrior();
        var jim = new Knight();

        assertFalse(Battle.fight(chuck, jim));
    }

    @Test
    @DisplayName("Knight&Warrior")
    void fight2() {
        var ramon = new Knight();
        var slevin = new Warrior();

        assertTrue(Battle.fight(ramon, slevin));
    }

    @Test
    @DisplayName("Warrior&Warrior")
    void fight3() {
        var bob = new Warrior();
        var mars = new Warrior();

        assertTrue(Battle.fight(bob, mars));
    }


    @Test
    @DisplayName("Knight&Knight")
    void fight4() {
        var dragon = new Knight();
        var knight = new Knight();

        assertTrue(Battle.fight(dragon, knight));
    }

    @Test
    @DisplayName("Warrior&Defender")
    void fight5() {
        var warrior = new Warrior();
        var defender = new Defender();

        assertTrue(Battle.fight(defender, warrior));
    }


    @Test
    @DisplayName("RookieTest")
    void fight6() {
        var defender = new Defender();
        var rookie = new Rookie();

        Battle.fight(defender, rookie);
        System.out.println(defender.getHealth());

        assertEquals(defender.getHealth(), 60);
    }

    @Test
    public void checkVampire(){
        var defender = new Defender();
        var vampire = new Vampire();

        assertTrue(Battle.fight(defender, vampire));

    }


    //parametrized test
    @ParameterizedTest(name = "[{index}] firstType = {0} | secondType = {1} | expected = {2} ")
    @MethodSource("fightsDataProvider")
    void fights(boolean expected, Warrior warrior1, Warrior warrior2) {
        assertEquals(expected, Battle.fight(warrior1, warrior2));
    }

    static Stream<Arguments> fightsDataProvider() {
        return Stream.of(
                Arguments.of(true, new Warrior(), new Warrior()),
                Arguments.of(false, new Warrior(),  new Knight()),
                Arguments.of(true, new Knight(),  new Knight()),
                Arguments.of(true, new Knight(),  new Warrior())
        );
    }


}
