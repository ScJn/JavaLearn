package design_pattern.proxy.dynamicProxy;

import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandle implements InvocationHandler {

    Star star;

    public StarHandle(Star star) {
        this.star = star;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getName().equals("sing")){
            method.invoke(star,args);
        }else {
            System.out.println(method.getName()+" doing");
        }
        return null;
    }
}
