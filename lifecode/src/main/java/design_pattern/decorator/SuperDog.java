package design_pattern.decorator;


/**
 * decorator Component:
 * @see  java.io.FilterInputStream
 * need a abstract component object as a field
 * all the function need to invoke the field's function repeatedly
 */
public class SuperDog implements Animal {

    @Override
    public void hum() {
        dog.hum();
    }

    public SuperDog(Animal dog) {
        this.dog = dog;
    }

    Animal dog;
}
