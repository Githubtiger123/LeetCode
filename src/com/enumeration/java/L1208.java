package com.enumeration.java;

import org.junit.Test;

import java.awt.*;

///2108. 找出数组中的第一个回文字符串
public class L1208 {

    @Test
    public void test() {

        System.out.println(firstPalindrome(new String[]{"def","ghi"}));
    }

    public String firstPalindrome(String[] words) {

        for (int i = 0; i < words.length; i++) {
            if (isHuiwen(words[i])) {
                return words[i];
            }
        }
        return "";
    }

    public boolean isHuiwen(String s) {

        char[] str = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (str[i] != str[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
