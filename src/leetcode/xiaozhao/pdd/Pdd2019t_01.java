package leetcode.xiaozhao.pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pdd2019t_01 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i]=in.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i]*b[n-1-i];
        }
        System.out.println(sum);

    }
}


