package com.game;

import com.game.units.Knight;
import com.game.units.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WarriorTest {

    @Test
    void bobIsAliveShouldBeTrue() {
        var bob = new Warrior();
        var mars = new Warrior();

        Battle.fight(bob, mars);

        assertTrue(bob.isAlive());
    }

    @Test
    void zeusIsAliveShouldBeTrue() {
        var zeus = new Knight();
        var godkiller = new Warrior();

        Battle.fight(zeus, godkiller);

        assertTrue(zeus.isAlive());
    }

    @Test
    void wifeIsAliveShouldBeFalse() {
        var husband = new Warrior();
        var wife = new Warrior();

        Battle.fight(husband, wife);
        assertFalse(wife.isAlive());

    }


    @Test
    void knightIsAliveShouldBeFalse() {
        var dragon = new Warrior();
        var knight = new Knight();

        Battle.fight(dragon, knight);

        assertTrue(knight.isAlive());
    }



}