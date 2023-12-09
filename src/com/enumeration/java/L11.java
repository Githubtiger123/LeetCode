package com.enumeration.java;

import org.junit.Test;

//11. 盛最多水的容器
public class L11 {

    @Test
    public void test() {

        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int s = 0;

        while (left < right) {

            s = Math.max(s, (right - left) * (Math.min(height[right], height[left])));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return s;
    }
}