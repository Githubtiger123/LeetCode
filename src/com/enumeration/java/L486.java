package com.enumeration.java;

import org.junit.Test;

//486. 预测赢家
public class L486 {

    @Test
    public void test() {

        System.out.println(predictTheWinner(new int[]{1}));
    }

    //方式一:通过递归(速度较慢)
//    public boolean predictTheWinner(int[] nums) {
//
//        return f(0, nums.length - 1, nums) >= g(0, nums.length - 1, nums);
//    }
//
//    public int f(int L, int R, int[] nums) {
//
//        if (L == R) {
//            return nums[L];
//        }
//        return Math.max(nums[L] + g(L + 1, R, nums), nums[R] + g(L, R - 1, nums));
//    }
//
//    public int g(int L, int R, int[] nums) {
//
//        if (L == R) {
//            return 0;
//        }
//        return Math.min(f(L + 1, R, nums), f(L, R - 1, nums));
//    }

    //方法二:记忆化搜索
//    public boolean predictTheWinner(int[] nums) {
//
//        int n = nums.length;
//        int[][] dp_f = new int[n][n];
//        int[][] dp_g = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                dp_f[i][j] = dp_g[i][j] = -1;
//            }
//        }
//        return f(0, nums.length - 1, nums, dp_f, dp_g) >= g(0, nums.length - 1, nums, dp_f, dp_g);
//    }
//
//    public int f(int L, int R, int[] nums, int[][] dp_f, int[][] dp_g) {
//
//        if (dp_f[L][R] != -1) {
//            return dp_f[L][R];
//        }
//        int ans = 0;
//        if (L == R) {
//            ans = nums[L];
//        } else {
//
//            ans = Math.max(nums[L] + g(L + 1, R, nums, dp_f, dp_g), nums[R] + g(L, R - 1, nums, dp_f, dp_g));
//        }
//        dp_f[L][R] = ans;
//        return ans;
//    }
//
//    public int g(int L, int R, int[] nums, int[][] dp_f, int[][] dp_g) {
//
//        if (dp_g[L][R] != -1) {
//            return dp_g[L][R];
//        }
//        int ans = 0;
//        if (L == R) {
//            ans = 0;
//        } else {
//
//            ans = Math.min(f(L + 1, R, nums, dp_f, dp_g), f(L, R - 1, nums, dp_f, dp_g));
//        }
//        dp_g[L][R] = ans;
//        return ans;
//    }

    //方法三:动态规划
    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        int[][] dp_f = new int[n][n];
        int[][] dp_g = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp_f[i][i] = nums[i];
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
////                dp_f[i][j] = Math.max(nums[i] + dp_g[i + 1][j], nums[j] + dp_g[i][j - 1]);
////                dp_g[i][j] = Math.min(nums[i] + dp_f[i + 1][j], nums[j] + dp_f[i][j - 1]);
//            }
//        }
        for (int i = 1; i < n; i++) {
            int R = i, L = 0;
            while (R < n) {
                dp_f[L][R] = Math.max(nums[L] + dp_g[L + 1][R], nums[R] + dp_g[L][R - 1]);
                dp_g[L][R] = Math.min(dp_f[L + 1][R], dp_f[L][R - 1]);
                R++;
                L++;
            }
        }
        return dp_f[0][n - 1] >= dp_g[0][n - 1];
    }

}
