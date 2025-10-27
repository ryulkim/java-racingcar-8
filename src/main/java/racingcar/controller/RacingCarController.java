package racingcar.controller;

import racingcar.util.InputHandler;
import racingcar.util.OutputView;

public class RacingCarController {
    public void run(){
        OutputView.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        InputHandler.readLine();

        InputHandler.close();
    }
}
