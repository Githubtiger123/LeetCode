package com.competition.java.C390;

import org.junit.Test;

//100245. 每个字符最多出现两次的最长子字符串
public class L100245 {

    public int maximumLengthSubstring(String s) {

        int n = s.length();
        int ans = 0;
        char[] chars = s.toCharArray();
        int[] letter;
        for (int start = 0; start < n; start++) {
            letter = new int[26];
            for (int end = start; end < n; end++) {

                letter[chars[end] - 'a'] += 1;
                boolean b1 = false;
                for (int i = 0; i < 26; i++) {

                    if (letter[i] > 2) {
                        b1 = true;
                    }
                }
                if (!b1) {
                    ans = Math.max(ans, end - start + 1);
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {

        System.out.println(maximumLengthSubstring("bcbbbcba"));
        System.out.println(maximumLengthSubstring("aaaa"));
        System.out.println(maximumLengthSubstring("aba"));
    }
}
