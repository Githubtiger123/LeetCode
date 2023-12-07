package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

//167. 两数之和 II - 输入有序数组
public class L167 {

    @Test
    public void test() {

        int[] ints = twoSum(new int[]{3, 24, 50, 79, 88, 150, 345}, 200);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }

    //这也能过???
    public int[] twoSum1(int[] numbers, int target) {

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                } else if (numbers[i] + numbers[j] > target) {
                    break;
                }
            }
        }
        return new int[]{};
    }
}
