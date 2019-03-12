package leetcode.xiaozhao.pdd;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class Pdd2018_1 {
    /*

    3 4 1 2
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Long> list = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(in.nextLong());
        }
        solution(list);
    }

    private static void solution(ArrayList<Long> list) {

        long max = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            long temp = list.get(i);
            if (temp > max) {
                max3=max2;
                max2=max;
                max = temp;
            }
            else if (temp > max2) {
                max3=max2;
                max2 = temp;
            }else if(temp>max3)max3=temp;
            if (temp < 0 && temp < min) {
                min2=min;
                min = temp;
            }
            else if (temp < 0 && temp < min2) min2 = temp;

        }
        System.out.println(Math.max(max*max2*max3,max*min*min2));

    }
}

