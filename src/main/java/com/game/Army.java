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
        final int end;

        if(name.equals("Warlord")){
            if(isWarlordInArmy()){
                return this;
            }else{
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


//
//    public List<Warrior> moveUnitsIn(List<Warrior> units) {
//
//        List<Warrior> lancers = units.stream().filter(Lancer.class::isInstance)
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        List<Warrior> healers = units.stream().filter(Healer.class::isInstance)
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        List<Warrior> warriors = units.stream().filter(unit ->
//                        unit != null
//                                && !(unit instanceof Lancer)
//                                && !(unit instanceof Healer)
//                                && !(unit instanceof Warlord))
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        List<Warrior> warlords = units.stream().filter(Warlord.class::isInstance)
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        List<Warrior> unitsCopy = new ArrayList<>();
//        if (!lancers.isEmpty()) {
//            unitsCopy.add(lancers.get(0));
//            lancers.remove(0);
//
//            unitsCopy.addAll(healers);
//            unitsCopy.addAll(lancers);
//        } else {
//            if (!warriors.isEmpty()) {
//                unitsCopy.add(warriors.get(0));
//                warriors.remove(0);
//            }
//
//            unitsCopy.addAll(healers);
//        }
//        unitsCopy.addAll(warriors);
//        unitsCopy.addAll(warlords);
//
//        return unitsCopy;
//
//    }

    public Warrior getUnit(int index) {
        if (index < 0 || index >= units.size()) {
            throw new IndexOutOfBoundsException("Index is out of bound units array");
        }
        return units.get(index);
    }


    public Optional<Warrior> getFirstWarrior() {
        return units.stream().filter(Warrior::isAlive).findFirst();
    }

    //TODO rename getAliveUnits
    public List<Warrior> getAliveUnits() {
        return units.stream().filter(Warrior::isAlive).collect(Collectors.toList());
    }

    public int getArmySize() {
        //return units.stream().filter(Warrior::isAlive).collect(Collectors.toList()).size();
        return getAliveUnits().size();
    }

    public void lineUp() {
        for (Warrior warrior : units) {
            warrior.setBehindWarrior(null);
        }
    }

    public void reorganizeArmyIntoColumn() {
        for (int i = 0; i < getArmySize(); i++) {
            if (getFirstWarrior().isPresent() && i > 0) {
                getAliveUnits().get(i - 1).setBehindWarrior(getAliveUnits().get(i));
            }
        }
    }

    public boolean isWarlordInArmy() {
        return units.stream().anyMatch(warrior -> warrior instanceof Warlord);
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
//       if (isWarlordExists()) {
////            //this.units = moveUnitsIn(getUnits());
//            moveUnitsIn();
//        }

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





   //TODO delete
    Army addUnits(String warriorType, int count) {
        int q;
        q = units.size() + count;
        for (int i = units.size(); i < q; i++) {
            units.add(Warrior.of(warriorType));
            if (units.size() > 1) {
                units.get(i - 1).setBehindWarrior(units.get(i));
            }
        }
        return this;
    }

}

//
//    private Warlord warlord = null;
//
//    private boolean isWarlordExists() {
//        boolean isWarlordExists = false;
//        List<Warrior> listToRemove = new ArrayList<>();
//        for (Warrior unit : units) {
//            if (unit instanceof Warlord w) {
//                if (!isWarlordExists) {
//                    this.warlord = w;
//                    isWarlordExists = true;
//                }else {
//                    listToRemove.add(unit);
//                }
//            }
//        }
//        this.units.removeAll(listToRemove);
//        return isWarlordExists;
//    }
