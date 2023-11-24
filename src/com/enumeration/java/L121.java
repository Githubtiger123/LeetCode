package com.enumeration.java;

import org.junit.Test;

//121. 买卖股票的最佳时机
public class L121 {

    @Test
    public void test() {

        System.out.println(maxProfit(new int[]{7,7,7,7,7,7}));
    }

    public static int maxProfit(int[] prices) {


        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

}
