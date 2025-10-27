package racingcar.util;

import java.util.HashSet;
import java.util.Set;

public class InputParser {
    public static String[] parseCarNames(String input) {
        String[] names = input.split(",");
        Set<String> uniqueNames = new HashSet<>();

        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();

            if (!uniqueNames.add(names[i])) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다: " + names[i]);
            }
        }
        return names;
    }
}
