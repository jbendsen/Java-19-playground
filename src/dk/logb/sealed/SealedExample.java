package dk.logb.sealed;

import java.util.ArrayList;
import java.util.List;

public class SealedExample {
    //examples showing uses of sealed classes

    public static void main(String[] args) {
        Person aragorn = new Person();
        aragorn.getPossessions().add(new Horse());
        aragorn.getPossessions().add(new Sword());
        aragorn.getPossessions().add(new Land());
    }

    static Ownable getFavoritePossession(Person p) {
        List<Ownable> possessions = p.getPossessions();
        return null;
    }
}

class Person {
    List<Ownable> possessions = new ArrayList<>();

    public List<Ownable> getPossessions() {
        return possessions;
    }
}

final class Slave extends Person implements Sellable {

    @Override
    public Person getOwner() {
        return null;
    }
}

sealed interface Ownable
        permits Sellable, Stone, Worm
{
    Person getOwner();
}

sealed interface Sellable extends Ownable
    permits  Horse, Sword, Land, Slave
{
    default int getPrice() {
        return 0;
    }
}

final class Horse extends Animal implements  Sellable {
    @Override
    public Person getOwner() {
        return null;
    }
}

final class Sword extends Item implements Sellable {
    @Override
    public Person getOwner() {
        return null;
    }
}

final class Land implements Sellable {
    @Override
    public Person getOwner() {
        return null;
    }
}

final class Worm extends Animal implements Ownable {
    @Override
    public Person getOwner() {
        return null;
    }
}

final class Stone extends Item implements Ownable {
    @Override
    public Person getOwner() {
        return null;
    }
}

sealed class Animal
    permits Horse, Worm {
    int maxSpeed = 0;

    public int getMaxSpeed() {
        return maxSpeed;
    }
}

sealed class Item
        permits Stone, Sword {
    int weight = 0;

    public int getWeight() {
        return weight;
    }
}
