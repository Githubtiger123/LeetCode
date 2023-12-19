package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//324. 摆动排序 II
public class L324 {


    @Test
    public void test() {

        wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
        wiggleSort(new int[]{1, 3, 2, 2, 3, 1});
        wiggleSort(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4});
        wiggleSort(new int[]{1, 2, 3});
        wiggleSort(new int[]{1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3});
    }

    public void wiggleSort(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return;
        }
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int l = (n - 1) / 2;
        int r1 = (n + 1) / 2, r2 = n - 1, count = 0;
        while (l > 0) {
            if (temp[l] == temp[r1]) {
                nums[count++] = temp[l--];
                nums[count++] = temp[r2--];
            } else {
                nums[count++] = temp[l--];
                nums[count++] = temp[r1++];
            }
        }
        nums[count++] = temp[l];
        if (n % 2 == 0) {
            nums[count] = temp[r1];
        }
        System.out.println(Arrays.toString(nums));
    }


    public void wiggleSort1(int[] nums) {
        //先排好序，然后通过双指针的方式逐个插入
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int len = nums.length;
        int left = (len - 1) / 2;
        int right = len - 1;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                nums[i] = clone[left];
                left--;
            } else {
                nums[i] = clone[right];
                right--;
            }
        }

    }

//    public void wiggleSort(int[] nums) {
//
//        if (nums.length == 1) {
//            return;
//        }
//        Arrays.sort(nums);
//        int[] ans = new int[nums.length];
//        int right = nums.length - 1, left = 0, t = 0;
//        while (left < right && t < nums.length - 1) {
//            ans[t++] = nums[left++];
//            ans[t++] = nums[right--];
//        }
//        if (nums.length % 2 == 1) {
//            ans[t] = nums[left];
//        }
//        if (ans[ans.length - 1] == ans[ans.length - 2]) {
//
//            nums[0] = ans[ans.length - 1];
//            for (int i = 0; i < ans.length - 1; i++) {
//                nums[i + 1] = ans[i];
//            }
//        } else {
//            for (int i = 0; i < ans.length; i++) {
//                nums[i] = ans[i];
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//        if (nums[0] > nums[1]) {
//            for (int i = 0; i < nums.length - 1; i+=2) {
//                int n = nums[i];
//                nums[i] = nums[i + 1];
//                nums[i + 1] = n;
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//    }
}
