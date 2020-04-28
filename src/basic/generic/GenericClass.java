package basic.generic;

import basic.runtimeTypeInfo.HiddenImpl.p1.C;

import java.util.ArrayList;

public class GenericClass<F extends GenericClass.Car> {
    F item;

    static class Car {
        void drive() {
            System.out.println("drive");
        }
    }

    public F getItem() {
        return item;
    }

    public void invoke() {
        item.drive();
    }

    public void setItem(F item) {
        this.item = item;
    }

    public static void main(String[] args) {
        GenericClass<Car> a = new GenericClass<>();
        a.setItem(new Car());
        a.invoke();
    }
}
