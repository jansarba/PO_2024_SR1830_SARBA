package agh.ics.oop;

import agh.ics.oop.exceptions.IncorrectPositionException;
import agh.ics.oop.exceptions.IllegalArgumentException;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) throws IncorrectPositionException {
        List<MoveDirection> moves = OptionsParser.optionsParser(args);
        try {
            moves = OptionsParser.optionsParser(args);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(2,4));
        AbstractWorldMap map1 = new GrassField(10);
        AbstractWorldMap map2 = new RectangularMap(5,5);
        ConsoleMapDisplay obs1 = new ConsoleMapDisplay();
        map1.addObserver(obs1);
        map2.addObserver(obs1);
        List<Vector2d> validPositions= new ArrayList<>();
        for (Vector2d position : positions) {
            try {
                Animal animal = new Animal(position, validPositions.size());
                map1.place(animal);
                map2.place(animal);
                validPositions.add(animal.getPosition());
            } catch (IncorrectPositionException e) {
                System.out.println("Warning: " + e.getMessage());
            }
        }
        Simulation simulation1 = new Simulation(validPositions, moves, map1);
        Simulation simulation2 = new Simulation(validPositions, moves, map2);
        List<Simulation> simulations = List.of(simulation1, simulation2);
        SimulationEngine engine = new SimulationEngine(simulations);
        engine.runAsync();
    }
//        List<Simulation> simulations = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) { // Tworzymy dużą liczbę symulacji
//            AbstractWorldMap map = new GrassField(10);
//            ConsoleMapDisplay obs = new ConsoleMapDisplay();
//            map.addObserver(obs);
//            List<Vector2d> validPositions = new ArrayList<>();
//            try {
//                Animal animal = new Animal(new Vector2d(2, 2), validPositions.size());
//                map.place(animal);
//                validPositions.add(animal.getPosition());
//            } catch (IncorrectPositionException e) {
//                System.out.println("Warning: " + e.getMessage());
//            }
//            simulations.add(new Simulation(validPositions, moves, map));
//        }
//        SimulationEngine engine = new SimulationEngine(simulations);
//        engine.runSync();
//    }
}