package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

//179. 最大数
public class L179 {


    @Test
    public void test() {

        System.out.println(largestNumber(new int[]{0, 0}));
    }

    public String largestNumber(int[] nums) {

        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> -(a + b).compareTo(b + a));

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(arr[i]);
        }
        return str.toString().charAt(0) == '0' ? "0" : str.toString();
    }
}
