package basic.keyword;

public class EnumTest {


    public static void main(String[] args) {

        Num n = Num.ONE;
        switch (n) {
            case ONE:
            case TWO:
                System.out.println("less than three");
                break;
            case THREE:
                System.out.println("equal to three");
                break;
            case FIVE:
            case FOUR:
                System.out.println("greater than three");
                break;
        }
    }

    private static void test2() {
        for (Num n : Num.values()) {
            System.out.println(n + " " + n.ordinal());
        }
    }

    private static void test1() {
        Num one = Num.ONE;
        System.out.println(one);
    }
}

enum Num {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
}

