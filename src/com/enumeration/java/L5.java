package com.enumeration.java;

import org.junit.Test;


//5. 最长回文子串
public class L5 {
    public String longestPalindrome(String s) {

        int n = s.length();
        int ans_start = 0, ans_end = 0;
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int k = 1; k < n; k++) {
            int j = k, i = 0;
            while (j < n) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = j - i < 3 || dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    System.out.println("i:" + i + ",j:" + j);
                    if (j - i > ans_end - ans_start) {
                        ans_start = i;
                        ans_end = j;
                    }
                }
                j++;
                i++;
            }

        }

        return s.substring(ans_start, ans_end + 1);//substring的两个参数是左闭右开
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("cabbab"));
    }
}
