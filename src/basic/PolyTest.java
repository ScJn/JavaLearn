package basic;

public class PolyTest {
    int f = 1;

    public int getF() {
        return f;
    }

    public static void print(){
        System.out.println(123);
    }
    static class subPolyTesty extends PolyTest{
        int f = 2;

        public int getF() {
            return f;
        }

        public static void print(){
            System.out.println(321);
        }

    }

    public static void main(String[] args) {
        PolyTest polyTest = new subPolyTesty();
        System.out.println(polyTest.f);
        System.out.println(polyTest.getF());
        polyTest.print();
    }
}
