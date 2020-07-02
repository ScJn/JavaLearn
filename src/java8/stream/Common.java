package java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scjn
 * @date 2020/7/1 11:35
 */
public class Common {
    public static List<Dish> init() {
        List<Dish> dishes = new ArrayList<>();

        dishes.add(new Dish("beaf", false, 1000, Dish.Type.MEAT));
        dishes.add(new Dish("tomato", true, 200, Dish.Type.OTHER));
        dishes.add(new Dish("fish1", false, 400, Dish.Type.FISH));
        dishes.add(new Dish("fish2", false, 400, Dish.Type.FISH));
        return dishes;
    }
}
