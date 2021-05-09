package leetcode.xiaozhao.byteDance;

import java.util.Arrays;
import java.util.Scanner;

public class B5 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int m = in.nextInt();
            int m2 = m;
            int[] a = new int[m];
            for(int j=0;j<m;j++){
                a[j] = in.nextInt();
            }
            Arrays.sort(a);

            int sum=0;
            while(m2>=5){
                if(2*a[1]+a[m2-1]+a[m2-2]>2*a[2]+a[1]+a[m2-1]){
                    sum+=2*a[2]+a[1]+a[m2-1];
                }else
                    sum+=2*a[1]+a[m2-1]+a[m2-2];
                m2-=2;
            }
            if(m2==3){
                sum+=a[2];
            }else if(m2==4){
                sum+=(a[2]+a[3]+a[1]);
            }
            System.out.println(sum);
        }
    }
}
