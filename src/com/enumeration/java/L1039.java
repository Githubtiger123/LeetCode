package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//1039. 多边形三角剖分的最低得分
public class L1039 {

    @Test
    public void test() {

        System.out.println(minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}));
        System.out.println(minScoreTriangulation(new int[]{1, 2, 3}));
        System.out.println(minScoreTriangulation(new int[]{26, 35, 78, 22, 14, 62, 30, 21, 86, 7, 70, 67, 8, 28, 61, 33, 3, 78, 18, 71}));
    }

    //方法三:动态规划
    public int minScoreTriangulation(int[] values) {

        int n = values.length;
        int[][] dp = new int[n][n];
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {

                int min = Integer.MAX_VALUE;
                for (int k = l + 1; k < r; k++) {
                    min = Math.min(min, values[l] * values[r] * values[k] + dp[l][k] + dp[k][r]);
                }
                dp[l][r] = min;
            }
        }
        return dp[0][n - 1];
    }

    //方法二:记忆化搜索
    public int minScoreTriangulation1(int[] values) {

        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(values, 0, values.length - 1, dp);
    }

    public int dfs(int[] values, int left, int right, int[][] dp) {

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int ans, min = 0;
        if (left + 1 == right) {
            ans = 0;
        } else {

            min = Integer.MAX_VALUE;
            for (int i = left + 1; i < right; i++) {
                min = Math.min(min, values[left] * values[right] * values[i] + dfs(values, left, i, dp) + dfs(values, i, right, dp));
            }

        }
        ans = min;
        dp[left][right] = ans;
        return ans;
    }

    //方法一:暴力递归(时间超限)
//    public int minScoreTriangulation(int[] values) {
//
//        return dfs(values, 0, values.length - 1);
//    }
//
//    public int dfs(int[] values, int left, int right) {
//
//        if (left + 1 == right) {
//            return 0;
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int i = left + 1; i < right; i++) {
//            min = Math.min(min, values[left] * values[right] * values[i] + dfs(values, left, i) + dfs(values, i, right));
//        }
//        return min;
//    }
}
