package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//1547. 切棍子的最小成本
public class L1547 {


    @Test
    public void test() {

        System.out.println(minCost(9, new int[]{5, 6, 1, 4, 2}));
        System.out.println(minCost(7, new int[]{1, 3, 4, 5}));
        System.out.println(minCost(7, new int[]{4}));
        System.out.println(minCost(8100, new int[]{2101, 3454, 6088, 5298, 4727, 6791, 5538, 305, 3628, 841, 6007, 7913, 1621, 1436, 4022, 908, 7217, 1099, 1169, 1787, 383, 7367, 8046, 2888, 5465, 6669, 1660, 2856, 6771, 4263, 1782, 6833, 448, 2792, 1104, 2342, 1100, 4378, 252, 2806, 5104, 1513, 6115, 388, 4555, 276, 5214, 5934, 5749, 7660, 4590, 3885, 1052, 4876, 4144, 4489, 3945, 2823, 364, 1324, 4227, 3764}));
        System.out.println(minCost(30, new int[]{13, 25, 16, 20, 26, 5, 27, 8, 23, 14, 6, 15, 21, 24, 29, 1, 19, 9, 3}));
    }

    //方法三:动态规划
    public int minCost(int n, int[] cuts) {

        int new_n = cuts.length + 2;
        int[] cuts1 = new int[new_n];
        cuts1[0] = 0;
        cuts1[cuts1.length - 1] = n;
        Arrays.sort(cuts);
        for (int i = 0; i < cuts.length; i++) {
            cuts1[i + 1] = cuts[i];
        }
        int[][] dp = new int[new_n][new_n];

        for (int i = 1; i < new_n - 1; i++) {
            int len = cuts1[i + 1] - (cuts1[i - 1]);
            dp[i][i] = len;
        }

        for (int i = new_n - 3; i >= 1; i--) {
            for (int j = i + 1; j < new_n - 1; j++) {
                int ans = 0;
                int len = cuts1[j + 1] - (cuts1[i - 1]);
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    min = Math.min(min, len + dp[i][k - 1] + dp[k + 1][j]);
                }
                ans = min;
                dp[i][j] = ans;
            }
        }
        return dp[1][new_n - 2];
    }


    //方法二:记忆化搜索
    public int minCost1(int n, int[] cuts) {

        int[] cuts1 = new int[cuts.length + 2];
        cuts1[0] = 0;
        cuts1[cuts1.length - 1] = n;
        Arrays.sort(cuts);

        for (int i = 0; i < cuts.length; i++) {
            cuts1[i + 1] = cuts[i];
        }

        int[][] dp = new int[cuts1.length][cuts1.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(cuts1, 1, cuts1.length - 2, dp);
    }

    public int dfs(int[] cuts, int left, int right, int[][] dp) {

        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int ans = 0;
        int len = cuts[right + 1] - (cuts[left - 1]);
        if (left > right) {
            ans = 0;
        } else if (left == right) {
            ans = len;
        } else {

            int min = Integer.MAX_VALUE;
            for (int k = left; k <= right; k++) {
                min = Math.min(min, len + dfs(cuts, left, k - 1, dp) + dfs(cuts, k + 1, right, dp));
            }
            ans = min;
        }
        dp[left][right] = ans;
        return ans;
    }


    //方法一:正确的暴力递归
//    public int minCost(int n, int[] cuts) {
//
//        int[] cuts1 = new int[cuts.length + 2];
//        cuts1[0] = 0;
//        cuts1[cuts1.length - 1] = n;
//        Arrays.sort(cuts);
//        for (int i = 0; i < cuts.length; i++) {
//            cuts1[i + 1] = cuts[i];
//        }
//        System.out.println(Arrays.toString(cuts1));
//        return dfs(cuts1, 1, cuts1.length - 2);
//    }
//
//    public int dfs(int[] cuts, int left, int right) {
//
//
//        int len = cuts[right + 1] - (cuts[left - 1]);
//        if (left > right) {
//            return 0;
//        } else if (left == right) {
//            return len;
//        }
//        int min = Integer.MAX_VALUE;
//
//        for (int k = left; k <= right; k++) {
//            min = Math.min(min, len + dfs(cuts, left, k - 1) + dfs(cuts, k + 1, right));
//        }
//        return min;
//    }


    //方法二:记忆化搜索(内存超出限制)(同样不是正解)
//    public int minCost1(int n, int[] cuts) {
//
//        int[][] dp = new int[n + 1][n + 1];
//        for (int i = 0; i <= n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        Arrays.sort(cuts);
//        return dfs(cuts, 0, n, dp);
//    }
//
//    public int dfs(int[] cuts, int left, int right, int[][] dp) {
//
//        if (dp[left][right] != -1) {
//            return dp[left][right];
//        }
//        int ans = 0;
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < cuts.length; i++) {
//            if (cuts[i] > left && cuts[i] < right) {
//                min = Math.min(min, right - left + dfs(cuts, left, cuts[i], dp) + dfs(cuts, cuts[i], right, dp));
//            }
//        }
//        ans = min == Integer.MAX_VALUE ? 0 : min;
//        dp[left][right] = ans;
//        return ans;
//    }

    //方法一:暴力递归(时间超出限制)(不正确)
//    public int minCost(int n, int[] cuts) {
//
//        Arrays.sort(cuts);
//        return dfs(cuts, 0, n);
//    }
//    public int dfs(int[] cuts, int left, int right) {
//
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < cuts.length; i++) {
//            if (cuts[i] > left && cuts[i] < right) {
//                min = Math.min(min, right - left + dfs(cuts, left, cuts[i]) + dfs(cuts, cuts[i], right));
//            }
//        }
//        return min == Integer.MAX_VALUE ? 0 : min;
//    }

}
