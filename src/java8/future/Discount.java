package java8.future;

import util.TimeUtils;

import java.util.Random;

public class Discount {
    public enum Code{
        NONE(0),
        SILVER(5),
        GOLD(10),
        PLATINUM(15),
        DIAMOND(20);

        private final int percentage;


        Code(int percentage) {
            this.percentage = percentage;
        }
    }



    public static double getDiscountPrice(double price){

        Code code = Code.values()[new Random(1).nextInt(Code.values().length)];
        TimeUtils.delay(); // mock IO cost
        return price * (100 -code.percentage)/100;
    }
}
