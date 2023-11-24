package com.enumeration.java;

import org.junit.Test;

import java.util.Scanner;

public class L209 {

    @Test
    public void test() {

        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        System.out.println(minSubArrayLen(7, new int[]{1, 1, 1, 1}));
    }

    public int minSubArrayLen(int target, int[] nums) {

        int minLen = nums.length + 1;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                minLen = Math.min(minLen, end - start);
                start++;
                sum -= nums[start - 1];

            }
//            if(sum<target){
//
//                end++;
//                sum+=nums[end];
//            }
        }
        return minLen == nums.length + 1 ? 0 : minLen + 1;
    }
}
