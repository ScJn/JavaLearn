package design_pattern.builder;

public class Iphone {
    private Screen screen;
    private Cpu cpu;
    private Battery battery;

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }
}

class Screen{

}
class Cpu{}
class Battery{}