package com.game;

import com.game.units.Defender;
import com.game.units.Knight;
import com.game.units.Vampire;
import com.game.units.Warrior;
import com.game.units.Rookie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BattleTest {

    @Test
    @DisplayName("Warrior&Knight")
    void fight1_shouldReturnFalse() {
        var chuck = new Warrior();
        var jim = new Knight();

        assertFalse(Battle.fight(chuck, jim));
    }

    @Test
    @DisplayName("Knight&Warrior")
    void fight2_shouldReturnTrue() {
        var ramon = new Knight();
        var slevin = new Warrior();

        assertTrue(Battle.fight(ramon, slevin));
    }

    @Test
    @DisplayName("Warrior&Warrior")
    void fight3_shouldReturnTrue() {
        var bob = new Warrior();
        var mars = new Warrior();

        assertTrue(Battle.fight(bob, mars));
    }


    @Test
    @DisplayName("Knight&Knight")
    void fight4_shouldReturnTrue() {
        var dragon = new Knight();
        var knight = new Knight();

        assertTrue(Battle.fight(dragon, knight));
    }

    @Test
    @DisplayName("Warrior&Defender")
    void fight5_shouldReturnTrue() {
        var warrior = new Warrior();
        var defender = new Defender();

        assertTrue(Battle.fight(defender, warrior));
    }


    @Test
    @DisplayName("Defender&Rookie")
    void fight6_RookieHealthShouldBeSixty() {
        var defender = new Defender();
        var rookie = new Rookie();

        Battle.fight(defender, rookie);
        int expectedHealth = 60;

        assertEquals(defender.getHealth(), expectedHealth);
    }

    @Test
    @DisplayName("Vampire&Rookie")
     void fight6_shouldReturnTrue(){
        var defender = new Defender();
        var vampire = new Vampire();

        assertTrue(Battle.fight(defender, vampire));

    }

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
