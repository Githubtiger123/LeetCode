package com.enumeration.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//424. 替换后的最长重复字符
public class L424 {

    @Test
    public void test() {
        System.out.println(characterReplacement("B", 1));
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public int characterReplacement2(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;

        int res = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        // [left, right) 内最多替换 k 个字符可以得到只有一种字符的子串
        while (right < len) {
            freq[charArray[right] - 'A']++;
            // 在这里维护 maxCount，因为每一次右边界读入一个字符，字符频数增加，才会使得 maxCount 增加
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);
            right++;

            if (right - left > maxCount + k) {
                // 说明此时 k 不够用
                // 把其它不是最多出现的字符替换以后，都不能填满这个滑动的窗口，这个时候须要考虑左边界向右移动
                // 移出滑动窗口的时候，频数数组须要相应地做减法
                freq[charArray[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public int characterReplacement(String s, int k) {

        int n = s.length();
        int[] freq = new int[26];
        char[] str = s.toCharArray();
        int right = 0, left = 0, maxCount = 0, result = 0;
        while (right < n) {

            freq[str[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[str[right] - 'A']);
            right++;

            if ((right - left) > k + maxCount) {
                freq[str[left] - 'A']--;
                left++;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }


//    public int characterReplacement(String s, int k) {
//
//        HashMap<Character, Integer> window = new HashMap();
//        int right = 0, left = 0, maxLen = -1, valid = k;
//        while (right < s.length()) {
//
//            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
//            right++;
//            Character maxValue1 = getMaxValue(window);
//            valid -= right - left - window.get(maxValue1);
//
//            while (valid <= 0) {
//                maxLen = Math.max(maxLen, right - left);
//                Character maxValue = getMaxValue(window);
//                if (s.charAt(left) != maxValue) {
//                    valid++;
//                }
//                window.put(maxValue, window.get(maxValue) - 1);
//                left++;
//            }
//        }
//        return maxLen + 1;
//    }
//
//    public Character getMaxValue(HashMap<Character, Integer> map) {
//
//        Character maxKey = null;
//        int maxValue = Integer.MIN_VALUE;
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > maxValue) {
//                maxKey = entry.getKey();
//                maxValue = entry.getValue();
//            }
//        }
//        return maxKey;
//    }
}
