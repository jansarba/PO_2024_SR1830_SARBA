package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    public void testValidArguments() {
        // Given
        String[] args = {"f", "b", "l", "r"};

        // When
        List<MoveDirection> result = OptionsParser.optionsParser(args);

        // Then
        assertEquals(4, result.size(), "Result should contain 4 directions.");
        assertEquals(List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT), result, "Parsed directions should match the input.");
    }

    @Test
    public void testInvalidArgument() {
        // Given
        String[] args = {"f", "x", "l"};

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> OptionsParser.optionsParser(args),
                "Parsing invalid arguments should throw IllegalArgumentException."
        );
        assertEquals("x is not legal changePosition specification", exception.getMessage(), "Exception message should indicate the invalid argument.");
    }

    @Test
    public void testEmptyInput() {
        // Given
        String[] args = {};

        // When
        List<MoveDirection> result = OptionsParser.optionsParser(args);

        // Then
        assertTrue(result.isEmpty(), "Result should be empty for no input.");
    }

    @Test
    public void testDuplicateArguments() {
        // Given
        String[] args = {"f", "f", "b", "b"};

        // When
        List<MoveDirection> result = OptionsParser.optionsParser(args);

        // Then
        assertEquals(4, result.size(), "Result should contain 4 directions.");
        assertEquals(List.of(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD), result, "Parsed directions should match the input, including duplicates.");
    }

    @Test
    public void testMixedValidAndInvalidArguments() {
        // Given
        String[] args = {"r", "wrong", "f"};

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> OptionsParser.optionsParser(args),
                "Parsing mixed valid and invalid arguments should throw IllegalArgumentException."
        );
        assertEquals("wrong is not legal changePosition specification", exception.getMessage(), "Exception message should indicate the first invalid argument.");
    }
}