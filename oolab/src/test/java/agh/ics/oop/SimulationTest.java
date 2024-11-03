package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest{

    @Test
    void animalHasCorrectOrientation(){
        List<MoveDirection> moves=List.of(MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.LEFT);
        List<Vector2d> positions=List.of(new Vector2d(2,2));
        Simulation simulation=new Simulation(positions,moves);
        simulation.run();

        Animal animal=simulation.getAnimals().get(0);
        assertEquals(MapDirection.NORTH,animal.orientation); // Po ostatnim ruchu powinno zostać NORTH
    }

    @Test
    void animalMovesToCorrectPosition(){
        List<MoveDirection> moves=List.of(MoveDirection.FORWARD,MoveDirection.FORWARD);
        List<Vector2d> positions=List.of(new Vector2d(2,2));
        Simulation simulation=new Simulation(positions,moves);
        simulation.run();

        Animal animal=simulation.getAnimals().get(0);
        assertEquals(new Vector2d(2,4),animal.position); // Po dwóch ruchach FORWARD z pozycji (2,2) zwierzę powinno być na (2,4)
    }

    @Test
    void animalStaysInsideMap(){
        List<MoveDirection> moves=List.of(MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD);
        List<Vector2d> positions=List.of(new Vector2d(2,MapDirection.UPPER_RIGHT_BOUNDARY.getXY()[1] - 1));
        Simulation simulation=new Simulation(positions,moves);
        simulation.run();

        Animal animal=simulation.getAnimals().get(0);
        // Sprawdzenie, czy zwierzę pozostaje w granicach mapy
        assertTrue(animal.isInside(animal.position));
        assertEquals(new Vector2d(2,MapDirection.UPPER_RIGHT_BOUNDARY.getXY()[1]),animal.position); // Zwierzę nie powinno wyjść poza górną granicę
    }

    @Test
    void inputStringIsCorrectlyParsed(){
        String[] input={"f","b","r","l"};
        List<MoveDirection> expected=List.of(MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT);
        List<MoveDirection> directions=OptionsParser.optionsParser(input);

        assertEquals(expected,directions);
    }
}