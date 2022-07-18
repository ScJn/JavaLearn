package leetcode.bfs;

import java.util.*;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, situations that this interface is called, etc.]
 *
 * @author shikamaru
 * @see [String]
 * @see [Document URL]
 * @see [Class name#method name]
 * @since 2022/7/16 4:44 下午
 * <p>
 * Copyright 2020 (C) <Alibaba Global>
 */
public class Coins {

    public static void main(String[] args) {
        int i = new Coins().coinChange2(new int[]{2}, 3);
        System.out.println(i);
    }

    public int coinChange2(int[] coins, int amount) {

        int n = coins.length;
        int[] dp = new int[amount+4];

        //base
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount ; i++) {

            for (int j = 0; j < n; j++) {
                if (i - coins[j] >= 0 && dp[i- coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i- coins[j]] + 1, dp[i]);
                }

            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {

        if (coins.length == 0) return -1;
        if (amount == 0) return 0;

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(amount);
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Integer poll = q.poll();
                if (poll == 0) {
                    return depth;
                } else if (poll < 0) {
                    continue;
                }

                for (int coin : coins) {
                    int next = poll - coin;
                    if (set.contains(next)) {
                        continue;
                    }
                    q.add(next);
                    set.add(next);
                }
            }
            depth ++;
        }
        return -1;
    }

}
