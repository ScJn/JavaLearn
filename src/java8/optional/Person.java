package java8.optional;


import java.util.Optional;

public class Person {
    private Car car;

    public Car getCar() {
        return car;
    }

    public Optional<Car> getOptionalCar(){
        return Optional.ofNullable(car);
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
