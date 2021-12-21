package com.game;

import com.game.units.Healer;
import com.game.units.Lancer;
import com.game.units.Warlord;
import com.game.units.Warrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Army {
    private List<Warrior> units = new ArrayList<>();

    Army addUnits(Class<? extends Warrior> warriorType, int count) {
        String name = warriorType.getSimpleName();
        int end;

        if (name.equals("Warlord")) {
            if (isWarlordInArmy()) {
                return this;
            } else {
                count = 1;
            }
        }
        end = units.size() + count;

        for (int i = units.size(); i < end; i++) {
            units.add(Warrior.of(name));
            if (units.size() > 1) {
                units.get(i - 1).setBehindWarrior(units.get(i));
            }
        }
        return this;
    }

    public Warrior getUnit(int index) {
        if (index < 0 || index >= units.size()) {
            throw new IndexOutOfBoundsException("Index is out of bound units array");
        }
        return units.get(index);
    }

    public Optional<Warrior> getFirstAlive() {
        return units.stream().filter(Warrior::isAlive).findFirst();
    }

    public List<Warrior> getAliveUnits() {
        return units.stream().filter(Warrior::isAlive).collect(Collectors.toList());
    }

    public int getAliveAmount() {
        return getAliveUnits().size();
    }

    public void armyToLine() {
        for (Warrior warrior : units) {
            warrior.setBehindWarrior(null);
        }
    }

    public void armyToColumn() {
        for (int i = 0; i < getAliveAmount(); i++) {
            if (i > 0) {
                getAliveUnits().get(i - 1).setBehindWarrior(getAliveUnits().get(i));
            }
        }
    }

    public boolean isWarlordInArmy() {
        return units.stream().anyMatch(Warlord.class::isInstance);
    }

    public Stream<Warrior> lancers() {
        return units.stream().filter(warrior -> warrior instanceof Lancer && warrior.isAlive());
    }

    public Stream<Warrior> healers() {
        return units.stream().filter(warrior -> warrior instanceof Healer && warrior.isAlive());
    }

    public Stream<Warrior> warlords() {
        return units.stream().filter(warrior -> warrior instanceof Warlord && warrior.isAlive());
    }

    public Stream<Warrior> otherUnits() {
        return units.stream().filter(warrior -> !(warrior instanceof Healer) &&
                !(warrior instanceof Warlord) &&
                !(warrior instanceof Lancer) &&
                warrior.isAlive());
    }

    public void moveUnits() {
        if (isWarlordInArmy()) {
            List<Warrior> warriors = new ArrayList<>();

            List<Warrior> lancersAndOther = new ArrayList<>();
            lancersAndOther.addAll(lancers().collect(Collectors.toList()));
            lancersAndOther.addAll(otherUnits().collect(Collectors.toList()));

            if (!lancersAndOther.isEmpty()) {
                warriors.add(lancersAndOther.get(0));
            }
            warriors.addAll(healers().collect(Collectors.toList()));

            if (!lancersAndOther.isEmpty()) {
                warriors.addAll(lancersAndOther.subList(1, lancersAndOther.size()));
            }

            warriors.addAll(warlords().collect(Collectors.toList()));
            units = warriors;
        }
    }

    @Override
    public String toString() {
        return "Army{" +
                "units=" + units +
                '}';
    }

}

