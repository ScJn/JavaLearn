package design_pattern.builder;

public class IPhoneDirector implements PhoneDirector {
    MyIPhoneBuilder builder=null;

    public IPhoneDirector() {
        this.builder = new MyIPhoneBuilder();
    }

    @Override
    public Iphone directPhone() {
        Screen screen=builder.createScreen();
        Cpu cpu=builder.createCpu();
        Battery battery=builder.createBattery();
        Iphone iphone=new Iphone();
        iphone.setBattery(battery);
        iphone.setCpu(cpu);
        iphone.setScreen(screen);
        return iphone;
    }
}
