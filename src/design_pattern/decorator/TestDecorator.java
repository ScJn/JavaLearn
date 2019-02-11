package design_pattern.decorator;

public class TestDecorator {

    public static void main(String[] args) {

        Dog dog=new Dog();

        dog.hum();

        JumpDog jumpDog= new JumpDog(new Dog());
        SwimDog swimAndJumpDog = new SwimDog(new JumpDog(new Dog()));

        swimAndJumpDog.hum();
    }
}
