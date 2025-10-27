package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    @Test
    public void 정상_입력_자동차_이름들이_들어왔을_경우(){
        //given
        String input="pobi,woni,jun";

        //when
        String[] output=InputParser.parseCarNames(input);

        //then
        Assertions.assertArrayEquals(output,new String[]{"pobi","woni","jun"});
    }
}
