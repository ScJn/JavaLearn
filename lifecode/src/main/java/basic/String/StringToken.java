package basic.String;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringToken {

    public static void main(String[] args) {
        String input = "I am super hero wa!";
        StringTokenizer stringTokenizer = new StringTokenizer(input, "a");

        while (stringTokenizer.hasMoreElements()){
            System.out.println(stringTokenizer.nextElement());
        }
        for (String s : input.split(" ")) {
            System.out.println(s);
        }

        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
