package design_pattern.proxy.dynamicProxy;


import java.lang.reflect.Proxy;

public class TestDynamicProxy {

    public static void main(String[] args) {

        RealStar realStar = new RealStar();

        StarHandle starHandle = new StarHandle(realStar);

        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class},
                starHandle);
        proxy.sign();
        proxy.sing();
        proxy.money();
    }
}
