package com.competition.java.C374;

import org.junit.Test;

import java.util.Arrays;
import java.util.Hashtable;

//2953. 统计完全子字符串
public class L2953 {

    @Test
    public void test() {

        System.out.println(countCompleteSubstrings("aaabbbccc", 3));
    }

    public int countCompleteSubstrings(String word, int k) {

        int i = 0, j, sum = 0;
        char[] str = word.toCharArray();
        while (i < word.length()) {
            j = i;
            j++;
            while (j < word.length() && Math.abs(str[j] - str[j - 1]) <= 2) {
                j++;
            }
            sum += f(word.substring(i, j), k);
            System.out.println(word.substring(i, j));
            i = j;
        }
        return sum;
    }

    private int f(String s, int k) {

        char[] array = s.toCharArray();
        int ans = 0;
        for (int m = 1; m <= 26 && m * k <= s.length(); m++) {
            int[] cnt = new int[26];
            for (int right = 0; right < array.length; right++) {
                cnt[array[right] - 'a']++;
                int left = (right + 1) - m * k;
                if (left >= 0) {
                    boolean flag = true;
                    for (int i = 0; i < 26; i++) {
                        if (cnt[i] != 0 && cnt[i] != k) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) ans++;
                    cnt[array[left] - 'a']--;
                }
            }
        }
        return ans;
    }
}
