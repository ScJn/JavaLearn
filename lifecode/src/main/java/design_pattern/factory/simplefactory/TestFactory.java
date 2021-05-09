package design_pattern.factory.simplefactory;

public class TestFactory {

    public static void main(String[] args) {
        CarFactory factory=new CarFactory();
        Car byd=factory.createCar("BYD");
        Car bmw=factory.createCar("BMW");
        byd.run();
        bmw.run();
    }
}
