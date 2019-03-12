package leetcode.xiaozhao.pdd;

import java.util.Arrays;
import java.util.Scanner;

public class Pdd2018_3 {

    static class Main {
        public static void solution(Integer[] h, Integer[] w) {
            Arrays.sort(h);
            Arrays.sort(w);
            int res = 0;

            int hIndex = 0;
            for (int j = 0; j < w.length&&hIndex<h.length; j++) {// traverse w

                int w1 = w[j];
                int h1 = h[hIndex];

                if (w1 >= h1) {
                    hIndex++;
                    res++;
                }
            }

            System.out.println(res);
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            Integer[] h = new Integer[n];
            for (int i = 0; i < n; i++) {
                h[i] = in.nextInt();
            }

            Integer m = in.nextInt();
            Integer[] w = new Integer[m];
            for (int i = 0; i < m; i++) {
                w[i] = in.nextInt();
            }
            solution(h, w);
        }
    }
}
