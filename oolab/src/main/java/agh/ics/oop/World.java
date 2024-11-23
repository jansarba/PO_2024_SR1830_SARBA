package agh.ics.oop;

import agh.ics.oop.exceptions.IncorrectPositionException;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) throws IncorrectPositionException{
        List<MoveDirection> moves = OptionsParser.optionsParser(args);
        try {
            moves = OptionsParser.optionsParser(args);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        AbstractWorldMap map = new GrassField(10);
        List<Vector2d> validPositions= new ArrayList<>();
        for (Vector2d position : positions) {
            try {
                Animal animal = new Animal(position, validPositions.size());
                map.place(animal);
                validPositions.add(animal.getPosition());
            } catch (IncorrectPositionException e) {
                System.out.println("Warning: " + e.getMessage());
            }
        }
        Simulation simulation = new Simulation(validPositions, moves, map);
        simulation.run();
    }
}
