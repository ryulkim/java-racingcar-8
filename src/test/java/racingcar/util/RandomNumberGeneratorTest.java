package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    @Test
    public void 랜덤_값이_최소_최대_값_사이로_나오는지() {
        // given
        int min=0;
        int max=9;

        // when
        int result=RandomNumberGenerator.randomNumber(min,max);

        // then
        Assertions.assertTrue(result>=min&&result<=max);
    }
}
