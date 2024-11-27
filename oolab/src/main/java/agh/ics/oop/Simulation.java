package agh.ics.oop;

import agh.ics.oop.exceptions.IncorrectPositionException;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals;
    private final List<MoveDirection> moves;
    private final AbstractWorldMap map; //validator

    public Simulation(List<Vector2d> starting_positions, List<MoveDirection> moves, AbstractWorldMap map) {
        this.animals = new ArrayList<>();
        this.moves = moves;
        this.map = map;
        int tmp = 0;
        for (Vector2d position : starting_positions) {
            Animal animal = new Animal(position,tmp);
            animals.add(animal);
            tmp++;
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void run() throws IncorrectPositionException{
        int tmp=0;
        for (MoveDirection move : moves) {
            Animal curr = animals.get(tmp % animals.size());
            try {
                map.move(curr, move);
            } catch (IncorrectPositionException e) {
                System.out.println("Invalid move skipped: " + e.getMessage() + "\n");
            }
            tmp++;
        }
    }
}
