package design_pattern.factory;

public class CarFactory {

    public Car createCar(String name){
        switch (name) {
            case "BMW":
                return new BMW();
            case "BYD":
                return new BYD();
            default:
                return null;
        }
    }
}
