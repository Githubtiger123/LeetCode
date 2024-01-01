package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//面试题 08.14. 布尔运算
public class M08_14 {

    @Test
    public void test() {

        System.out.println(countEval("1^0|0|1", 0));
        System.out.println(countEval("0^1|1|0&0&0&1^0&0&0^1|0&1", 0));
        System.out.println(countEval("1&0&0", 0));
    }

    //方法三:动态规划
    public int countEval(String s, int result) {

        int n = s.length();
        char[] str = s.toCharArray();
        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            dp[i][i][0] = str[i] == '0' ? 1 : 0;
            dp[i][i][1] = str[i] == '1' ? 1 : 0;
        }

        for (int left = n - 2; left >= 0; left--) {
            for (int right = left + 1; right < n; right++) {

                int ans_true = 0, ans_false = 0;
                for (int i = left + 1; i <= right; i += 2) {
                    switch (str[i]) {
                        case '&':
                            ans_true += dp[left][i - 1][1] * dp[i + 1][right][1];
                            break;
                        case '|':
                            ans_true += dp[left][i - 1][1] * dp[i + 1][right][1] + dp[left][i - 1][1] * dp[i + 1][right][0] + dp[left][i - 1][0] * dp[i + 1][right][1];
                            break;
                        case '^':
                            ans_true += dp[left][i - 1][1] * dp[i + 1][right][0] + dp[left][i - 1][0] * dp[i + 1][right][1];
                            break;
                    }
                    switch (str[i]) {
                        case '|':
                            ans_false += dp[left][i - 1][0] * dp[i + 1][right][0];
                            break;
                        case '&':
                            ans_false += dp[left][i - 1][0] * dp[i + 1][right][0] + dp[left][i - 1][1] * dp[i + 1][right][0] + dp[left][i - 1][0] * dp[i + 1][right][1];
                            break;
                        case '^':
                            ans_false += dp[left][i - 1][1] * dp[i + 1][right][1] + dp[left][i - 1][0] * dp[i + 1][right][0];
                            break;
                    }
                }
                dp[left][right][0] = ans_false;
                dp[left][right][1] = ans_true;
            }
        }

        return dp[0][n - 1][result];
    }

    //方法二:记忆化搜索
    public int countEval1(String s, int result) {

        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs(s.toCharArray(), result, 0, s.length() - 1, dp);
    }

    public int dfs(char[] str, int result, int left, int right, int[][][] dp) {

        if (result == 1 && dp[left][right][1] != -1) {
            return dp[left][right][1];
        } else if (result == 0 && dp[left][right][0] != -1) {
            return dp[left][right][0];
        }

        int ans = 0;
        if (left > right) {
            ans = 0;
        } else if (left == right) {
            ans = str[left] == result + '0' ? 1 : 0;
        } else {
            for (int i = left + 1; i <= right; i += 2) {
                if (result == 1) {
                    switch (str[i]) {
                        case '&':
                            ans += dfs(str, 1, left, i - 1, dp) * dfs(str, 1, i + 1, right, dp);
                            break;
                        case '|':
                            ans += dfs(str, 1, left, i - 1, dp) * dfs(str, 1, i + 1, right, dp) + dfs(str, 0, left, i - 1, dp) * dfs(str, 1, i + 1, right, dp) + dfs(str, 1, left, i - 1, dp) * dfs(str, 0, i + 1, right, dp);
                            break;
                        case '^':
                            ans += dfs(str, 1, left, i - 1, dp) * dfs(str, 0, i + 1, right, dp) + dfs(str, 0, left, i - 1, dp) * dfs(str, 1, i + 1, right, dp);
                            break;
                    }
                } else {
                    switch (str[i]) {
                        case '|':
                            ans += dfs(str, 0, left, i - 1, dp) * dfs(str, 0, i + 1, right, dp);
                            break;
                        case '&':
                            ans += dfs(str, 0, left, i - 1, dp) * dfs(str, 0, i + 1, right, dp) + dfs(str, 0, left, i - 1, dp) * dfs(str, 1, i + 1, right, dp) + dfs(str, 1, left, i - 1, dp) * dfs(str, 0, i + 1, right, dp);
                            break;
                        case '^':
                            ans += dfs(str, 1, left, i - 1, dp) * dfs(str, 1, i + 1, right, dp) + dfs(str, 0, left, i - 1, dp) * dfs(str, 0, i + 1, right, dp);
                            break;
                    }
                }
            }
        }

        dp[left][right][result] = ans;
        return ans;
    }


    //方法一:暴力递归
//    public int countEval(String s, int result) {
//
//        return dfs(s.toCharArray(), result, 0, s.length() - 1);
//    }
//
//    //0&0&0&1^1|0
//    public int dfs(char[] str, int result, int left, int right) {
//        if (left > right) {
//            return 0;
//        } else if (left == right) {
//            return str[left] == result + '0' ? 1 : 0;
//        } else {
//            int ans = 0;
//            for (int i = left + 1; i <= right; i += 2) {
//                if (result == 1) {
//                    switch (str[i]) {
//                        case '&':
//                            ans += dfs(str, 1, left, i - 1) * dfs(str, 1, i + 1, right);
//                            break;
//                        case '|':
//                            ans += dfs(str, 1, left, i - 1) * dfs(str, 1, i + 1, right) + dfs(str, 0, left, i - 1) * dfs(str, 1, i + 1, right) + dfs(str, 1, left, i - 1) * dfs(str, 0, i + 1, right);
//                            break;
//                        case '^':
//                            ans += dfs(str, 1, left, i - 1) * dfs(str, 0, i + 1, right) + dfs(str, 0, left, i - 1) * dfs(str, 1, i + 1, right);
//                            break;
//                    }
//                } else {
//                    switch (str[i]) {
//                        case '|':
//                            ans += dfs(str, 0, left, i - 1) * dfs(str, 0, i + 1, right);
//                            break;
//                        case '&':
//                            ans += dfs(str, 0, left, i - 1) * dfs(str, 0, i + 1, right) + dfs(str, 0, left, i - 1) * dfs(str, 1, i + 1, right) + dfs(str, 1, left, i - 1) * dfs(str, 0, i + 1, right);
//                            break;
//                        case '^':
//                            ans += dfs(str, 1, left, i - 1) * dfs(str, 1, i + 1, right) + dfs(str, 0, left, i - 1) * dfs(str, 0, i + 1, right);
//                            break;
//                    }
//                }
//            }
//            return ans;
//        }
//    }
}
