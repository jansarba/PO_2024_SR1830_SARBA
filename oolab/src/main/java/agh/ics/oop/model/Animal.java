package agh.ics.oop.model;

import agh.ics.oop.MoveValidator;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.RectangularMap;

public class Animal {
    public MapDirection orientation;
    public Vector2d position;
    public final int index;

    public Animal(MapDirection orientation, Vector2d position, int index) {
        this.orientation = orientation;
        this.position = position;
        this.index = index;
    }
    public Animal(Vector2d position, int index) { //overloading tez
        this(MapDirection.NORTH, position, index);
    }
    public Animal(){ //default constructor to trzeba tak zoverloadowac chyba??
        this(MapDirection.NORTH, new Vector2d(2,2),127); //jakis bezpieczny index choc nie wiem czy nie lepiej wywalac bledu przy braku indeksu?
    }

    public Vector2d getPosition(){
        return position;
    }

    public void setPosition(Vector2d newPosition){
        this.position = newPosition;
    }

    @Override
    public String toString() {
        return switch (orientation) { // Schematyczna orientacja zwierzęcia
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public boolean isInside(Vector2d position){
        return (position.follows(RectangularMap.getLOWER_LEFT_BOUNDARY()) & position.precedes(RectangularMap.getUPPER_RIGHT_BOUNDARY()));
    }

    public void move(MoveDirection direction, MoveValidator validator){
        Vector2d forward_vec = switch (orientation) { //patrzymy, gdzie jest "przod"
            case NORTH -> MapDirection.NORTH_VEC;
            case EAST -> MapDirection.EAST_VEC;
            case SOUTH -> MapDirection.SOUTH_VEC;
            case WEST -> MapDirection.WEST_VEC;
        };

        switch (direction){ //jesli forward/backward to idziemy
            case FORWARD:
                Vector2d newPosition_1 = position.add(forward_vec);
                if (validator.canMoveTo(newPosition_1)) {
                    this.position = newPosition_1;
                }
                break;
            case BACKWARD:
                Vector2d newPosition_2 = position.add(forward_vec.opposite());
                if (validator.canMoveTo(newPosition_2)) {
                    this.position = newPosition_2;
                }
                break;
            default: break;
        }

        this.orientation = switch(direction){ //kierunek na podstawie tego gdzie poszlismy
            case RIGHT -> orientation.next();
            case LEFT -> orientation.previous();
            case FORWARD -> orientation;
            case BACKWARD -> orientation.next().next();
        };
    }
}