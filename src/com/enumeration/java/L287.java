package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//287. 寻找重复数
public class L287 {

    @Test
    public void test() {

        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

//    public int findDuplicate(int[] nums) {
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    return nums[i];
//                }
//            }
//        }
//        return 0;
//    }
}
