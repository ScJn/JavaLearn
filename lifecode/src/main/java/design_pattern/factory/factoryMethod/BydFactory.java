package design_pattern.factory.factoryMethod;

public class BydFactory implements CarFactory{

    @Override
    public Car createCar() {
        return new BYD();
    }
}
