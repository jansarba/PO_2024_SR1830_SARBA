package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void testPrecedes() {
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        assertTrue(v1.precedes(v2));
        assertFalse(v2.precedes(v1));
    }
    //przyznam sie, ze generowal chat - to jest koszmarnie zmudna robota
    @Test
    public void testFollows() {
        // Given
        Vector2d v1 = new Vector2d(1, 1);
        Vector2d v2 = new Vector2d(2, 2);

        // When & Then
        assertTrue(v2.follows(v1), "Vector (2,2) should follow (1,1)");
        assertFalse(v1.follows(v2), "Vector (1,1) should not follow (2,2)");
    }

    @Test
    public void testAdd() {
        // Given
        Vector2d v1 = new Vector2d(1, 1);
        Vector2d v2 = new Vector2d(2, 2);

        // When & Then
        assertEquals(new Vector2d(3, 3), v1.add(v2), "Adding (1,1) and (2,2) should result in (3,3)");
    }

    @Test
    public void testSubtract() {
        // Given
        Vector2d v1 = new Vector2d(2, 2);
        Vector2d v2 = new Vector2d(1, 1);

        // When & Then
        assertEquals(new Vector2d(1, 1), v1.subtract(v2), "Subtracting (1,1) from (2,2) should result in (1,1)");
    }

    @Test
    public void testUpperRight() {
        // Given
        Vector2d v1 = new Vector2d(1, 1);
        Vector2d v2 = new Vector2d(2, 3);

        // When & Then
        assertEquals(new Vector2d(2, 3), v1.upperRight(v2), "Upper right of (1,1) and (2,3) should be (2,3)");
    }

    @Test
    public void testLowerLeft() {
        // Given
        Vector2d v1 = new Vector2d(1, 1);
        Vector2d v2 = new Vector2d(2, 3);

        // When & Then
        assertEquals(new Vector2d(1, 1), v1.lowerLeft(v2), "Lower left of (1,1) and (2,3) should be (1,1)");
    }

    @Test
    public void testOpposite() {
        // Given
        Vector2d v1 = new Vector2d(1, 1);

        // When & Then
        assertEquals(new Vector2d(-1, -1), v1.opposite(), "Opposite of (1,1) should be (-1,-1)");
    }

    @Test
    public void testEquals() {
        // Given
        Vector2d v1 = new Vector2d(1, 1);
        Vector2d v2 = new Vector2d(1, 1);
        Vector2d v3 = new Vector2d(2, 2);

        // When & Then
        assertEquals(v1, v2, "Vectors (1,1) and (1,1) should be equal");
        assertNotEquals(v1, v3, "Vectors (1,1) and (2,2) should not be equal");
    }

    @Test
    public void testHashCode() {
        // Given
        Vector2d v1 = new Vector2d(1, 1);
        Vector2d v2 = new Vector2d(1, 1);

        // When & Then
        assertEquals(v1.hashCode(), v2.hashCode(), "Hash codes of (1,1) and (1,1) should be equal");
    }

    @Test
    public void testToString() {
        // Given
        Vector2d v1 = new Vector2d(1, 1);

        // When & Then
        assertEquals("(1,1)", v1.toString(), "String representation of (1,1) should be '(1,1)'");
    }
}
