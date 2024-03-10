package com.enumeration.java;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

//1921. 消灭怪物的最大数量
public class L1921 {


//    public int eliminateMaximum(int[] dist, int[] speed) {
//
//        int n = dist.length, ans = 0, time = 0;
//        double[] nums = new double[n];
//        for (int i = 0; i < n; i++) {
//
//            nums[i] = (double) dist[i] / speed[i];
//        }
//        Arrays.sort(nums);
//        int count = 0;
//        while (count < n) {
//
//            if (nums[count] - time > 0) {
//                ans++;
//                count++;
//                time++;
//            } else {
//                return ans;
//            }
//        }
//        return ans;
//    }

    public int eliminateMaximum(int[] dist, int[] speed) {

        int n = dist.length, ans = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {

            nums[i] = (dist[i] + speed[i] - 1) / speed[i];
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] - i > 0) {
                ans++;
            } else {
                return ans;
            }
        }
        return ans;
    }

    @Test
    public void test() {

        System.out.println(eliminateMaximum(new int[]{3, 2, 4}, new int[]{5, 3, 2}));
        System.out.println(eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));
    }
}
