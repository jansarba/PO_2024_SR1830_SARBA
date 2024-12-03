package agh.ics.oop;

import agh.ics.oop.exceptions.IllegalArgumentException;
import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    private static final String MESSAGE_WRONG_LETTER = " to niemozliwy kierunek!";
    private static final String MESSAGE_INVALID_CHAR = " zawiera nielegalne znaki. Tylko litery sa dozwolone!";

    public static List<MoveDirection> optionsParser(String[] args) {
        List<MoveDirection> result = new ArrayList<>();
        for (String arg : args) {
            try {
                if (arg.matches("[a-zA-Z]")) { // regex sprawdza litere
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
                            throw new IllegalArgumentException(arg + MESSAGE_WRONG_LETTER, 1);
                    }
                } else {
                    throw new IllegalArgumentException(arg + MESSAGE_INVALID_CHAR, 2);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Pominalem: " + e.getMessage());
                // kontynuujemy
            }
        }
        return result;
    }
}