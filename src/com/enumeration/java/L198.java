package com.enumeration.java;

import org.junit.Test;

//198. 打家劫舍
public class L198 {

    @Test
    public void test() {

        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }

//    public int rob(int[] nums) {
//
//        int n = nums.length;
//        if (n == 1) return nums[0];
//        int[] dp = new int[n];
//        dp[0] = nums[0];
////        dp[1] = nums[1];  不对，要特殊处理
//        dp[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < n; i++) {
//
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//        }
//
//        return dp[n - 1];
//    }


    //优化空间为O(1)
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];
        int a, b, c = 0;
        a = nums[0];
        b = Math.max(nums[0], nums[1]);
        if (n == 2) return b;
        for (int i = 2; i < n; i++) {
            c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return c;
    }
}
