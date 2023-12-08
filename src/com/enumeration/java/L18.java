package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//18. 四数之和
public class L18 {

    @Test
    public void test() {

        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
//        long s = (long) 1000000000+1000000000+1000000000+1000000000;
//        System.out.println(s);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = second + 1;
                int fourth = nums.length - 1;
                while (third < fourth) {

                    long sum = (long) nums[first] + nums[second] + nums[third] + nums[fourth];
//                    System.out.println(sum);
                    if (sum > target) {
                        fourth--;
                    } else if (sum < target) {
                        third++;
                    } else {
                        result.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        while (third < fourth && nums[fourth] == nums[fourth - 1]) fourth--;
                        while (third < fourth && nums[third] == nums[third + 1]) third++;
                        fourth--;
                        third++;
                    }
                }
            }
        }
        return result;
    }
}
