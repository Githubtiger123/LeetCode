package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//969. 煎饼排序
public class L969 {

    @Test
    public void test() {

        List<Integer> list = pancakeSort(new int[]{1, 2, 3, 4, 5, 6});
//        List<Integer> list1 = pancakeSort(new int[]{3,2,4,1});
        System.out.println(list);
    }

    public List<Integer> pancakeSort(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();
        int max = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = n - i - 1;
            max = 0;
            while (j >= 0) {
                max = arr[max] >= arr[j] ? max : j;
                j--;
            }
            System.out.println(max);
            if (max == n - i - 1) {
                continue;
            }
            reverse(arr, max + 1, list);
            reverse(arr, n - i, list);
        }
        System.out.println(Arrays.toString(arr));
        return list;
    }

    public void reverse(int[] nums, int k, List<Integer> lsit) {

        lsit.add(k);
        k -= 1;
        for (int i = 0; i <= k / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[k - i];
            nums[k - i] = temp;
        }
    }
}
