package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//977. 有序数组的平方
public class L977 {

    @Test
    public void test() {

        int[] ints = sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(ints));
    }

    //暴力解法
//    public static int[] sortedSquares(int[] nums) {
//
//        int n = nums.length;
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = nums[i] * nums[i];
//        }
//        Arrays.sort(arr);
//        return arr;
//    }

    //双指针
    public static int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int count = n - 1;
        int[] arr = new int[n];
        while (left <= right) {
            int a = nums[left] * nums[left];
            int b = nums[right] * nums[right];
            if (a > b) {
                arr[count--] = a;
                left++;
            } else {
                arr[count--] = b;
                right--;
            }
        }

        return arr;
    }
}
