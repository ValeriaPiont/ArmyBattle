package com.game;

import com.game.units.Defender;
import com.game.units.Knight;
import com.game.units.Vampire;
import com.game.units.Warrior;
import com.game.units.Lancer;
import com.game.units.Healer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StraightFightTest {
    @ParameterizedTest(name = "[{index}] | expected = {0} | firstArmy = {1} | secondArmy = {2} | ")
    @MethodSource("fightDataProvider_straightFights_shouldReturnTrue")
    void straightFights_shouldReturnTrue(boolean expected, Army army1, Army army2) {
        assertEquals(expected, Battle.straightFight(army1, army2));
    }

    static Stream<Arguments> fightDataProvider_straightFights_shouldReturnTrue() {
        return Stream.of(
                //battle 20
                Arguments.of(true, new Army()
                                .addUnits(Lancer.class, 7)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 2),
                        new Army()
                                .addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Vampire.class, 6)
                                .addUnits(Lancer.class, 4)),
                //battle 22
                Arguments.of(true, new Army()
                                .addUnits(Lancer.class, 4)
                                .addUnits(Warrior.class, 3)
                                .addUnits(Healer.class, 1)
                                .addUnits(Warrior.class, 4)
                                .addUnits(Healer.class, 1)
                                .addUnits(Knight.class, 2),
                        new Army()
                                .addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Healer.class, 1)
                                .addUnits(Vampire.class, 2)
                                .addUnits(Lancer.class, 4))

        );
    }

    @ParameterizedTest(name = "[{index}] | expected = {0} | firstArmy = {1} | secondArmy = {2} | ")
    @MethodSource("fightDataProvider_straightFights_shouldReturnFalse")
    void straightFights_shouldReturnFalse(boolean expected, Army army1, Army army2) {
        assertEquals(expected, Battle.straightFight(army1, army2));
    }

    static Stream<Arguments> fightDataProvider_straightFights_shouldReturnFalse() {
        return Stream.of(
                //battle 21
                Arguments.of(false, new Army()
                                .addUnits(Lancer.class, 7)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Healer.class, 1)
                                .addUnits(Warrior.class, 4)
                                .addUnits(Healer.class, 1)
                                .addUnits(Defender.class, 2),
                        new Army()
                                .addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Healer.class, 1)
                                .addUnits(Vampire.class, 6)
                                .addUnits(Lancer.class, 4)),
                //battle 19
                Arguments.of(false, new Army()
                                .addUnits(Lancer.class, 5)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 2),
                        new Army()
                                .addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Vampire.class, 6)
                                .addUnits(Lancer.class, 5))

        );
    }
}
