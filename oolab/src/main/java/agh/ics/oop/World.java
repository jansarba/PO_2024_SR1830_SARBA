package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import static agh.ics.oop.OptionsParser.optionsParser;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartowal");
        run(optionsParser(args));
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println("system wylacza sie");
    }
    public static void run(MoveDirection[] moveDirection) {
        for (MoveDirection dir : moveDirection) {
            System.out.println(dir.toString());
        }
    }

}