package leetcode.xiaozhao.Gbits;

import java.util.Scanner;

public class g1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int[] a =new int[n];
        int cur=0,ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
            cur+=a[i];
            if(cur>0){
                ans = Math.min(ans,cur);
                cur=0;
            }
            ans = Math.min(ans,cur);

        }

        System.out.println(ans);
    }
}
