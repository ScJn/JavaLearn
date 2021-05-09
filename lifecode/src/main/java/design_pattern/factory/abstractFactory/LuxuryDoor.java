package design_pattern.factory.abstractFactory;

public class LuxuryDoor implements Door{

    @Override
    public void open() {
        System.out.println("fast");
    }
}
