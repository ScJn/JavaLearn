package leetcode.xiaozhao.kuaishou;

import java.util.Scanner;

public class kuaishou3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int bit = in.nextInt();
        int ans = -0;
        while(bit>0){
            ans += bit&1;
            bit>>=1;
        }
        System.out.println(ans);
    }
}
