package com.game;

import com.game.units.Defender;
import com.game.units.Knight;
import com.game.units.Warrior;

public class Main {
    public static void main(String[] args) {
        var army1 = new Army().addUnits(Knight.class, 20)
                .addUnits(Warrior.class, 5);

        var army2 = new Army().addUnits(Knight.class, 30);

        System.out.println(Battle.fight(army1, army2));

        Warrior warrior = new Warrior();
        System.out.println(warrior.getHealth());

        Defender defender = new Defender();
        System.out.println(defender.getHealth());

        Warrior warrior1 = new Warrior();
        Defender defender1 = new Defender();

        System.out.println(defender1.getHealth());
        System.out.println(warrior1.getHealth());

        System.out.println(Battle.fight(warrior1, defender1));


        System.out.println(warrior1.isAlive());
        System.out.println(defender1.isAlive());

    }


}
