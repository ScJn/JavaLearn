package design_pattern.proxy.dynamicProxy;

public class RealStar implements Star {
    @Override
    public void sign() {
        System.out.println("real sign");
    }

    @Override
    public void sing() {
        System.out.println("real sing");
    }

    @Override
    public void money() {
        System.out.println("real money");
    }
}
