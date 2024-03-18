package com.enumeration.java;

import org.junit.Test;

//467. 环绕字符串中唯一的子字符串
public class L467 {

    public int findSubstringInWraproundString(String s) {

        int n = s.length();
        int[] dp = new int[26];
        char[] chars = s.toCharArray();
        dp[chars[0] - 'a'] = 1;
        int len = 1;
        for (int i = 1; i < n; i++) {

            int pre = chars[i - 1];
            int cur = chars[i];
            if (pre + 1 == cur || pre == 'z' && cur == 'a') {

                len++;
            } else {
                len = 1;
            }
            dp[cur - 'a'] = Math.max(dp[cur - 'a'], len);
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += dp[i];
        }
        return ans;
    }

    @Test
    public void test() {

        System.out.println(findSubstringInWraproundString("a"));
        System.out.println(findSubstringInWraproundString("cac"));
        System.out.println(findSubstringInWraproundString("zab"));
        System.out.println(findSubstringInWraproundString("aa"));
    }
}
