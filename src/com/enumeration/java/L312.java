package com.enumeration.java;

import org.junit.Test;

//312. 戳气球
public class L312 {

    @Test
    public void test() {
        System.out.println(maxCoins(new int[]{1, 5, 1}));
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }


    public int maxCoins(int[] nums) {

        return dfs(nums, 0, nums.length - 1);
    }

    public int dfs(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        if (left > right) {
            return 0;
        } else if (left == right) {
            return nums[left];
        } else {
            int l = left - 2 < 0 ? 1 : nums[left - 2];
            int r = right + 2 > nums.length - 1 ? 1 : nums[right + 2];

            for (int i = left; i <= right; i++) {
                if (i == left) {
                    max = Math.max(max, l * nums[i] * nums[i + 1] + dfs(nums, left, i - 1) + dfs(nums, i + 1, right));
                } else if (i == right) {
                    max = Math.max(max, r * nums[i] * nums[i - 1] + dfs(nums, left, i - 1) + dfs(nums, i + 1, right));
                } else {
                    max = Math.max(max, nums[i - 1] * nums[i] * nums[i + 1] + dfs(nums, left, i - 1) + dfs(nums, i + 1, right));
                }
            }
        }
        return max;
    }
}
