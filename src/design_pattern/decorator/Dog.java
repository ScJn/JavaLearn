package design_pattern.decorator;


/**
 * concrete component
 */
public class Dog implements Animal {

    @Override
    public void hum() {
        System.out.println("wang wang");
    }
}
