package leetcode.xiaozhao.tencent;

import java.util.Scanner;

public class Tencent04 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long sum = 0;
        long n = in.nextInt(),m=in.nextInt();
        for(long i=1;i<=2*m;i++){
            sum +=(((i-1)/m)%2==0?-i:i);

        }
        System.out.println(sum*(n/2/m));

    }
}
