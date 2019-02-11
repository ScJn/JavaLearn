package design_pattern.adapter;

public class TestAdapter {

    public static void press(USB usb){
        usb.work();
    }

    public static void main(String[] args) {
        press(new KeyUSBAdapter());
    }
}
