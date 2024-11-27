package agh.ics.oop.model;

import agh.ics.oop.model.Boundary;
import agh.ics.oop.exceptions.IncorrectPositionException;
import agh.ics.oop.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected Vector2d lowerLeft = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final MapVisualizer visualizer = new MapVisualizer(this);
    protected ArrayList<MapChangeListener> observers= new ArrayList<>();

    public void addObserver(MapChangeListener observer) {
        observers.add(observer);
    }

    public void removeObserver(MapChangeListener observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(String message) {
        for (MapChangeListener observer : observers) {
            observer.mapChanged(this, message);
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight) && !(objectAt(position) instanceof Animal);
    }

    @Override
    public void place(Animal animal) throws IncorrectPositionException{
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            notifyObservers("Zwierze polozone na: " + animal.getPosition());
        }
        else{
            throw new IncorrectPositionException(animal.getPosition());
        }
    }

    @Override
    public void move(Animal animal, MoveDirection direction) throws IncorrectPositionException{
        Vector2d oldPosition = animal.getPosition();
        animal.changePosition(direction, this);
        animals.remove(oldPosition);
        animals.put(animal.getPosition(), animal);
        notifyObservers("Zwierze przeniesione z: " + oldPosition + " na: " + animal.getPosition());
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if(animals.get(position) != null) return animals.get(position);
        return null;
    }

    @Override
    public List<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }

    @Override
    public Boundary getBoundary() {
        return new Boundary(lowerLeft, upperRight);
    }

    @Override
    public String toString() {
        return visualizer.draw(getBoundary().lowerLeft(), getBoundary().upperRight());
    }
}