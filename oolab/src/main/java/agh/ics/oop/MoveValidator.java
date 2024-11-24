package agh.ics.oop;

import agh.ics.oop.model.Vector2d;

public interface MoveValidator {

    /**
     * Indicate if any object can changePosition to the given position.
     *
     * @param position
     *            The position checked for the movement possibility.
     * @return True if the object can changePosition to that position.
     */
    boolean canMoveTo(Vector2d position);
}
