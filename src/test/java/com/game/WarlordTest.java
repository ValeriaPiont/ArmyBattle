package com.game;

import com.game.units.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class WarlordTest {

    @Test
    //тест 23
    public void test2() {
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
        System.out.println(army1);
        army2.moveUnits();
        System.out.println(army2);

        assertTrue(Battle.fight(army1, army2));

    }

    @ParameterizedTest(name = "[{index}] | expected = {0} | firstArmy = {1} | secondArmy = {2} | ")
    @MethodSource("fightDataProvider_warlordTest1")
    @DisplayName("хзхзхзхзхзхз")
    void fights1(boolean expected, Army army1, Army army2) {
        army1.moveUnits();
        army2.moveUnits();
        assertEquals(expected, Battle.fight(army1, army2));
    }

    static Stream<Arguments> fightDataProvider_warlordTest1() {
        return Stream.of(
                //тест 24
                Arguments.of(false, new Army()
                                .addUnits(Warrior.class, 2)
                                .addUnits(Lancer.class, 2)
                                .addUnits(Defender.class, 1)
                                .addUnits(Warlord.class, 3),
                        new Army()
                                .addUnits(Warlord.class, 2)
                                .addUnits(Vampire.class, 1)
                                .addUnits(Healer.class, 5)
                                .addUnits(Knight.class, 2))
//                //тест 25 - не тот
//                Arguments.of(true, new Army()
//                                .addUnits(Warrior.class, 2)
//                                .addUnits(Lancer.class, 3)
//                                .addUnits(Defender.class, 1)
//                                .addUnits(Warlord.class, 1),
//                        new Army()
//                                .addUnits(Warlord.class, 1)
//                                .addUnits(Vampire.class, 1)
//                                .addUnits(Rookie.class, 1)
//                                .addUnits(Knight.class, 1))

        );
    }

}
