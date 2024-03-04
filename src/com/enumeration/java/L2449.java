package com.enumeration.java;

import java.util.Arrays;

//2449. 使数组相似的最少操作次数
public class L2449 {

//    public long makeSimilar(int[] nums, int[] target) {
//
//        long res = 0;
//        nums = format_array(nums);
//        target = format_array(target);
//        int index = 0;
//        while (index < target.length) {
//
//            res += Math.abs(nums[index] - target[index]);
//            index++;
//        }
//        return res / 4;
//    }
//
//    private int[] format_array(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//        Arrays.sort(nums);
//        int index = 0;
//        for (int i = 0; i < n; i++) {
//
//            if (nums[i] % 2 == 1) {
//                res[index++] = nums[i];
//            }
//        }
//        index = n - 1;
//        for (int i = n - 1; i >= 0; i--) {
//
//            if (nums[i] % 2 == 0) {
//                res[index--] = nums[i];
//            }
//        }
//        return res;
//    }

    public long makeSimilar(int[] nums, int[] target) {

        int n = nums.length;
        int a = split(nums);
        int b = split(target);
        Arrays.sort(nums, 0, a);//左闭右开
        Arrays.sort(nums, a, n);
        Arrays.sort(target, 0, b);
        Arrays.sort(target, b, n);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(nums[i] - target[i]);
        }

        return res / 4;
    }

    private int split(int[] nums) {

        int oddSize = 0;
        for (int i = 0; i < nums.length; i++) {

            if ((nums[i] & 1) == 1) {
                int temp = nums[i];
                nums[i] = nums[oddSize];
                nums[oddSize] = temp;
                oddSize++;
            }
        }
        return oddSize;
    }
}
