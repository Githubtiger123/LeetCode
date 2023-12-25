package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//312. 戳气球
public class L312 {

    @Test
    public void test() {
        System.out.println(maxCoins(new int[]{1, 5, 1}));
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
        System.out.println(maxCoins(new int[]{8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5, 5}));
    }

    //方法三:动态规划
    public int maxCoins(int[] nums) {

        int n = nums.length + 2;
        int[] new_nums = new int[n];
        new_nums[0] = 1;
        new_nums[n - 1] = 1;
        for (int i = 0; i < n - 2; i++) {
            new_nums[i + 1] = nums[i];
        }
        int[][] dp = new int[n][n];
        for (int i = 1; i < n - 1; i++) {
            dp[i][i] = new_nums[i - 1] * new_nums[i] * new_nums[i + 1];
        }

        for (int left = n - 3; left >= 1; left--) {
            for (int right = left; right < n - 1; right++) {
                int ans;
                ans = Math.max(new_nums[left - 1] * new_nums[left] * new_nums[right + 1] + dp[left + 1][right], new_nums[right] * new_nums[left - 1] * new_nums[right + 1] + dp[left][right - 1]);

                for (int i = left + 1; i <= right - 1; i++) {
                    ans = Math.max(ans, new_nums[left - 1] * new_nums[i] * new_nums[right + 1] + dp[i + 1][right] + dp[left][i - 1]);
                }
                dp[left][right] = ans;
            }
        }

        return dp[1][n - 2];
    }


    //方法二:记忆化搜索
    public int maxCoins1(int[] nums) {

        int n = nums.length + 2;
        int[] new_nums = new int[n];
        new_nums[0] = 1;
        new_nums[n - 1] = 1;
        for (int i = 0; i < n - 2; i++) {
            new_nums[i + 1] = nums[i];
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(new_nums, 1, n - 2, dp);
    }

    public int dfs(int[] nums, int left, int right, int[][] dp) {

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int ans;
        if (left == right) {
            ans = nums[left - 1] * nums[left] * nums[right + 1];
        } else {
            ans = Math.max(nums[left - 1] * nums[left] * nums[right + 1] + dfs(nums, left + 1, right, dp), nums[right] * nums[left - 1] * nums[right + 1] + dfs(nums, left, right - 1, dp));

            for (int i = left + 1; i <= right - 1; i++) {
                ans = Math.max(ans, nums[left - 1] * nums[i] * nums[right + 1] + dfs(nums, i + 1, right, dp) + dfs(nums, left, i - 1, dp));
            }
        }
        dp[left][right] = ans;
        return ans;
    }


    //方法一:暴力递归
//    public int maxCoins(int[] nums) {
//
//        int n = nums.length + 2;
//        int[] new_nums = new int[n];
//        new_nums[0] = 1;
//        new_nums[n - 1] = 1;
//        for (int i = 0; i < n - 2; i++) {
//            new_nums[i + 1] = nums[i];
//        }
//        return dfs(new_nums, 1, n - 2);
//    }
//
//    public int dfs(int[] nums, int left, int right) {
//
//        if (left == right) {
//            return nums[left - 1] * nums[left] * nums[right + 1];
//        } else {
//            int max = Math.max(nums[left - 1] * nums[left] * nums[right + 1] + dfs(nums, left + 1, right), nums[right] * nums[left - 1] * nums[right + 1] + dfs(nums, left, right - 1));
//
//            for (int i = left + 1; i <= right - 1; i++) {
//                max = Math.max(max, nums[left - 1] * nums[i] * nums[right + 1] + dfs(nums, i + 1, right) + dfs(nums, left, i - 1));
//            }
//            return max;
//        }
//    }

    //自己写的(不对,回溯思路)
//    public int maxCoins(int[] nums) {
//
//        int[] used = new int[nums.length];
//        return dfs(nums, 0, nums.length - 1, used);
//    }
//
//    public int dfs(int[] nums, int left, int right, int[] used) {
//        int max = Integer.MIN_VALUE;
//        if (left > right) {
//            return 0;
//        } else if (left == right) {
//            return nums[left];
//        } else {
//
//            int l = 1;
//            int r = 1;
//
//            for (int i = left - 1; i >= 0; i--) {
//                if (used[i] != -1) {
//                    l = nums[i];
//                    break;
//                }
//            }
//            for (int i = right + 1; i < nums.length; i++) {
//                if (used[i] != -1) {
//                    r = nums[i];
//                    break;
//                }
//            }
//
//            for (int i = left; i <= right; i++) {
//                used[i] = -1;
//                if (i == left) {
//                    max = Math.max(max, l * nums[i] * nums[i + 1] + dfs(nums, i + 1, right, used));
//                } else if (i == right) {
//                    max = Math.max(max, r * nums[i] * nums[i - 1] + dfs(nums, left, i - 1, used));
//                } else {
//                    max = Math.max(max, nums[i - 1] * nums[i] * nums[i + 1] + dfs(nums, left, i - 1, used) + dfs(nums, i + 1, right, used));
//                }
//                used[i] = 0;
//            }
//        }
//        return max;
//    }
}
