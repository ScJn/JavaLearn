package leetcode.xiaozhao.byteDance;

import java.util.Scanner;

public class B3 {


    static int n;
    static  int[] h;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        h= new int[n+1];
        h[0]=0;
        int ans = 0;
        int sum = 0;
        for(int i=1;i<=n;i++){
            h[i]=in.nextInt();
            sum+=h[i];
        }

        int left = 0;
        int right = sum;

        while(left<=right){
            int mid = (left+right)>>1;

            if(check(mid))right=mid-1;
            else left=mid+1;
        }
        System.out.println(left);

    }
    static boolean check(int power){

        for(int i=1;i<=n;i++){
            if(power<h[i]){
                power-=(h[i]-power);
            }else {
                power+=(power-h[i]);
            }
            if(power<0)return false;
        }
        return true;
    }
}
