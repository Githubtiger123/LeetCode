package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//91. 解码方法
public class L91 {

    @Test
    public void test() {

        System.out.println(numDecodings("111111111111111111111111111111111111111111111"));
    }

    //方法一:暴力递归
//    public static int numDecodings(String s) {
//
//        return func(s.toCharArray(), 0);
//    }
//
//
//    public static int func(char[] str, int index) {
//
//        if (index == str.length) {
//            return 1;
//        }
//
//        if (str[index] == '0') {
//            return 0;
//        }
//
//        int ans = func(str, index + 1);
//        if (index + 1 <= str.length - 1 && (str[index] - '0') * 10 + (str[index + 1] - '0') <= 26) {
//            ans += func(str, index + 2);
//        }
//        return ans;
//    }

    //方法二:记忆化搜索
//    public static int numDecodings(String s) {
//
//        int[] dp = new int[s.length()];
//        Arrays.fill(dp, -1);
//        return func(s.toCharArray(), 0, dp);
//    }
//
//
//    public static int func(char[] str, int index, int[] dp) {
//
//        if (index == str.length) {
//            return 1;
//        }
//
//        if (dp[index] != -1) {
//            return dp[index];
//        }
//
//        if (str[index] == '0') {
//            return 0;
//        }
//
//        int ans = func(str, index + 1, dp);
//        if (index + 1 <= str.length - 1 && (str[index] - '0') * 10 + (str[index + 1] - '0') <= 26) {
//            ans += func(str, index + 2, dp);
//        }
//        dp[index] = ans;
//        return ans;
//    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return func(s.toCharArray(), 0, dp);
    }


    public static int func(char[] str, int index, int[] dp) {

        if (index == str.length) {
            return 1;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        if (str[index] == '0') {
            return 0;
        }

        int ans = func(str, index + 1, dp);
        if (index + 1 <= str.length - 1 && (str[index] - '0') * 10 + (str[index + 1] - '0') <= 26) {
            ans += func(str, index + 2, dp);
        }
        dp[index] = ans;
        return ans;
    }
}
