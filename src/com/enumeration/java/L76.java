package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class L76 {

    @Test
    public void test() {

        //"ABC"
        //"ADOBECODEBANC"
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();

    public String minWindow(String s, String t) {


        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int right = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE, valid = 0, start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (need.size() == valid) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char c1 = s.charAt(left);
                left++;
                if (window.containsKey(c1)) {
                    if (need.get(c1).equals(window.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }


    public static String minWindow1(String s, String t) {

        char[] str1 = new char[26];
        char[] str2 = new char[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            str2[tt[i] - 'A']++;
        }
        int i = -1;
        String result = "";
        for (int j = 0; j < s.length(); j++) {
            if (t.contains(String.valueOf(ss[j]))) {
                if (i == -1) {
                    i = j;
                    continue;
                }
                str1[ss[j] - 'A']++;
            }
            if (Arrays.equals(str1, str2)) {
                if (result.length() > j - i) {
                    result = s.substring(i, j + 1);
                }
                str1[ss[i] - 'A']--;
                while (!t.contains(String.valueOf(ss[i]))) {
                    i++;
                }
            }
        }
        return result;
    }
}
