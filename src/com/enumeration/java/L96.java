package com.enumeration.java;

import org.junit.Test;

public class L96 {

    @Test
    public void test() {

        System.out.println(numTrees(19));
    }

    public static int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
