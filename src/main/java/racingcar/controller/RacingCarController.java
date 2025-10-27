package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import racingcar.model.RacingCar;
import racingcar.util.InputHandler;
import racingcar.util.InputParser;
import racingcar.util.OutputView;
import racingcar.util.RandomNumberGenerator;

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
        int num=InputParser.parseInt(InputHandler.readLine());
        game(num);

        InputHandler.close();
    }

    private void game(int number){
        for(int i=0;i<number;i++){
            round();
        }
    }

    private void round(){
        racingCars.forEach(racingCar -> {
            int num=RandomNumberGenerator.randomNumber(0,9);
            if(num>=4){
                racingCar.incrementStatus();
            }
        });
    }

    private void createRacingCars(String[] carNames) {
        Arrays.stream(carNames).map(this::createCar).forEach(racingCars::add);
    }

    private RacingCar createCar(String carName) {
        return new RacingCar(carName);
    }

}
