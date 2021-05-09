package leetcode.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AcWing_422 {
    static int l, m;

    static class Pair {
        int left, right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        m = sc.nextInt();
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int ll = sc.nextInt();
            int rr = sc.nextInt();
            pairs.add(new Pair(ll, rr));
        }
        pairs = pairs.stream()
                .sorted(Comparator.comparingInt(a -> a.left))
                .collect(Collectors.toList());
        int L = pairs.get(0).left;
        int R = pairs.get(0).right;
        int sum = 0;
        for (Pair pair : pairs) {
            if (pair.left <= R) { // or ignore the second condition
                R = Math.max(R, pair.right);
            } else {
                sum += R - L + 1;

                L = pair.left;
                R = pair.right;
            }
        }
        sum += R - L + 1;
        System.out.println(l - sum + 1);
    }
}
