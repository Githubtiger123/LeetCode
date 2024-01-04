package com.enumeration.java;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.PriorityQueue;

//581. 最短无序连续子数组
public class L581 {

    @Test
    public void test() {

//        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 4, 5}));
    }

    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length, count = 0, left = 0, right = n - 1;
        boolean[] isAns = new boolean[n];
        Arrays.fill(isAns, true);
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                isAns[i] = false;
            }
        }
        int min = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                isAns[i] = false;
            }
        }
        while (right > 0 && isAns[right]) right--;
        while (left < n && isAns[left]) left++;
        return right - left + 1 < 0 ? 0 : right - left + 1;
    }

//    public int findUnsortedSubarray(int[] nums) {
//
//        PriorityQueue<Integer> queue_small = new PriorityQueue<>((a, b) -> (a - b));
//        PriorityQueue<Integer> queue_big = new PriorityQueue<>((a, b) -> -(a - b));
//        int right = 0;
//        int left = nums.length;
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            queue_small.add(nums[i]);
//            queue_big.add(nums[i]);
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (!queue_small.isEmpty() && queue_small.peek() != nums[i]) {
//                left = i;
//                break;
//            }
//            queue_small.poll();
//        }
//        for (int i = n - 1; i >= 0; i--) {
//            if (!queue_big.isEmpty() && queue_big.peek() != nums[i]) {
//                right = i;
//                break;
//            }
//            queue_big.poll();
//        }
//        return right - left + 1 < 0 ? 0 : right - left + 1;
//    }
}
