package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//44. 通配符匹配
public class L44 {

    public boolean isMatch1(String s, String p) {

        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(s, p, 0, 0, dp);
    }


    private boolean dfs(String s, String p, int i, int j, int[][] dp) {

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean ans = false;

        if (i < s.length() && j >= p.length()) {

            ans = false;
        } else if (i >= s.length() && j < p.length()) {

            if (p.charAt(j) == '*') {

                ans = dfs(s, p, i, j + 1, dp);
            } else {
                ans = false;
            }
        } else if (i == s.length() && j == p.length()) {
            ans = true;
        } else if (p.charAt(j) == '?') {
            ans = dfs(s, p, i + 1, j + 1, dp);
        } else if (s.charAt(i) != p.charAt(j) && p.charAt(j) != '*') {
            ans = false;
        } else if (s.charAt(i) == p.charAt(j)) {

            ans = dfs(s, p, i + 1, j + 1, dp);
        } else {
            //boolean b = false;
            for (int k = i; k < s.length() + 1; k++) {
                ans = ans || dfs(s, p, k, j + 1, dp);
            }
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }

    //s:源字符串 P:目标字符串
//    private boolean dfs(String s, String p, int i, int j) {
//
//        if (i < s.length() && j >= p.length()) {
//
//            return false;
//        } else if (i >= s.length() && j < p.length()) {
//
//            if (p.charAt(j) == '*') {
//
//                return dfs(s, p, i, j + 1);
//            } else {
//                return false;
//            }
//        } else if (i == s.length() && j == p.length()) {
//            return true;
//        } else if (p.charAt(j) == '?') {
//            return dfs(s, p, i + 1, j + 1);
//        } else if (s.charAt(i) != p.charAt(j) && p.charAt(j) != '*') {
//            return false;
//        } else if (s.charAt(i) == p.charAt(j)) {
//
//            return dfs(s, p, i + 1, j + 1);
//        } else {
//            boolean b = false;
//            for (int k = i; k < s.length() + 1; k++) {
//                b = b || dfs(s, p, k, j + 1);
//            }
//
//            return b;
//        }
//    }

    public boolean isMatch(String s, String p) {

        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {

            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                boolean ans = false;
                if (p.charAt(j - 1) != '*') {
                    ans = i > 0 && j > 0 && dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                } else {
                    ans = j > 0 && dp[i][j - 1] || i > 0 && dp[i - 1][j];
                }
                dp[i][j] = ans;
            }
        }
        return dp[n][m];
    }

    @Test
    public void test() {
        System.out.println(isMatch("aa", "a"));
//        System.out.println(isMatch("", ""));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aa", "a?"));
        System.out.println(isMatch("asddfffdsasdd", "asd*dd"));
        System.out.println(isMatch("acd", "a*d"));
    }
}
