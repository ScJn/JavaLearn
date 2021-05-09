package leetcode.xiaozhao.pdd;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * big int multiply(String)
 * first, we can determine the maxLength of the result (a.length+b.length)
 * then we use a int array to represent the result, it's the most convenient way.
 * find the locality corresponding to the two num multiply
 * i*j --> res[i+j],res[i+j+1]
 * then you just need to update the res[i+j],res[i+j+1], which can be regarded as two ten digital plus
 *
 */
public class Pdd2018_2 {
    public static void solution(String num1, String num2) {
        int[] ret = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ret[i + j] += (ret[i + j + 1] + x * y) / 10;
                ret[i + j + 1] = (ret[i + j + 1] + x * y) % 10;

            }
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < ret.length; i++) {
            if (i == 0 && ret[i] == 0) continue;
            s.append(ret[i]);
        }
        System.out.println(s);
    }

    public static void solution2(String a,String b){
        BigInteger num1=new BigInteger(a);
        BigInteger num2=new BigInteger(b);
        System.out.println(num1.multiply(num2));
    }

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        String a = in.next();
        String b = in.next();
        solution2(a, b);

    }


}