package design_pattern.adapter;

public class KeyUSBAdapter extends KeyBorad implements USB {

    @Override
    public void work() {
        super.press();
    }
}
