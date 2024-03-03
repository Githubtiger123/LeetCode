package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

//1675. 数组的最小偏移量
public class L1675 {

    public int minimumDeviation(int[] nums) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {

            if (nums[i] % 2 == 1) {
                nums[i] = nums[i] * 2;
            }
            min = Math.min(min, nums[i]);
            queue.add(nums[i]);
        }

        while (res > 0 && queue.peek() % 2 == 0) {

            int num = queue.poll();
            queue.add(num / 2);
            min = Math.min(min, num / 2);
            res = Math.min(res, queue.peek() - min);
        }

        return res;
    }

    @Test
    public void test() {

        System.out.println(minimumDeviation(new int[]{399, 908, 648, 357, 693, 502, 331, 649, 596, 698}));
    }

}
