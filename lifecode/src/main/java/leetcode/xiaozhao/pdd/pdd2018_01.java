package leetcode.xiaozhao.pdd;

import java.util.Scanner;

public class pdd2018_01 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        int off = in.nextInt();
        int n = in.nextInt();
        int l1 = in.nextInt();
        int l2 = in.nextInt();

        int b1 = 0, e1 = 0, b2 = 0, e2 = 0;
        if (off >= l1) {
            b1 = l1;
            e1 = l1;
            b2 = off - l1;
            if(b2>l2){
                b2=l2;
                e2=l2;
            }
            else e2 = b2 + n > l2 ? l2 : b2 + n;

        } else {
            if (n + off >= l1) {
                b1 = off;
                e1 = l1;
                b2 = 0;
                e2 = (n - (l1 - off))>l2?l2:(n - (l1 - off));
            } else {
                b1 = off;
                e1 = off + n;
                b2 = 0;
                e2 = 0;
            }
        }
        System.out.println(b1 + " " + e1 + " " + b2 + " " + e2);
    }

}
