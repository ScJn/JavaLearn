package leetcode.xiaozhao.tencent;

import java.util.Scanner;

public class Tencent06 {

    static int parentDay;
    static int cookie;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        parentDay = n;
        cookie = m;
        int r = m;
        int l = 0;
        int mid=0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (check(mid)) l = mid + 1;
            else r = mid;
        }
        System.out.println(l-1);
    }

    static boolean check(int num) {

        int tempCookie = cookie;
        for (int i = 1; i <= parentDay; i++) {
            tempCookie -= num;
            num = num % 2 == 0 ? num / 2 : num / 2 + 1;
            if (tempCookie < 0) return false;
        }
        return true;
    }
}
