package com.competition.java.C369;

import org.junit.Test;

//2918. 数组的最小相等和
public class L2918 {

    @Test
    public void test() {

        System.out.println(minSum(new int[]{3, 2, 0, 1, 0}, new int[]{6, 5, 0}));
        System.out.println(minSum(new int[]{2, 0, 2, 0}, new int[]{1, 4}));
        System.out.println(minSum(new int[]{0, 0, 10, 10, 12, 0, 13, 6, 0, 2, 10}, new int[]{24, 5, 12, 22}));
    }

    public long minSum(int[] nums1, int[] nums2) {

        long sum1 = 0, sum2 = 0;
        long zero2 = 0, zero1 = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                zero1++;
            }
            sum1 += nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) {
                zero2++;
            }
            sum2 += nums2[i];
        }
        if (zero1 == 0 && zero2 == 0) {
            return sum1 == sum2 ? sum1 : -1;
        } else if (zero1 == 0 && sum1 < sum2) {
            return -1;
        } else if (zero2 == 0 && sum1 > sum2) {
            return -1;
        } else if (zero1 == 0 && sum2 + zero2 > sum1) {
            return -1;
        } else if (zero2 == 0 && sum1 + zero1 > sum2) {
            return -1;
        } else {
            return Math.max(sum1 + zero1, sum2 + zero2);
        }
    }
}
