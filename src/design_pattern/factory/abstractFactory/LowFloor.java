package design_pattern.factory.abstractFactory;

public class LowFloor implements Floor{

    @Override
    public void walk() {
        System.out.println("slow");
    }
}
