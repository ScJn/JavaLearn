package design_pattern.factory.abstractFactory;

public class LowWindows implements Windows{

    @Override
    public void open() {
        System.out.println("slow");
    }
}
