package com.enumeration.java;

import org.junit.Test;

//1323. 6 和 9 组成的最大数字
public class L1323 {

    @Test
    public void test() {

        System.out.println(maximum69Number(9));
    }

    public int maximum69Number(int num) {

        Integer i = Integer.valueOf(num);
        char[] array = i.toString().toCharArray();
        for (int j = 0; j < array.length; j++) {
            if (array[j] == '6') {
                array[j] = '9';
                break;
            }
        }
        int result = 0;
        for (int j = 0; j < array.length; j++) {
            result = result * 10 + array[j] - '0';
        }
        return result;
    }
}
