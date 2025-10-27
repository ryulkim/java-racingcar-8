package racingcar.util;

import java.util.HashSet;
import java.util.Set;

public class InputParser {
    public static String[] parseCarNames(String input) {
        String[] names = input.split(",");

        return names;
    }
}
