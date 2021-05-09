package design_pattern.factory.lambda;

import design_pattern.factory.simplefactory.BMW;
import design_pattern.factory.simplefactory.BYD;
import design_pattern.factory.simplefactory.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LambdaFactory {

    final static Map<String, Supplier<Car>> map = new HashMap<>();
    static {
        map.put("BMW", BMW::new);
        map.put("BYD", BYD::new);

    }

    public static Car createCar(String name){
        Supplier<Car> carSupplier = map.get(name);
        if(carSupplier == null) throw new RuntimeException("no this car name");
        return carSupplier.get();
    }
}
