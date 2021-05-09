package design_pattern.prototype;

import java.util.Date;

public class TestPrototype {

    public static void main(String[] args) throws Exception {
        Sheep s=new Sheep();
        Date d=new Date(222222);
        s.setName("ss");

//        s.setDate(d);
//
//        Sheep s2= (Sheep) s.clone();
//        d.setTime(System.currentTimeMillis()); //浅复制
//        System.out.println(s.getDate());
//        System.out.println(s2.getName());
//        System.out.println(s2.getDate());

        Sheep2 sheep2=new Sheep2();
        sheep2.setDate(d);
        Sheep2 sheep21= (Sheep2) sheep2.clone();

        d.setTime(1000000000L);
        System.out.println(sheep2.getDate());

        System.out.println(sheep21.getDate());
    }
}
