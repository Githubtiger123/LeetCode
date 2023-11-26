package com.enumeration.java;

import org.junit.Test;

//343. 整数拆分
public class L343 {

    @Test
    public void test() {

        for (int i = 1; i < 20; i++) {
            System.out.println("i:" + i + ",result=" + integerBreak(i));
        }
    }

    public static int integerBreak(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {

            dp[i] = 0;
            for (int j = 1; j <= i/2; j++) {
                int t = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], t);
            }
        }
        return dp[n];
    }
}
