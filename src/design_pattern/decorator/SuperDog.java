package design_pattern.decorator;


/**
 * decorator Component
 */
public class SuperDog implements Animal {

    Animal dog;

    public SuperDog(Animal dog) {
        this.dog = dog;
    }

    @Override
    public void hum() {
        dog.hum();
    }
}
