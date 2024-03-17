package com.enumeration.java;

import org.junit.Test;

//32. 最长有效括号
public class L32 {

    /**
     * 计算字符串中最长有效括号的长度。
     *
     * @param s 输入的字符串
     * @return 最长有效括号的长度
     */
    public int longestValidParentheses(String s) {

        int n = s.length(); // 字符串长度
        char[] chars = s.toCharArray(); // 将字符串转为字符数组
        int[] dp = new int[n]; // 动态规划数组，存储以当前位置结尾的最长有效括号长度
        int max = 0; // 记录最长有效括号长度
        for (int i = 1; i < n; i++) {
            // 遇到右括号
            if (chars[i] == ')') {
                int ans = dp[i - 1]; // 以前一个位置为结尾的最长有效括号长度
                // 检查当前位置之前的字符能否与当前右括号匹配
                if (i - ans - 1 >= 0 && chars[i - ans - 1] == '(') {
                    // 更新以当前位置结尾的最长有效括号长度
                    dp[i] = ans + 2 + (i - ans - 2 >= 0 ? dp[i - ans - 2] : 0);
                }
            }
            // 更新最长有效括号长度
            max = Math.max(max, dp[i]);
        }
        return max; // 返回最长有效括号长度
    }


    @Test
    public void test() {

        System.out.println(longestValidParentheses("()()()()()"));
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses(")()())"));
    }

}
