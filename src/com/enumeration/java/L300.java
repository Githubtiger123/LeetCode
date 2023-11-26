package com.enumeration.java;

import org.junit.Test;

//300. 最长递增子序列
public class L300 {

    @Test
    public void test() {

        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    //不对
//    public int lengthOfLIS(int[] nums) {
//
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = 1;
//        for (int i = 1; i < n; i++) {
//            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : dp[i - 1];
//        }
//        return dp[n-1];
//    }

    //此写法也不太行
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = 1;
//        int result = -1;
//        for (int i = 1; i < n; i++) {
//            int max = -1;
//            for (int j = 1; j <= i; j++) {
//                if (nums[i] > nums[j]) {
//                    max = Math.max(dp[j] + 1, max);
//                }
//            }
//            dp[i] = Math.max(max, dp[i - 1]);
//            result = Math.max(result,dp[i]);
//        }
//        return result;
//    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int result = -1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
