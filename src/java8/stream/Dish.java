package java8.stream;

/**
 * @author scjn
 * @date 2020/6/27 11:05
 */
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    enum Type {
        MEAT,
        FISH,
        OTHER
    }

    enum Health{
        HEAT,
        MIDDLE,
        LOW
    }
}
