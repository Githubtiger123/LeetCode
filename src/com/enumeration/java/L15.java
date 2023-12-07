package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 三数之和
public class L15 {

    @Test
    public void test() {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println();
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int sum = -nums[i];
            int start = i, end = nums.length - 2;
            while (start < end) {
                if (nums[start] + nums[end] > sum) {
                    end--;
                } else if (nums[start] + nums[end] < sum) {
                    start++;
                } else {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[start]);
                    path.add(nums[end]);
                    result.add(path);
                }
            }
        }
        return result;
    }
}
