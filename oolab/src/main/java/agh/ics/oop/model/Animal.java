package agh.ics.oop.model;

public class Animal {
    public MapDirection orientation;
    public Vector2d position;
    public final int index;
    public Animal(MapDirection orientation, Vector2d position, int index) {
        this.orientation = orientation;
        this.position = position;
        this.index = index;
    }
    public Animal(){ //default constructor to trzeba tak zoverloadowac chyba??
        this(MapDirection.NORTH, new Vector2d(2,2),127); //jakis bezpieczny index choc nie wiem czy nie lepiej wywalac bledu przy braku indeksu?
    }
    @Override
    public String toString() {
        return "Zwierzę " + index + ": " + position;
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public boolean isInside(Vector2d position){ // metoda bardziej prewencyjna wiec jakbym korzystal z this.position to by bylo juz za pozno
        return (position.follows(MapDirection.LOWER_LEFT_BOUNDARY) & position.precedes(MapDirection.UPPER_RIGHT_BOUNDARY));
    }

    public void move(MoveDirection direction){
        Vector2d forward_vec = switch (orientation) { //patrzymy, gdzie jest "przod"
            case NORTH -> MapDirection.NORTH_VEC;
            case EAST -> MapDirection.EAST_VEC;
            case SOUTH -> MapDirection.SOUTH_VEC;
            case WEST -> MapDirection.WEST_VEC;
        };

        switch (direction){ //jesli forward/backward to idziemy
            case FORWARD:
                if (isInside(position.add(forward_vec))){ // brzydkie chyba
                    this.position=position.add(forward_vec);
                }
                break;
            case BACKWARD:
                if (isInside(position.add(forward_vec.opposite()))){
                    this.position=position.add(forward_vec.opposite());
                }
                break;
            default: break;
        }

        this.orientation = switch(direction){ //kierunek na podstawie tego gdzie poszlismy
            case RIGHT -> orientation.next();
            case LEFT -> orientation.previous();
            case FORWARD -> orientation;
            case BACKWARD -> orientation.next().next(); //brzydkie
        };
    }
}
