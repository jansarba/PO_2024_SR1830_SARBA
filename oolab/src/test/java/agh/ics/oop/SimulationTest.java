package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest{

    @Test
    void animalHasCorrectOrientation(){
        List<MoveDirection> moves=List.of(MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.LEFT);
        List<Vector2d> positions=List.of(new Vector2d(2,2));
        RectangularMap map = new RectangularMap(10, 10);
        Simulation simulation = new Simulation(positions, moves, map);
        simulation.run();

        Animal animal=simulation.getAnimals().get(0);
        assertEquals(MapDirection.NORTH,animal.orientation); // Po ostatnim ruchu powinno zostać NORTH
    }

    @Test
    void animalMovesToCorrectPosition(){
        List<MoveDirection> moves=List.of(MoveDirection.FORWARD,MoveDirection.FORWARD);
        List<Vector2d> positions=List.of(new Vector2d(2,2));
        RectangularMap map = new RectangularMap(10, 10);
        Simulation simulation = new Simulation(positions, moves, map);
        simulation.run();

        Animal animal=simulation.getAnimals().get(0);
        assertEquals(new Vector2d(2,4),animal.position); // Po dwóch ruchach FORWARD z pozycji (2,2) zwierzę powinno być na (2,4)
    }

    @Test
    void inputStringIsCorrectlyParsed(){
        String[] input={"f","b","r","l"};
        List<MoveDirection> expected=List.of(MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT);
        List<MoveDirection> directions=OptionsParser.optionsParser(input);

        assertEquals(expected,directions);
    }
}