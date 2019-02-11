package design_pattern.adapter;

public class KeyUSBAdapter2 implements USB{

    private KeyBorad keyBorad;

    public KeyUSBAdapter2(){
        keyBorad=new KeyBorad();
    }


    @Override
    public void work() {
        keyBorad.press();
    }
}
