package design_pattern.factory.abstractFactory;

public class LowDoor implements Door{

    @Override
    public void open() {
        System.out.println("slow");
    }
}
