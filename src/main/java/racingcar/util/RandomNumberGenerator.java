package racingcar.util;

public class RandomNumberGenerator {
    public static int randomNumber(int min, int max){
        return (int)(Math.random()*(max-min+1)+min);
    }
}
