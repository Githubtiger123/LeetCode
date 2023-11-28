package com.enumeration.java;

import org.junit.Test;

//53. 最大子数组和
public class L53 {


    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{1, 1, 1, 1, 1}));
    }

//    public int maxSubArray(int[] nums) {
//
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        int ans = dp[0];
//        for (int i = 1; i < n; i++) {
////            if (nums[i] > nums[i - 1]) {
////                dp[i] = dp[i - 1] + nums[i];
////            } else {
////                dp[i] = nums[i];
////            }
//
//            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
//            ans = Math.max(ans, dp[i]);
//        }
//        return ans;
//    }


    //空间O(1)
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int a = nums[0], b;
        int ans = a;
        for (int i = 1; i < n; i++) {
//            if (nums[i] > nums[i - 1]) {
//                dp[i] = dp[i - 1] + nums[i];
//            } else {
//                dp[i] = nums[i];
//            }

            b = Math.max(a + nums[i], nums[i]);
            ans = Math.max(ans, b);
            a = b;
        }
        return ans;
    }
}
