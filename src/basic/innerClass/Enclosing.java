package basic.innerClass;

import java.net.Inet4Address;

public class Enclosing {
    int c = 4;

    Enclosing out = Enclosing.this;
    Enclosing out2 = this;
     class Inner {
        void pc() {
            c++;
        }
        void print(){
            System.out.println(out);
            System.out.println(out2);
            System.out.println(this);
        }
        Enclosing getOuter(){
            return Enclosing.this;
        }
    }

    public Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Enclosing en = new Enclosing();
        Inner inner = en.getInner();
        inner.pc();
        System.out.println(en.c);
        Inner inner1 = en.getInner();
        System.out.println(inner.getOuter());
        System.out.println(inner1.getOuter());

        Inner inner2 = en.new Inner();
        System.out.println(inner);
        System.out.println(inner2);

        System.out.println("***********");

        inner.print();

    }
}

class OO{
    public static void main(String[] args) {
        Enclosing en = new Enclosing();
        //! Enclosing.Inner inner = en.new Inner();
    }
}