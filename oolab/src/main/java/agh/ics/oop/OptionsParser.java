package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;

public class OptionsParser {
    public static MoveDirection[] optionsParser(String[] args) {
        ArrayList<MoveDirection> result = new ArrayList<>();
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
                    System.out.println("Invalid input: " + arg);
                    continue;
            }
        }
        return result.toArray(new MoveDirection[0]);
    }
}
