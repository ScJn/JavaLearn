package design_pattern.decorator;

/**
 * concrete decorator component
 */
public class JumpDog extends SuperDog{
    public JumpDog(Dog dog) {
        super(dog);
    }

    public void hum(){
        System.out.println("Jump");
        super.hum();
    }

    public void jump(){
        System.out.println("jump");
    }
}
