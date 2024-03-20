package com.enumeration.java;

import org.junit.Test;

//97. 交错字符串
public class L97 {

    public boolean isInterleave(String s1, String s2, String s3) {

        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        if (n1 + n2 != n3) {
            return false;
        }

        if (n1 + n2 == n3 && (n1 == 0 && s2.equals(s3) || n2 == 0 && s1.equals(s3))) {
            return true;
        }

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        dp[0][0] = true;
        for (int i = 1; i < n1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] && chars1[i - 1] == chars3[i - 1];
        }

        for (int j = 1; j < n2 + 1; j++) {
            dp[0][j] = dp[0][j - 1] && chars2[j - 1] == chars3[j - 1];
        }

        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = chars3[i + j - 1] == chars1[i - 1];
                } else if (dp[i][j - 1]) {
                    dp[i][j] = chars3[i + j - 1] == chars2[j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n1][n2];
    }

    @Test
    public void test() {

        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
