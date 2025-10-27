package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import racingcar.model.RacingCar;
import racingcar.util.InputHandler;
import racingcar.util.InputParser;
import racingcar.util.OutputView;

public class RacingCarController {
    ArrayList<RacingCar> racingCars;

    public RacingCarController() {
        racingCars = new ArrayList<>();
    }

    public void run(){
        OutputView.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames= InputParser.parseCarNames(InputHandler.readLine());

        createRacingCars(carNames);

        OutputView.print("시도할 횟수는 몇 회인가요?");
        InputHandler.readLine();

        InputHandler.close();
    }

    private void createRacingCars(String[] carNames) {
        Arrays.stream(carNames).map(this::createCar).forEach(racingCars::add);
    }

    private RacingCar createCar(String carName) {
        return new RacingCar(carName);
    }

}
