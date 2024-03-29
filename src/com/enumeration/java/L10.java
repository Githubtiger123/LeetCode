package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//10. 正则表达式匹配
public class L10 {


    //s:源,p:目标
    private boolean func(char[] s, int n, char[] p, int m, int[][] dp) {

        if (dp[n][m] != -1) {
            return dp[n][m] == 1;
        }

        boolean match = false;
        boolean ans = false;
        if (m == p.length) {
            ans = n == s.length;
        } else {
            if (n != s.length) {

                match = s[n] == p[m] || p[m] == '.';
            }
            if (p.length - m >= 2 && p[m + 1] == '*') {
                ans = match && func(s, n + 1, p, m, dp) || func(s, n, p, m + 2, dp);
                dp[n][m] = ans ? 1 : 0;
                return ans;
            }
            ans = match && func(s, n + 1, p, m + 1, dp);
        }
        dp[n][m] = ans ? 1 : 0;
        return ans;

    }


    public boolean isMatch1(String s, String p) {

        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return func(s.toCharArray(), 0, p.toCharArray(), 0, dp);
    }

    //动态规划方法
    public boolean isMatch2(String s, String p) {

        int n = s.length();
        int m = p.length();
        char[] chars = s.toCharArray();
        char[] charp = p.toCharArray();
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][m] = false;
        }
        /*
        对于`dp[n][j]`，正则表达式不为空，但如果其中有'*'字符，
        仍然可以匹配待匹配字符串（实际上可以匹配任意字符串）。
        对于含有'*'字符的正则表达式，例如"a*", ".*", "a*b*", "a*b*c*"等等，都可以匹配空字符串。
        所以对于所有后面一个字符是'*'的`dp[n][j]`，我们应当设置为1，其他情况设为0。
         */
//        for (int j = 0; j < m; j++) {
//            dp[n][j] = j < m - 1 && charp[j + 1] == '*' ? 1 : 0;
//        }
        //通过以上修改还不够
        //从后往前看,遇到非*的则不可能与""匹配成功 如S:"",P:"c*c"
        for (int j = m - 2; j >= 0; j -= 2) {
            if (charp[j + 1] != '*') break;
            dp[n][j] = true;
        }
        dp[n][m] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                boolean match = i != s.length() && (chars[i] == charp[j] || charp[j] == '.');
                if (p.length() - j >= 2 && charp[j + 1] == '*') {
                    dp[i][j] = match && dp[i + 1][j] || dp[i][j + 2];
                } else {
                    dp[i][j] = match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray(), ptr = p.toCharArray();
        boolean[][] dp = new boolean[str.length + 1][ptr.length + 1];
        dp[0][0] = true;
        for (int i = 0; i <= str.length; i++) {
            for (int j = 1; j <= ptr.length; j++) {
                if (ptr[j - 1] != '*') {
                    if (i > 0 && (str[i - 1] == ptr[j - 1] || ptr[j - 1] == '.')) dp[i][j] = dp[i - 1][j - 1];
                } else { //ptr[j - 1] == '*'
                    if (j > 1) dp[i][j] |= dp[i][j - 2];   //不看
                    if (i > 0 && j > 1 && (str[i - 1] == ptr[j - 2] || ptr[j - 2] == '.'))
                        dp[i][j] |= dp[i - 1][j];    //看
                }
            }
        }
        return dp[str.length][ptr.length];
    }


    @Test
    public void test() {

        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("a", "."));
        System.out.println(isMatch("aba", "*c*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aab", ".*"));
        System.out.println(isMatch("aa", "**"));
        System.out.println(isMatch("asdfghhjgfdrseawq", "*h*r*e*"));
        System.out.println(isMatch("", "a***"));
    }
}
