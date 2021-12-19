package com.game;

import com.game.units.Warrior;

import java.util.List;

public class Battle {
    public static boolean fight(Warrior warrior1, Warrior warrior2) {

        if (warrior1.isAlive()) {
            warrior1.attack(warrior2);
        } else {
            return false;
        }

        if (warrior2.isAlive()) {
            warrior2.attack(warrior1);
        } else {
            return true;
        }

        return fight(warrior1, warrior2);
    }

    public static boolean fight(Army army1, Army army2) {
        int army1Alive = army1.getAliveAmount();
        int army2Alive = army2.getAliveAmount();
        boolean isWarlordInArmy1 = army1.isWarlordInArmy();
        boolean isWarlordInArmy2 = army2.isWarlordInArmy();
        while (true) {
            if (isWarlordInArmy1 && army1.getAliveAmount() != army1Alive) {
                army1.moveUnits();
                //реорганизация армии
                army1.armyToLine();
                army1.armyToColumn();
                //изменение размера
                army1Alive = army1.getAliveAmount();
            }
            if (isWarlordInArmy2 && army2.getAliveAmount() != army2Alive) {
                army2.moveUnits();
                //реорганизация армии
                army2.armyToLine();
                army2.armyToColumn();
                //изменение размера
                army2Alive = army2.getAliveAmount();
            }
            var warrior1 = army1.getFirstAlive();

            if (warrior1.isEmpty()) {
                return false;
            }

            var warrior2 = army2.getFirstAlive();

            if (warrior2.isEmpty()) {
                return true;
            }
            fight(warrior1.get(), warrior2.get());
        }
    }

    public static boolean straightFight(Army army1, Army army2) {

        army1.armyToLine();
        army2.armyToLine();

        int army1Alive = army1.getAliveAmount();
        int army2Alive = army2.getAliveAmount();
        boolean isWarlordInArmy1 = army1.isWarlordInArmy();
        boolean isWarlordInArmy2 = army2.isWarlordInArmy();

        List<Warrior> aliveUnits1;
        List<Warrior> aliveUnits2;

        while (true) {

            if (army1.getFirstAlive().isEmpty()) {
                army2.armyToColumn();
                return false;
            }

            if (army2.getFirstAlive().isEmpty()) {
                army1.armyToColumn();
                return true;
            }

            aliveUnits1 = army1.getAliveUnits();
            aliveUnits2 = army2.getAliveUnits();

            for (int i = 0; i < Math.min(aliveUnits1.size(), aliveUnits2.size()); i++) {
                fight(aliveUnits1.get(i), aliveUnits2.get(i));
                if (isWarlordInArmy1 && army1.getAliveAmount() != army1Alive) {
                    army1.moveUnits();
                    army1Alive = army1.getAliveAmount();
                }
                if (isWarlordInArmy2 && army2.getAliveAmount() != army2Alive) {
                    army2.moveUnits();
                    army2Alive = army2.getAliveAmount();
                }
            }

        }
    }
}