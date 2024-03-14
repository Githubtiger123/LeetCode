package com.enumeration.java;

import org.junit.Test;

import java.util.HashMap;

//5. 最长回文子串
public class L5 {

    public boolean func(int start, int end, char[] array) {

        if (start == end) {
            return true;
        }
        if (start + 1 == end && array[start] == array[end]) {
            return true;
        } else if (start + 1 == end && array[start] != array[end]) {
            return false;
        }
        if (array[start] != array[end]) {
            return func(start + 1, end - 1, array);
        } else {
            int ans = 2;
            ans += func(start + 1, end - 1, array);
            ans += func(start, end - 1, array);
            ans += func(start + 1, end, array);
            return ans;
        }
    }

    public int longestPalindrome(String s) {

        int n = s.length();

        int func = func(0, n - 1, s.toCharArray());
        return func;
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("cbbdb"));
    }
}
