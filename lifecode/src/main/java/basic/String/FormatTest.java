package basic.String;

import java.util.Formatter;

public class FormatTest {

    Formatter f;

    FormatTest(Formatter f) {
        this.f = f;
    }

    void act(int x) {
        f.format("act x = %d\n", x);
    }

    public static void main(String[] args) {
        FormatTest formatTest = new FormatTest(new Formatter(System.out));
        formatTest.act(2);

        FormatTest t = new FormatTest(new Formatter(System.err));
        t.act(33);

        String w1 = "-12.3";
        formatTest.f.format("%" + w1 + "s%-10.3s%3.3s\n", "price", "aa", "ccc");
        formatTest.f.format("%" + w1 +
                "s%-10.3s%3.3s\n", "*****", "**", "***");
        formatTest.f.format("%" + w1 +
                "f%-10.3f%3.3f\n", 12.33442, 231.23232, 1.3);

    }
}
