package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.MoveValidator;

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
            Animal animal = new Animal(position,tmp);
            animals.add(animal);
            tmp++;
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void run(MoveValidator validator){
        int tmp=0;
        for (MoveDirection move : moves) {
            Animal curr = animals.get(tmp% animals.size());
            curr.move(move,validator);
            System.out.println(curr);
            tmp++;
        }
    }
}
