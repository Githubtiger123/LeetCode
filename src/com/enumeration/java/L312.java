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

        int[] used = new int[nums.length];
        return dfs(nums, 0, nums.length - 1, used);
    }

    public int dfs(int[] nums, int left, int right, int[] used) {
        int max = Integer.MIN_VALUE;
        if (left > right) {
            return 0;
        } else if (left == right) {
            return nums[left];
        } else {

            int l = 1;
            int r = 1;

            for (int i = left - 1; i >= 0; i--) {
                if (used[i] != -1) {
                    l = nums[i];
                    break;
                }
            }
            for (int i = right + 1; i < nums.length; i++) {
                if (used[i] != -1) {
                    r = nums[i];
                    break;
                }
            }

            for (int i = left; i <= right; i++) {
                used[i] = -1;
                if (i == left) {
                    max = Math.max(max, l * nums[i] * nums[i + 1] + dfs(nums, i + 1, right, used));
                } else if (i == right) {
                    max = Math.max(max, r * nums[i] * nums[i - 1] + dfs(nums, left, i - 1, used));
                } else {
                    max = Math.max(max, nums[i - 1] * nums[i] * nums[i + 1] + dfs(nums, left, i - 1, used) + dfs(nums, i + 1, right, used));
                }
                used[i] = 0;
            }
        }
        return max;
    }
}
