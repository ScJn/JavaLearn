package basic;

/**
 * static -> field -> constructor
 *
 *
 * @author scjn
 * @date 2020/4/9 21:00
 */
public class Initialization {

    public B b = new B(1);
    static A a = new A(1);
    static B b3 = new B(3);
    private B b2;
    static A a3;

    Initialization(){
        b2 = new B(2);
        a3 = new A(3);
    }
    static A a2 = new A(2);


}
class A{
    void f(){
        System.out.println("f");
    }
    A(int i){
        System.out.println(i + " A create");
    }
    public static void main(String[] args) {
        for(String s: args) System.out.println(s + " ");
    }
}
class B{
    void f2(){
        System.out.println("f2");
    }
    B(int i){
        System.out.println(i + " B create");
    }
}
