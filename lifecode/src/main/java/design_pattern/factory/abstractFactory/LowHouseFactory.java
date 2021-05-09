package design_pattern.factory.abstractFactory;

public class LowHouseFactory implements HouseFactory {

    @Override
    public Door createDoor() {
        return new LowDoor();
    }

    @Override
    public Floor createFloor() {
        return new LowFloor();
    }

    @Override
    public Windows createWindows() {
        return new LowWindows();
    }

    public static void main(String[] args) {

    }
}
