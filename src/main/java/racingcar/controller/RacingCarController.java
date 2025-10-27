package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import racingcar.model.RacingCar;
import racingcar.util.InputHandler;
import racingcar.util.InputParser;
import racingcar.util.OutputView;

public class RacingCarController {
    ArrayList<RacingCar> racingCars;

    public RacingCarController() {
        racingCars = new ArrayList<>();
    }

    public void run() {
        OutputView.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = InputParser.parseCarNames(InputHandler.readLine());

        createRacingCars(carNames);

        OutputView.print("시도할 횟수는 몇 회인가요?");
        int num = InputParser.parseInt(InputHandler.readLine());
        game(num);

        ArrayList<String> winners = getWinners();
        OutputView.print(String.format("%s : %s", "최종 우승자", String.join(", ", winners)));

        InputHandler.close();
    }

    public ArrayList<String> getWinners() {
        AtomicInteger max = new AtomicInteger();
        ArrayList<String> winners = new ArrayList<>();

        racingCars.sort((a, b) -> Integer.compare(b.getStatus(), a.getStatus()));

        racingCars.forEach((racingCar -> {
            if (max.get() <= racingCar.getStatus()) {
                max.set(racingCar.getStatus());
                winners.add(racingCar.getName());
            }
        }));

        return winners;
    }

    private void game(int number) {
        OutputView.print("실행 결과");
        for (int i = 0; i < number; i++) {
            round();
            racingCars.forEach((OutputView::printCarStatus));
            OutputView.print("");
        }
    }

    private void round() {
        racingCars.forEach(racingCar -> {
            int num = Randoms.pickNumberInRange(0, 9);
            if (num >= 4) {
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
