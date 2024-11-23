package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class World {
    public static void main(String[] args) {
        List<MoveDirection> moves = OptionsParser.optionsParser(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        AbstractWorldMap map = new GrassField(10);
        Simulation simulation = new Simulation(positions, moves, map);
        simulation.run();
    }
}
