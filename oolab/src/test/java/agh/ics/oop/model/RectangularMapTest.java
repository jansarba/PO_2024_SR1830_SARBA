package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void testIfMapWorks() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal = new Animal();

        // When
        assertTrue(map.place(animal), "Animal should be placed successfully.");
        map.move(animal, MoveDirection.FORWARD);

        // Then
        assertEquals(new Vector2d(2, 3), animal.getPosition(), "Animal should be at position (2, 3) after moving forward.");
    }

    @Test
    public void testCanMoveTo1() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();

        // When
        assertTrue(map.place(animal1), "Animal should be placed successfully.");

        // Then
        assertTrue(map.canMoveTo(new Vector2d(2, 3)), "Position (2, 3) should be free.");
        assertFalse(map.canMoveTo(new Vector2d(2, 2)), "Position (2, 2) should be occupied by the animal.");
    }

    @Test
    public void testCanMoveTo2() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 3));

        // When
        assertTrue(map.place(animal1), "Animal 1 should be placed successfully.");
        assertTrue(map.place(animal2), "Animal 2 should be placed successfully.");

        // Then
        assertFalse(map.canMoveTo(new Vector2d(2, 3)), "Position (2, 3) should be occupied by animal 2.");
    }

    @Test
    public void testPlace() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 2));

        // When
        assertTrue(map.place(animal1), "Animal 1 should be placed successfully.");

        // Then
        assertFalse(map.place(animal2), "Placing animal 2 should fail as position is occupied.");
    }

    @Test
    public void testMove() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(3, 2));

        // When
        assertTrue(map.place(animal1), "Animal 1 should be placed successfully.");
        assertTrue(map.place(animal2), "Animal 2 should be placed successfully.");
        map.move(animal1, MoveDirection.FORWARD);
        map.move(animal2, MoveDirection.FORWARD);

        // Then
        assertEquals(new Vector2d(2, 3), animal1.getPosition(), "Animal 1 should be at (2, 3) after moving forward.");
        assertEquals(new Vector2d(3, 1), animal2.getPosition(), "Animal 2 should be at (3, 1) after moving forward.");
    }

    @Test
    public void testIsOccupied() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 2));

        // When
        assertTrue(map.place(animal1), "Animal 1 should be placed successfully.");

        // Then
        assertFalse(map.place(animal2), "Placing animal 2 should fail as position is occupied.");
        assertTrue(map.isOccupied(new Vector2d(2, 2)), "Position (2, 2) should be occupied.");
        assertFalse(map.isOccupied(new Vector2d(2, 3)), "Position (2, 3) should be free.");
    }

    @Test
    public void testObjectAt() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 3));

        // When
        assertTrue(map.place(animal1), "Animal 1 should be placed successfully.");
        assertTrue(map.place(animal2), "Animal 2 should be placed successfully.");

        // Then
        assertEquals(animal1, map.objectAt(new Vector2d(2, 2)), "Position (2, 2) should have animal1.");
        assertEquals(animal2, map.objectAt(new Vector2d(2, 3)), "Position (2, 3) should have animal2.");
    }

    @Test
    public void testGetElements() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 3));

        // When
        assertTrue(map.place(animal1), "Animal 1 should be placed successfully.");
        assertTrue(map.place(animal2), "Animal 2 should be placed successfully.");

        // Then
        assertEquals(2, map.getElements().size(), "Map should contain 2 elements.");
    }
}
