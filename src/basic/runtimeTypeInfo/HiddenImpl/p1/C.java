package basic.runtimeTypeInfo.HiddenImpl.p1;

import basic.runtimeTypeInfo.HiddenImpl.p2.D;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface C {
    void f();

    static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        C c = new D();
        c.f();

        if (c instanceof D) {
            ((D) c).pub();
        }

        Method[] declaredMethods = c.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);
            System.out.println(declaredMethod.getName());
            if (declaredMethod.getName().equals("f2")) {
                declaredMethod.invoke(c);
            }
        }


    }
}
