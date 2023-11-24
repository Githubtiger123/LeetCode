package com.enumeration.java;

import org.junit.Test;

//845. 数组中的最长山脉
public class L845 {

    @Test
    public void test() {

        System.out.println(longestMountain(new int[]{2}));
    }

//    public static int longestMountain(int[] arr) {
//
//        int maxLen = 0;
//        int start = 0;
//        for (int i = 0; i < arr.length; i++) {
//
//            boolean flag = false, left = false, right = false;
//            int len = 0;
//            start = i;
//            while (start + 1 < arr.length && arr[start] < arr[start + 1]) {
//                flag = true;
//                left = true;
//                start++;
//                len++;
//            }
//
//            while (start + 1 < arr.length && arr[start] > arr[start + 1] && left) {
//                flag = true;
//                if (arr[start] != arr[start + 1]) right = true;
//                start++;
//                len++;
//            }
//            len += flag ? 1 : 0;
//            if (left && right) maxLen = Math.max(maxLen, len);
//        }
//
//        return maxLen;
//    }

    //题解一:枚举山顶
    public int longestMountain(int[] arr) {

        int n = arr.length;
        int maxLen = 0;
        if (n <= 0) {
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = arr[i - 1] < arr[i] ? left[i - 1] + 1 : 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = arr[i] > arr[i + 1] ? right[i + 1] + 1 : 0;
        }

        for (int i = 0; i < n; i++) {
            if (left[i] > 0 && right[i] > 0) {
                maxLen = Math.max(maxLen, left[i] + right[i] + 1);
            }
        }
        return maxLen;
    }

    ///题解二:枚举山底
    public static int longestMountain1(int[] arr) {

        int n = arr.length;
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (left + 2 < n) {
            right = left + 1;
            if (arr[left] < arr[left + 1]) {
                while (right + 1 < n && arr[right] < arr[right + 1]) {
                    right++;
                }
                if (right < n - 1 && arr[right] > arr[right + 1]) {
                    while (right + 1 < n && arr[right] > arr[right + 1]) {
                        right++;
                    }
                    maxLen = Math.max(maxLen, right - left + 1);
                } else {
                    right++;
                }
            }
            left = right;
        }
        return maxLen;
    }
}
