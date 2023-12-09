package com.enumeration.java;

import org.junit.Test;

//1456. 定长子串中元音的最大数目
public class L1456 {

    @Test
    public void test() {

        System.out.println(maxVowels("abciiidef", 3));
    }

    public int maxVowels(String s, int k) {

        char[] str = s.toCharArray();
        int max = 0, count = 0;
        for (int j = 0; j < s.length(); j++) {
            if (str[j] == 'a' || str[j] == 'e' || str[j] == 'i' || str[j] == 'o' || str[j] == 'u') {
                count++;
            }
            if (j >= k && (str[j - k] == 'a' || str[j - k] == 'e' || str[j - k] == 'i' || str[j - k] == 'o' || str[j - k] == 'u')) {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

}
