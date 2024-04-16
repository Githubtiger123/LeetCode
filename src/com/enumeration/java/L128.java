package com.enumeration.java;

import org.junit.Test;

import java.util.HashSet;

//128. 最长连续序列
public class L128 {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();
        int max_num = Integer.MIN_VALUE;
        int min_num = Integer.MAX_VALUE;
        int max_len = 0, t = 0;
        for (int i = 0; i < nums.length; i++) {
            max_num = Math.max(max_num, nums[i]);
            min_num = Math.min(min_num, nums[i]);
            hashSet.add(nums[i]);
        }
        for (int i = min_num; i <= max_num; i++) {

            if (hashSet.contains(i)) {
                t++;
            } else {
                t = 0;
            }
            max_len = Math.max(max_len, t);
        }
        return max_len;
    }

    @Test
    public void test() {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive(new int[]{0, 1, 2, 4, 8, 5, 6, 7, 9, 3, 55, 88, 77, 99, 999999999}));
    }
}
