package leetcode.xiaozhao.tencent;

import javafx.util.Pair;

import java.util.Scanner;

public class T3 {

    static long[] wu,money;
    static long ans = Long.MAX_VALUE;
    static int n;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        wu = new long[n];
        money = new long[n];

        for (int i = 0; i < n; i++) {
            wu[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            money[i] = in.nextInt();
        }

        dfs(0,0,0);
        System.out.println(ans);
    }
    static void dfs(long curMoney,long curWu,int index){
        for(int i=index;i<n;i++){
            if(wu[i]>curWu){
                curMoney+=money[i];
                curWu+=wu[i];
            }else {
                dfs(curMoney+money[i],curWu+wu[i],i+1);
            }
        }
        ans=Math.min(ans,curMoney);
    }
}
