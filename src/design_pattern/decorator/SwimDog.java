package design_pattern.decorator;

public class SwimDog extends SuperDog{
    public SwimDog(Animal dog) {
        super(dog);
    }

    @Override
    public void hum() {
        System.out.println("swim");
        super.hum();
    }

    public void swim(){
        System.out.println("swim");
    }
}
