package leetcode.dp;

import java.util.Arrays;
import java.util.LinkedList;

public class Stock_188 {

    public int maxProfit(int k, int[] prices) {
        if(k==0 || prices.length <=1)return 0;
        int n = prices.length;

        k = Math.min(n,k);
        int[] buys = new int[k];
        int[] sells = new int[k];
        Arrays.fill(buys,Integer.MAX_VALUE);

        for(int p : prices){

            for(int i = 0; i < k; i++){
                buys[i] = Math.min(buys[i], p - (i==0?0:sells[i-1]));
                sells[i] = Math.max(sells[i], p-buys[i]);
            }
        }
        return sells[k-1];
    }

}
