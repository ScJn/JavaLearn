package leetcode.xiaozhao.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {

        int m,n;
        Scanner in =new Scanner(System.in);
        m=in.nextInt();
        n=in.nextInt();

        int[] money = new int[n];
        for(int i=0;i<n;i++){
            money[i]=in.nextInt();
        }
        int[] pack = new int[n];

        Arrays.sort(money);
        for(int i=1;i<m;i++){

            for(int j=0;j<n;j++){
                if(money[i]==i){
                    pack[i]+=1;
                }
            }
        }
    }

//    void dfs(int money)
}
