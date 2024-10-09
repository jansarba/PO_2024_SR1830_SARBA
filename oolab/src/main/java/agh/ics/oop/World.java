package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import static agh.ics.oop.OptionsParser.optionsParser;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartowal");
        run(optionsParser(args));
        System.out.println("system wylacza sie");
    }
    public static void run(MoveDirection[] moveDirection) {
        System.out.println("Zwierzak idzie do przodu");
        for (MoveDirection dir : moveDirection) {
            System.out.println(dir.toString());
        }
    }
}