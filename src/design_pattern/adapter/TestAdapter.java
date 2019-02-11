package design_pattern.adapter;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class TestAdapter {

    public static void press(USB usb){
        usb.work();
    }

    public static void main(String[] args) throws FileNotFoundException {
        press(new KeyUSBAdapter());

        press(new KeyUSBAdapter2());

        InputStream in=new BufferedInputStream(new FileInputStream("ds"));
    }
}
