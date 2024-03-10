package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//2384. 最大回文数字
public class L2384 {

    public String largestPalindromic(String num) {

        if (num.length() == 1) {
            return num;
        }

        char[] charArray = num.toCharArray();
        Arrays.sort(charArray);
        int n = charArray.length;
        char c = charArray[n - 1];
        int count = 1;
        int[] temp = new int[10];
        StringBuilder sb = new StringBuilder();
        for (int i = n - 2; i >= 0; i--) {

            if (c == charArray[i]) {
                count++;
            } else {
                if ((count & 1) == 1) {
                    temp[c - '0']++;
                }
                count /= 2;
                for (int j = 0; j < count; j++) {
                    sb.append(c);
                }
                c = charArray[i];
                count = 1;
            }
            if (i == 0) {
                if ((count & 1) == 1) {
                    temp[c - '0']++;
                }
                count /= 2;
                for (int j = 0; j < count; j++) {
                    sb.append(c);
                }
                c = charArray[i];
                count = 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.reverse();
        for (int i = 9; i >= 0; i--) {
            if (temp[i] != 0) {
                sb.append((char) (i + '0'));
                break;
            }
        }
        sb.append(stringBuilder);
        String s = sb.toString().replaceAll("^0+|0+$", "");
        return s.isEmpty() ? "0" : s;
    }

    @Test
    public void test() {
        System.out.println(largestPalindromic("404"));
        System.out.println(largestPalindromic("5"));
        System.out.println(largestPalindromic("00000"));
        System.out.println(largestPalindromic("00001105"));
        System.out.println(largestPalindromic("444947137"));
        System.out.println(largestPalindromic("00009"));
    }
}
