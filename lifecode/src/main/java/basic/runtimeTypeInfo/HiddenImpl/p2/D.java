package basic.runtimeTypeInfo.HiddenImpl.p2;

import basic.runtimeTypeInfo.HiddenImpl.p1.C;

public class D implements C {
    @Override
    public void f() {
        System.out.println("d f()");
    }

    protected void f2(){
        System.out.println("pro f2()");
    }

    public void pub(){
        System.out.println("public f()");
    }
    void pack(){
        System.out.println("package f()");
    }
}
