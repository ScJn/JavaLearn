package basic.keyword;

public class FinalArgument {

    void with(final int a) {

        int c = a + 1;
//        a = 1;
        System.out.println(a + 1);

    }

    void without(int a) {
        a = 1;
        System.out.println(a + 1);
    }
}
