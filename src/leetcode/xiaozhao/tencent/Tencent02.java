package leetcode.xiaozhao.tencent;

import java.util.Scanner;

public class Tencent02 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] work = new int[32];
        while(true){
            int a=in.nextInt(),b = in.nextInt();
            work[a/32]= work[a/32]|(1<<(a%32-1));
            int done = work[b/32]&(1<<(b%32-1));
            if(done>= 1) System.out.println(1);
            else System.out.println(-1);

        }

    }
}
