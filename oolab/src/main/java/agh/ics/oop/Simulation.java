package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals;
    private final List<MoveDirection> moves;
    public Simulation(List<Vector2d> starting_positions, List<MoveDirection> moves) {
        this.animals=new ArrayList<>();
        this.moves=moves;
        int tmp=0;
        for (Vector2d position : starting_positions) {
            Animal animal = new Animal(MapDirection.NORTH,position,tmp); //nie wiem jak obsluzyc to zeby automatycznie dawalo im north jesli nie podano kierunku: null sprawia ze default constructor nie podmienia tego na north, a jak nic nie przekaze to sie nie kompiluje...?
            animals.add(animal);
            tmp++;
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void run(){
        int tmp=0;
        for (MoveDirection move : moves) {
            Animal curr = animals.get(tmp% animals.size());
            curr.move(move);
            System.out.println(curr);
            tmp++;
        }
    }
}
