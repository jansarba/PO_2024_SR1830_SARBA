package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> optionsParser(String[] args) {
        List<MoveDirection> result = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "f":
                    result.add(MoveDirection.FORWARD);
                    break;
                case "b":
                    result.add(MoveDirection.BACKWARD);
                    break;
                case "l":
                    result.add(MoveDirection.LEFT);
                    break;
                case "r":
                    result.add(MoveDirection.RIGHT);
                    break;
                default:
                    throw new IllegalArgumentException(arg + " is not legal changePosition specification");
            }
        }
        return result;
    }
}