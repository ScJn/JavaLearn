package design_pattern.builder;

public interface IphoneBuilder {
    Screen createScreen();
    Cpu createCpu();
    Battery createBattery();
}
