package com.competition.java.C369;

import org.junit.Test;

import java.util.Arrays;

//2919. 使数组变美的最小增量运算数
public class L2919 {

    @Test
    public void test() {

        System.out.println(minIncrementOperations(new int[]{2, 3, 0, 0, 2}, 4));
        System.out.println(minIncrementOperations(new int[]{0, 1, 3, 3}, 5));
        System.out.println(minIncrementOperations(new int[]{1, 1, 2}, 2));
        System.out.println(minIncrementOperations(new int[]{4, 8, 20, 34, 21, 13, 45, 3, 42, 48, 49, 35, 48, 2, 11, 22, 33, 2, 32, 33, 50, 44, 40, 41, 27, 28, 46, 30, 43}, 86));
    }

    public long minIncrementOperations(int[] nums, int k) {

//        return dfs(nums, k, nums.length - 1, 0);


//        long[][] dp = new long[nums.length][3];
//        for (int i = 0; i < nums.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return dfs2(nums, k, nums.length - 1, 0, dp);

        //方法三:动态规划
        long[][] dp = new long[nums.length][3];
        dp[0][2] = Math.max(k - nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < 3; j++) {
                long ans = 0;
                if (j < 2) {
                    long ans1 = dp[i - 1][0] + Math.max(k - nums[i], 0);
                    long ans2 = dp[i - 1][j + 1];
                    ans = Math.min(ans1, ans2);
                } else {
                    ans = dp[i - 1][0] + Math.max(k - nums[i], 0);
                }
                dp[i][j] = ans;
            }
        }
        return dp[nums.length - 1][0];
    }


    //方法二:记忆化搜索(可以通过但是时间复杂度和空间复杂度不好)
    public long dfs2(int[] nums, int k, int i, int j, long[][] dp) {

        if (i < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        long ans = 0;
        if (j < 2) {
            long ans1 = dfs2(nums, k, i - 1, 0, dp) + Math.max(k - nums[i], 0);
            long ans2 = dfs2(nums, k, i - 1, j + 1, dp);
            ans = Math.min(ans1, ans2);
        } else {
            ans = dfs2(nums, k, i - 1, 0, dp) + Math.max(k - nums[i], 0);
        }
        dp[i][j] = ans;
        return ans;
    }

    //方法一:暴力递归(时间超限)
    public long dfs(int[] nums, int k, int i, int j) {
        long ans = 0;
        if (i < 0) {
            return 0;
        } else if (j < 2) {
            long ans1 = dfs(nums, k, i - 1, 0) + Math.max(k - nums[i], 0);
            long ans2 = dfs(nums, k, i - 1, j + 1);
            ans = Math.min(ans1, ans2);
        } else {
            ans = dfs(nums, k, i - 1, 0) + Math.max(k - nums[i], 0);
        }
        return ans;
    }

}
