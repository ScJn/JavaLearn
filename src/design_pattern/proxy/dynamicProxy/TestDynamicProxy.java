package design_pattern.proxy.dynamicProxy;

import design_pattern.proxy.staticProxy.Proxy;

public class TestDynamicProxy {

    public static void main(String[] args) {

        RealStar realStar=new RealStar();

        StarHandle starHandle=new StarHandle(realStar);

        Star proxy= (Star) java.lang.reflect.Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class},starHandle);
        proxy.sign();
        proxy.sing();
        proxy.money();
    }
}
