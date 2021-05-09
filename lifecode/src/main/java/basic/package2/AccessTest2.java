package basic.package2;

import basic.package1.Car;

public class AccessTest2 extends Car {

    public static void main(String[] args) {

        Car car = new Car();
        car.pub();
        AccessTest2 accessTest2 = new AccessTest2();
        accessTest2.pro();
    }
}
