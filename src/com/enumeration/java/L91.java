package com.enumeration.java;

import org.junit.Test;

//91. 解码方法
public class L91 {

    @Test
    public void test() {

//        System.out.println(numDecodings("111111111111111111111111111111111111111111111"));
        System.out.println(numDecodings("101"));
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
//
//    方法二:记忆化搜索
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

    //方法三:动态规划
    public static int numDecodings(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {

            if (str[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] += dp[i + 1];
                if (i + 1 <= str.length - 1 && (str[i] - '0') * 10 + (str[i + 1] - '0') <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}
