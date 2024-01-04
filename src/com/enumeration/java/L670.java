package com.enumeration.java;

import org.junit.Test;

//670. 最大交换
public class L670 {

    @Test
    public void test() {

        System.out.println(maximumSwap(9973));
    }

    public int maximumSwap(int num) {

        char[] array = String.valueOf(num).toCharArray();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int max = i;
            for (int j = n - 1; j > i; j--) {
                if (array[max] < array[j]) {
                    max = j;
                }
            }
            if (max != i) {
                int temp = array[max];
                array[max] = array[i];
                array[i] = (char) temp;
                break;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans *= 10;
            ans += array[i] - '0';
        }
        return ans;
    }
}
