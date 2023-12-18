package com.enumeration.java;

import org.junit.Test;

//402. 移掉 K 位数字
public class L402 {

    @Test
    public void test() {

        System.out.println(removeKdigits("1432219", 3));
    }

    public String removeKdigits(String num, int k) {

        char[] arr = num.toCharArray();
        int a = 0, b = 0, c = 0, i = 0;
        while (k != 0) {

            while (arr[i] == 0) {
                i++;
            }
            while (a != -1 || b != -1 || c != -1) {
                if (arr[i] == -1) {
                    continue;
                }
                i++;
                if (a == -1) {
                    a = i;
                } else if (b == -1) {
                    b = i;
                } else if (c == -1) {
                    c = i;
                }
            }
            if (arr[b] == 0) {
                arr[a] = (char) -1;
            } else if (arr[a] <= arr[b] && arr[b] <= arr[c]) {
                arr[a] = (char) -1;
            } else if (arr[b] <= arr[a] && arr[a] <= arr[c]) {
                arr[b] = (char) -1;
            } else {
                arr[c] = (char) -1;
            }
            k--;
            a = -1;
            b = -1;
            c = -1;
        }

        StringBuilder s = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != -1) {
                s.append(arr[j]);
            }
        }
        String string = s.toString();
        return string.trim();
    }
}
