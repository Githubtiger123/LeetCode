package com.enumeration.java;

import org.junit.Test;

//1358. 包含所有三种字符的子字符串数目
public class L1358 {

    @Test
    public void test() {
        System.out.println(numberOfSubstrings("abcabc"));
    }

    public int numberOfSubstrings(String s) {

        char[] str = s.toCharArray();
        int[] cnt = new int[3];
        int n = s.length();
        int ans = 0;
        int left = 0, right = 0;
        while (right < n) {

            cnt[str[right] - 'a']++;
            right++;

            while (left < right && cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
//                System.out.println("left:" + left + ",right:" + right);
                ans += 1 + n - right;
                cnt[str[left] - 'a']--;
                left++;
            }
        }
        return ans;
    }
}
