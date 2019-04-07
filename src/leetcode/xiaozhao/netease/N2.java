package leetcode.xiaozhao.netease;

import java.util.Scanner;

public class N2 {

    public static void main(String[] args) {
        String input;
        Scanner in = new Scanner(System.in);
        input = in.next();
        String[] ab = input.split(",");
        String a = ab[0], b = ab[1];
        int[] cost = new int[a.length()];
        int[] A=new int[a.length()];
        int[] B = new int[b.length()];

        for(int i=0;i<cost.length;i++){
            A[i]=a.charAt(i)-'0';
            B[i] = b.charAt(i)-'0';
            cost[i] = Math.abs(A[i]-B[i]);

        }
        int ans = 0;
        for(int i=0;i<a.length();i++){
            if(A[i]==B[i])continue;
            int minCost = 30,minIndex=-1;
            for(int j=i+1;j<b.length();j++){
                int tempCost = 1+Math.abs(A[i]-B[j])+Math.abs(A[j]-B[i]);
                if(cost[i]+cost[j]>tempCost&&tempCost<minCost){
                    minCost=tempCost;
                    minIndex = j;
                }
            }
            if(minIndex!=-1){
                A[minIndex]=B[minIndex];
                A[i]=B[i];
                ans+=minCost;
            }
            else {
                A[i]=B[i];
                ans+=cost[i];
            }

        }
        System.out.println(ans);
    }
}
