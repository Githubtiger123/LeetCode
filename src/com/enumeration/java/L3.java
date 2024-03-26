package com.enumeration.java;

import org.junit.Test;

import java.util.HashMap;

//3. 无重复字符的最长子串
public class L3 {

    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int n = s.length();
        int[] arr = new int[26];
        HashMap<Character, Integer> map = new HashMap<>();

        int ans = 0;

        int start = 0, end = 0;
        while (start <= end && end < n) {

//            Integer i = map.get(chars[end]);
//            if (i != null) {
//                map.put(chars[end], i + 1);
//            } else {
//                map.put(chars[end], 1);
//            }
            map.merge(chars[end], 1, Integer::sum);
            while (map.get(chars[end]) > 1) {

                Integer i1 = map.get(chars[start]);
                map.put(chars[start], --i1);
                start++;
            }
            ans = Math.max(ans, end - start + 1);
            end++;
        }

        return ans;
    }

    @Test
    public void test() {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("aa"));
        System.out.println(lengthOfLongestSubstring("a"));
        System.out.println(lengthOfLongestSubstring("ab"));
    }
}
