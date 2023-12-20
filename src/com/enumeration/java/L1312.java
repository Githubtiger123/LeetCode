package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//1312. 让字符串成为回文串的最少插入次数
public class L1312 {

    @Test
    public void test() {

        System.out.println(minInsertions("leetcode"));
        System.out.println(minInsertions("tldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqztldjbqjdogipebqsohdypcxjqkrqltpgviqtqz"));
    }

    //方法三:动态规划
    public int minInsertions(String s) {

        char[] str = s.toCharArray();
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = str[i] == str[i + 1] ? 0 : 1;
        }

        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                int ans;
                if (str[l] == str[r]) {
                    ans = dp[l + 1][r - 1];
                } else {
                    ans = 1 + Math.min(dp[l][r - 1], dp[l + 1][r]);
                }
                dp[l][r] = ans;
            }
        }

        return dp[0][n - 1];
    }

//    public int minInsertions(String s) {
//
//        char[] str = s.toCharArray();
//        int n = s.length();
//        int[][] dp = new int[n][n];
//        int i = 0, j = 0, k = 1;
//        while (k < n) {
//            i = 0;
//            j = k;
//            while (j < n) {
//
//                int ans = 0;
//                if (i > j) {
//                    ans = 0;
//                } else if (i == j) {
//                    ans = 0;
//                } else if (i + 1 == j) {
//                    ans = str[i] == str[j] ? 0 : 1;
//                } else if (str[i] == str[j]) {
//                    ans = dp[i + 1][j - 1];
//                } else {
//                    ans = 1 + Math.min(dp[i][j - 1], dp[i + 1][j]);
//                }
//                dp[i][j] = ans;
//                i++;
//                j++;
//            }
//            k++;
//        }
//        return dp[0][n - 1];
//    }

    //方法二:记忆化搜索
    public int minInsertions1(String s) {

        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return func(s.toCharArray(), 0, s.length() - 1, dp);
    }

    public int func(char[] str, int left, int right, int[][] dp) {

        if (dp[left][right] != -1) {

            return dp[left][right];
        }
        int ans = 0;

        if (left > right) {
            ans = 0;
        } else if (left == right) {
            ans = 0;
        } else if (left + 1 == right) {
            ans = str[left] == str[right] ? 0 : 1;
        } else if (str[left] == str[right]) {
            ans = func(str, left + 1, right - 1, dp);
        } else {
            ans = 1 + Math.min(func(str, left, right - 1, dp), func(str, left + 1, right, dp));
        }

        dp[left][right] = ans;
        return ans;
    }

    //方法一:暴力解法
//    public int minInsertions(String s) {
//
//        ans = func(s.toCharArray(), 0, s.length() - 1);
//    }
//
//    public int func(char[] str, int left, int right) {
//        if (left > right) {
//            ans = 0;
//        } else if (left == right) {
//            ans = 0;
//        } else if (left + 1 == right) {
//            ans = str[left] == str[right] ? 0 : 1;
//        } else if (str[left] == str[right]) {
//            ans = func(str, left + 1, right - 1);
//        } else {
//            ans = 1 + Math.min(func(str, left, right - 1), func(str, left + 1, right));
//        }
//    }
}
