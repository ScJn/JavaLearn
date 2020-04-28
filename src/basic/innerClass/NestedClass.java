package basic.innerClass;

public class NestedClass {

    static class Nest{
       static int c = 4;
    }

    public static void main(String[] args) {
        Nest nest = new Nest();
        nest.c++;
        Nest nest1 = new Nest();
        System.out.println(nest1.c);
    }
}
