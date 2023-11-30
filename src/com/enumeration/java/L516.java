package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//516. 最长回文子序列
public class L516 {


    @Test
    public void test() {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(s.toCharArray(), 0, s.length() - 1, dp);
    }

    public int fun(char[] str, int start, int end, int[][] dp) {

        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int ans = 0;
        if (start == end) {
            ans = 1;
        } else if (start + 1 == end) {
            ans = str[start] == str[end] ? 2 : 1;
        } else {
            int ans1 = fun(str, start, end - 1, dp);
            int ans2 = fun(str, start + 1, end, dp);
            int ans3 = (str[start] == str[end]) ? fun(str, start + 1, end - 1, dp) + 2 : fun(str, start + 1, end - 1, dp);
            ans = Math.max(ans1, Math.max(ans2, ans3));
        }
        dp[start][end] = ans;
        return ans;
    }

    /*
    方法二:记忆化搜索,能通过但是很慢
    执行用时分布124ms 击败 5.03%使用 Java 的用户
    消耗内存分布53.57MB 击败26.85%使用 Java 的用户
     */
//    public int longestPalindromeSubseq(String s) {
//
//        int n = s.length();
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return fun(s.toCharArray(), 0, s.length() - 1, dp);
//    }
//
//    public int fun(char[] str, int start, int end, int[][] dp) {
//
//        if (dp[start][end] != -1) {
//            return dp[start][end];
//        }
//        int ans = 0;
//        if (start == end) {
//            ans = 1;
//        } else if (start + 1 == end) {
//            ans = str[start] == str[end] ? 2 : 1;
//        } else {
//            int ans1 = fun(str, start, end - 1, dp);
//            int ans2 = fun(str, start + 1, end, dp);
//            int ans3 = (str[start] == str[end]) ? fun(str, start + 1, end - 1, dp) + 2 : fun(str, start + 1, end - 1, dp);
//            ans = Math.max(ans1, Math.max(ans2, ans3));
//        }
//        dp[start][end] = ans;
//        return ans;
//    }

    //方法1:暴力递归
//    public int longestPalindromeSubseq(String s) {
//
//        return fun(s.toCharArray(), 0, s.length() - 1);
//    }
//
//    public int fun(char[] str, int start, int end) {
//        if (start == end) {
//            return 1;
//        }
//        if (start + 1 == end) {
//            return str[start] == str[end] ? 2 : 1;
//        }
//
//        int ans1 = fun(str, start, end - 1);
//        int ans2 = fun(str, start + 1, end);
//        int ans3 = (str[start] == str[end]) ? fun(str, start + 1, end - 1) + 2 : fun(str, start + 1, end - 1);
//        return Math.max(ans1, Math.max(ans2, ans3));
//    }
}
