package design_pattern.strategy;

import util.PrintUtils;

public class Start {

    public static void main(String[] args) {
        String s = "111s";

//        normalValidate(s);
        PrintUtils.println();
        strategyValidate(s, new LowerCaseValidator());
        strategyValidate(s, new NumericValidator());

        strategyValidate(s, (c)-> c.matches("[a,c]"));


    }

    public static void strategyValidate(String s, Validator validator){
        System.out.println(validator.execute(s));
    }

    private static void normalValidate(String s) {
        if (isLowCase(s)) {
            System.out.println("string:" + s + " good!");
        } else if (isNumeric(s)) {
            System.out.println("num:" + Integer.parseInt(s));

        }
    }

    private static boolean isNumeric(String s) {
        return false;
    }

    private static boolean isLowCase(String s) {
        return false;
    }
}
