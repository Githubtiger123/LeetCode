package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//213. 打家劫舍 II
public class L213 {

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];
        //copyOfRange左开右闭
//        Arrays.copyOf(nums, 10);复制原始数组的前n个元素到新数组
        return Math.max(rob1(Arrays.copyOfRange(nums, 0, n - 1)), rob1(Arrays.copyOfRange(nums, 1, n)));
    }

    public int rob1(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

    @Test
    public void test() {
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }
}
