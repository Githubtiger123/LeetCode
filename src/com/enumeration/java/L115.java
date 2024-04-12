package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//115. 不同的子序列
public class L115 {

    //回溯超时
//    List<Character> list;
//    String tar;
//
//    public int numDistinct(String s, String t) {
//
//        list = new ArrayList<>();
//        tar = t;
//        int ans = dfs(s.toCharArray(), 0, list);
//        return ans;
//    }
//

//
//    private int dfs(char[] str, int start, List<Character> list) {
//
//        int ans = 0;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < list.size(); i++) {
//            sb.append(list.get(i));
//        }
//        if (sb.toString().equals(tar)) {
//            ans = 1;
//        }
//
//        for (int i = start; i < str.length; i++) {
//
//            list.add(str[i]);
//            ans += dfs(str, i + 1, list);
//            list.remove(list.size() - 1);
//        }
//        ans %= 1000000007;
//        return ans;
//    }


    public int numDistinct1(String s, String t) {

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(s.toCharArray(), 0, t.toCharArray(), 0, dp);
    }

    private int dfs(char[] s, int i, char[] t, int j, int[][] dp) {

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;

        if (j == t.length && i <= s.length) {
            ans = 1;
        } else if (j < t.length && i >= s.length) {
            ans = 0;
        } else {
            if (s[i] == t[j]) {
                ans += dfs(s, i + 1, t, j + 1, dp);
            }
            ans += dfs(s, i + 1, t, j, dp);
        }

        dp[i][j] = ans;
        return ans;
    }

    public int numDistinct(String s, String t) {

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][t.length()] = 1;
        }
        for (int j = 0; j < t.length(); j++) {
            dp[s.length()][j] = 1;
        }

        for (int i = s.length(); i >= 0; i--) {
            for (int j = t.length(); j >= 0; j--) {

                int ans = 0;

                if (j == t.length() && i <= s.length()) {
                    ans = 1;
                } else if (j < t.length() && i >= s.length()) {
                    ans = 0;
                } else {
                    if (s.charAt(i) == t.charAt(j)) {
                        ans += dp[i + 1][j + 1];
                    }
                    ans += dp[i + 1][j];
                }

                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }

    @Test
    public void test() {

        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));

    }

}
