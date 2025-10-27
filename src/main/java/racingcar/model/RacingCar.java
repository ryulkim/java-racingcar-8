package racingcar.model;

public class RacingCar {
    String name;
    int status;

    public RacingCar(String name) {
        this.name = name;
    }

    public void incrementStatus() {
        status++;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }
}
