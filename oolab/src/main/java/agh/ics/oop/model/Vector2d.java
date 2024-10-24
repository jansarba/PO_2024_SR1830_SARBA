package agh.ics.oop.model;

import java.util.Objects;

public class Vector2d {
    private final int x,y;
    public Vector2d(int x, int y) {
        this.x=x;
        this.y=y;
    }
    public int[] getXY() {
        return new int[]{x,y};
    }
    public String toString(){
        return String.format("(%d,%d)", x,y);
    }
    public boolean precedes(Vector2d other){
        return x<=other.x && y<=other.y;
    }
    public boolean follows(Vector2d other){
        return x>=other.x && y>=other.y;
    }
    public Vector2d add(Vector2d other){
        return new Vector2d(x+other.x,y+other.y);
    }
    public Vector2d subtract(Vector2d other){
        return new Vector2d(x-other.x,y-other.y);
    }
    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(x,other.x),Math.max(y,other.y));
    }
    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(x,other.x),Math.min(y,other.y));
    }
    public Vector2d opposite(){
        return new Vector2d(-x,-y);
    }
    public boolean equals(Object other){
        Vector2d otherVector = (Vector2d)other;
        return x==otherVector.x && y==otherVector.y;
    }
    public int hashCode(){
        return Objects.hash(x,y);
    }
}
