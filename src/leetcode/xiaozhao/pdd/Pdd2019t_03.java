package leetcode.xiaozhao.pdd;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Pdd2019t_03 {

    public static void main(String[] args) {

        class bank {
            int x;
            int money;

            public bank(int x, int money) {
                this.x = x;
                this.money = money;
            }
        }
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int d = in.nextInt();

        bank[] banks = new bank[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int money = in.nextInt();
            banks[i] = new bank(x, money);
        }

        Arrays.sort(banks, (o1, o2) -> o1.x - o2.x);

        int res = -1;
        for (int i = 0; i < n; i++) {
            int begin = banks[i].x;
            if (banks[n - 1].x - begin < d) break;
            for (int j = n - 1; j > i; j--) {
                if (banks[j].x - begin >= d) res = Math.max(res, banks[i].money + banks[j].money);
                else break;
            }
        }
        System.out.println(res);
    }
}
