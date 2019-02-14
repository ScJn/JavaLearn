package design_pattern.decorator;

/**
 * concrete decorator component
 * @see java.io.BufferedInputStream
 *
 * the constructor need a abstract component parameter, usually using a
 * concrete component as the parameter
 * @see design_pattern.decorator.Animal
 */
public class JumpDog extends SuperDog{
    public JumpDog(Animal animal) {
        super(animal);
    }

    public void hum(){
        System.out.println("Jump");
        super.hum();
    }

    public void jump(){
        System.out.println("jump");
    }
}
