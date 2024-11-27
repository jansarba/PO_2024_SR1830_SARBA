package agh.ics.oop.model;

import agh.ics.oop.exceptions.IncorrectPositionException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void testIfMapWorks() throws IncorrectPositionException {
        // Given
        WorldMap map = new GrassField(10);
        Animal animal = new Animal();

        // When
        map.place(animal);
        map.move(animal, MoveDirection.FORWARD);

        // Then
        assertEquals(new Vector2d(2, 3), animal.getPosition(), "Animal's new position should be (2, 3) after moving forward.");
    }

    @Test
    public void testCanMoveTo1() throws IncorrectPositionException {
        // Given
        WorldMap map = new GrassField(10);
        Animal animal = new Animal();

        // When
        map.place(animal);

        // Then
        assertTrue(map.canMoveTo(new Vector2d(2, 3)), "Position (2, 3) should be free.");
        assertFalse(map.canMoveTo(new Vector2d(2, 2)), "Position (2, 2) should be occupied by the animal.");
    }

    @Test
    public void testCanMoveTo2() throws IncorrectPositionException {
        // Given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 3));

        // When
        map.place(animal1);
        map.place(animal2);

        // Then
        assertFalse(map.canMoveTo(new Vector2d(2, 3)), "Position (2, 3) should be occupied by animal 2.");
    }

    @Test
    public void testPlace() {
        // Given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 2));

        // When
        assertDoesNotThrow(() -> map.place(animal1), "Animal 1 should be placed successfully.");
        IncorrectPositionException exception = assertThrows(
                IncorrectPositionException.class,
                () -> map.place(animal2),
                "Placing animal 2 should throw IncorrectPositionException as position is occupied."
        );

        // Then
        assertEquals("Position is incorrect (2,2)", exception.getMessage());
    }

    @Test
    public void testMove() throws IncorrectPositionException {
        // Given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(3, 2));

        // When
        map.place(animal1);
        map.place(animal2);
        map.move(animal1, MoveDirection.FORWARD);
        map.move(animal2, MoveDirection.FORWARD);

        // Then
        assertEquals(new Vector2d(2, 3), animal1.getPosition(), "Animal 1 should be at (2, 3) after moving forward.");
        assertEquals(new Vector2d(3, 1), animal2.getPosition(), "Animal 2 should be at (3, 1) after moving forward.");
    }

    @Test
    public void testIsOccupied() throws IncorrectPositionException {
        // Given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 2));

        // When
        map.place(animal1);

        // Then
        IncorrectPositionException exception = assertThrows(
                IncorrectPositionException.class,
                () -> map.place(animal2),
                "Placing animal 2 should throw IncorrectPositionException as position is occupied."
        );
        assertEquals("Position is incorrect (2,2)", exception.getMessage());
        assertTrue(map.isOccupied(new Vector2d(2, 2)), "Position (2, 2) should be occupied.");
    }

    @Test
    public void testIsOccupiedPass() throws IncorrectPositionException {
        // Given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 3));

        // When
        map.place(animal1);
        map.place(animal2);

        // Then
        assertFalse(map.isOccupied(new Vector2d(2, 4)), "Position (2, 4) should not be occupied.");
    }

    @Test
    public void testObjectAt() throws IncorrectPositionException {
        // Given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 3));

        // When
        map.place(animal1);
        map.place(animal2);

        // Then
        assertEquals(animal1, map.objectAt(new Vector2d(2, 2)), "Position (2, 2) should have animal1.");
    }

    @Test
    public void testGetElements() throws IncorrectPositionException {
        // Given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 3));

        // When
        map.place(animal1);
        map.place(animal2);

        // Then
        assertEquals(12, map.getElements().size(), "Map should contain 12 elements.");
    }
}