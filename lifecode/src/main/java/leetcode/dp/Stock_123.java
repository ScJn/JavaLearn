package leetcode.dp;

public class Stock_123 {


    // 暴力算法， 枚举中间位置，2边分别跑一次算一次最大值的
    public static int maxProfit(int[] prices) {

        int res = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {


            int lm = prices[0];
            int rm = prices[i];
            int res1 = 0;
            for (int j = 0; j <= i; j++) {

                lm = Math.min(lm, prices[j]);
                res1 = Math.max(res1, prices[j] - lm);
            }

            int res2 = 0;
            for (int k = i; k < n; k++) {
                rm = Math.min(rm, prices[k]);
                res2 = Math.max(res2, prices[k] - rm);
            }

            res = Math.max(res, res1 + res2);
        }

        return res;

    }

    /**
     * 这个算法太高级了，贪心思想，第一次好理解，第二次就算已最低价买入，尽量卖出最大差价，因为是顺序买卖，所以能保证正确性
     * 再每一次都会重新算第一次卖的最多
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices){

        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;
        for(int pri:prices){
            buy1 = Math.min(buy1, pri);
            sell1 = Math.max(sell1, pri - buy1);
            buy2 = Math.min(buy2, pri - sell1);
            sell2 = Math.max(sell2, pri - buy2);
        }
        return sell2;

    }

    public static void main(String[] args) {
        int a=maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(a);
    }
}
