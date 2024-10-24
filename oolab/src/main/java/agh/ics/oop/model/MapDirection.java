package agh.ics.oop.model;

public enum MapDirection {
    NORTH, EAST, SOUTH, WEST;

    public static final Vector2d NORTH_VEC = new Vector2d(0, 1);
    public static final Vector2d EAST_VEC = new Vector2d(1, 0);
    public static final Vector2d SOUTH_VEC = new Vector2d(0, -1);
    public static final Vector2d WEST_VEC = new Vector2d(-1, 0);

    private static final String NORTH_STRING = "Pułnoc";
    private static final String EAST_STRING = "Wschód";
    private static final String SOUTH_STRING = "Południe";
    private static final String WEST_STRING = "Zachód";

    public static final Vector2d UPPER_RIGHT_BOUNDARY = new Vector2d(4, 4);
    public static final Vector2d LOWER_LEFT_BOUNDARY = new Vector2d(0, 0);

    @Override
    public String toString() {
        return switch (this) {
            case NORTH -> NORTH_STRING;
            case EAST -> EAST_STRING;
            case SOUTH -> SOUTH_STRING;
            case WEST -> WEST_STRING;
        };
    }
    public MapDirection next(){
        return switch(this){
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }
    public MapDirection previous(){
        return switch(this){
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }
    // nie wiem czy ladniej robic osobne opposite() czy po prostu uzywac next().next()

    public Vector2d toUnitVector(){
        return switch(this){
            case NORTH -> NORTH_VEC;
            case EAST -> EAST_VEC;
            case SOUTH -> SOUTH_VEC;
            case WEST -> WEST_VEC;
        };
    }
}
