package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {

    @Test
    public void testNext() {
        // Given
        MapDirection north = MapDirection.NORTH;
        MapDirection east = MapDirection.EAST;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;

        // When & Then
        assertEquals(MapDirection.EAST, north.next(), "Next of NORTH should be EAST");
        assertEquals(MapDirection.SOUTH, east.next(), "Next of EAST should be SOUTH");
        assertEquals(MapDirection.WEST, south.next(), "Next of SOUTH should be WEST");
        assertEquals(MapDirection.NORTH, west.next(), "Next of WEST should be NORTH");
    }

    @Test
    public void testPrevious() {
        // Given
        MapDirection north = MapDirection.NORTH;
        MapDirection east = MapDirection.EAST;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;

        // When & Then
        assertEquals(MapDirection.WEST, north.previous(), "Previous of NORTH should be WEST");
        assertEquals(MapDirection.NORTH, east.previous(), "Previous of EAST should be NORTH");
        assertEquals(MapDirection.EAST, south.previous(), "Previous of SOUTH should be EAST");
        assertEquals(MapDirection.SOUTH, west.previous(), "Previous of WEST should be SOUTH");
    }

    @Test
    public void testToUnitVector() {
        // Given & When & Then
        assertEquals(new Vector2d(0, 1), MapDirection.NORTH.toUnitVector(), "Unit vector of NORTH should be (0, 1)");
        assertEquals(new Vector2d(1, 0), MapDirection.EAST.toUnitVector(), "Unit vector of EAST should be (1, 0)");
        assertEquals(new Vector2d(0, -1), MapDirection.SOUTH.toUnitVector(), "Unit vector of SOUTH should be (0, -1)");
        assertEquals(new Vector2d(-1, 0), MapDirection.WEST.toUnitVector(), "Unit vector of WEST should be (-1, 0)");
    }
}