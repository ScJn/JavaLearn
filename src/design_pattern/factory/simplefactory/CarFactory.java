package design_pattern.factory.simplefactory;


public class CarFactory {

    /**
     * do not need to know the constructor of each implements car
     * @param name the car name
     */
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
