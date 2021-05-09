package basic.interfaceLearn.interfaceAndFactory;

public class CarService implements Service {
    @Override
    public void service() {
        System.out.println("car");
    }
}
