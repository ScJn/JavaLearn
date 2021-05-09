package design_pattern.factory.abstractFactory;

public interface HouseFactory {
    Door createDoor();
    Floor createFloor();
    Windows createWindows();
}
