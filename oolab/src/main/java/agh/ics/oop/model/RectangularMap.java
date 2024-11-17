package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private final int width;
    private final int height;
    private static final Vector2d LOWER_LEFT_BOUNDARY = new Vector2d(0, 0);
    private static Vector2d UPPER_RIGHT_BOUNDARY; // nie umiem zrobic tego nie-final
    private final Map<Vector2d, Animal> animals = new HashMap<>();

    public RectangularMap() {
        this(5, 5);
        UPPER_RIGHT_BOUNDARY = new Vector2d(5, 5);
    }
    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        UPPER_RIGHT_BOUNDARY = new Vector2d(width, height); // lepiej zrobic tak czy od razu (=-1, =-1)?
    }
    public static Vector2d getLOWER_LEFT_BOUNDARY() {
        return LOWER_LEFT_BOUNDARY;
    }
    public static Vector2d getUPPER_RIGHT_BOUNDARY() {
        return UPPER_RIGHT_BOUNDARY;
    }

    private boolean isWithinBounds(Vector2d position) {
        return position.follows(LOWER_LEFT_BOUNDARY) && position.precedes(UPPER_RIGHT_BOUNDARY);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (isWithinBounds(position) && !isOccupied(position)) {
            animals.put(position, animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction,this);
        Vector2d newPosition = animal.getPosition();

        if (isWithinBounds(newPosition) && !isOccupied(newPosition)) {
            animals.remove(oldPosition);
            animals.put(newPosition, animal);
        } else {
            animal.setPosition(oldPosition);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return isWithinBounds(position) && !isOccupied(position);
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(LOWER_LEFT_BOUNDARY, UPPER_RIGHT_BOUNDARY.add(new Vector2d(-1,-1)));
    }
}