package design_pattern.factory.factoryMethod;

public class TestFactoryMethod {

    public static void main(String[] args) {
        CarFactory bydFactory=new BydFactory();
        CarFactory bmwFactory=new BmwFactory();

        Car bmw=bmwFactory.createCar();
        Car byd=bydFactory.createCar();

        bmw.run();
        byd.run();

    }
}
