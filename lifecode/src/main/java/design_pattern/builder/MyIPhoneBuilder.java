package design_pattern.builder;

public class MyIPhoneBuilder implements IphoneBuilder {
    @Override
    public Screen createScreen() {
        return new Screen();
    }

    @Override
    public Cpu createCpu() {
        return new Cpu();
    }

    @Override
    public Battery createBattery() {
        return new Battery();
    }
}
