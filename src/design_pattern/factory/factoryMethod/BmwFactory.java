package design_pattern.factory.factoryMethod;

public class BmwFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new BMW();
    }
}
