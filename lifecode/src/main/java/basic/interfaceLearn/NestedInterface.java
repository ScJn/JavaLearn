package basic.interfaceLearn;

public class NestedInterface {

    interface Nest{
        void nest();

        interface NestX2{
            void nest2();
        }
    }

    public static void main(String[] args) {
        NestedInterface nestedInterface = new NestedInterface();
        Nest nest = new Nest() {
            @Override
            public void nest() {
                System.out.println("nest()");
            }
        };

        Nest.NestX2 nestX2 = new Nest.NestX2() {
            @Override
            public void nest2() {
                System.out.println("nest2");
            }
        };
    }
}


