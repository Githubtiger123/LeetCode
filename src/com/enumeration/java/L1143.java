package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//1143. 最长公共子序列
public class L1143 {

    @Test
    public void test() {

        System.out.println(longestCommonSubsequence("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
//        System.out.println(longestCommonSubsequence("adb", "abe"));
    }

    //方法三:动态规划
    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int[][] dp = new int[m][n];

        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int j = 1; j < n; j++) {
            dp[0][j] = str1[0] == str2[j] ? 1 : dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int ans1 = dp[i - 1][j];
                int ans2 = dp[i][j - 1];
                int ans3 = str1[i] == str2[j] ? (1 + dp[i - 1][j - 1]) : 0;
                dp[i][j] = Math.max(ans1, Math.max(ans2, ans3));
            }
        }
        return dp[m - 1][n - 1];
    }


    //方法二:记忆化搜索
//    public int longestCommonSubsequence(String text1, String text2) {
//
//        int i = text1.length();
//        int j = text2.length();
//        int[][] dp = new int[i][j];
//        for (int k = 0; k < i; k++) {
//            Arrays.fill(dp[k], -1);
//        }
//        return func(text1.toCharArray(), text2.toCharArray(), text1.length() - 1, text2.length() - 1, dp);
//    }
//
//    public int func(char[] text1, char[] text2, int i, int j, int[][] dp) {
//
//        if (dp[i][j] != -1) {
//            return dp[i][j];
//        }
//        int ans = 0;
//
//        if (i == 0 && j == 0) {
//            ans = text1[i] == text2[j] ? 1 : 0;
//        } else if (i == 0) {
//            if (text1[i] == text2[j]) {
//                ans = 1;
//            } else {
//                ans = func(text1, text2, i, j - 1, dp);
//            }
//        } else if (j == 0) {
//            if (text1[i] == text2[j]) {
//                ans = 1;
//            } else {
//                ans = func(text1, text2, i - 1, j, dp);
//            }
//        } else {
//            int p1 = func(text1, text2, i, j - 1, dp);
//            int p2 = func(text1, text2, i - 1, j, dp);
//            int p3 = text1[i] == text2[j] ? (1 + func(text1, text2, i - 1, j - 1, dp)) : 0;
//            ans = Math.max(p1, Math.max(p2, p3));
//        }
//        dp[i][j] = ans;
//        return ans;
//    }

    //方法一:暴力递归
//    public int longestCommonSubsequence(String text1, String text2) {
//
//        return func(text1.toCharArray(), text2.toCharArray(), text1.length() - 1, text2.length() - 1);
//    }
//
//    public int func(char[] text1, char[] text2, int i, int j) {
//
//        if (i == 0 && j == 0) {
//            return text1[i] == text2[j] ? 1 : 0;
//        } else if (i == 0) {
//            if (text1[i] == text2[j]) {
//                return 1;
//            } else {
//                return func(text1, text2, i, j - 1);
//            }
//        } else if (j == 0) {
//            if (text1[i] == text2[j]) {
//                return 1;
//            } else {
//                return func(text1, text2, i - 1, j);
//            }
//        } else {
//            int p1 = func(text1, tex t2, i, j - 1);
//            int p2 = func(text1, text2, i - 1, j);
//            int p3 = text1[i] == text2[j] ? (1 + func(text1, text2, i - 1, j - 1)) : 0;
//            return Math.max(p1, Math.max(p2, p3));
//        }
//
//    }
}
