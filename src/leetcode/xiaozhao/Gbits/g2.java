package leetcode.xiaozhao.Gbits;

import java.util.Scanner;

public class g2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<2018){
            System.out.println(0);
            return;

        }
        if(n<20018){
            System.out.println(1);
            return;
        }

        int b = 0;
        while(n>0){
            n/=10;
            b++;
        }
        int ans = c((b-4),b-1)*10000+c(b-5,b-1)*1000*9;
        System.out.println(ans);
    }

    static int c(int x,int y){
        int ans=1;
        for(int i=0;i<x;i++){
            ans*=y--;

        }
        return ans;
    }
}
