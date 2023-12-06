package com.enumeration.java;

import org.junit.Test;

//392. 判断子序列
public class L392 {

    @Test
    public void test() {

        System.out.println(isSubsequence("", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {

        if (s.length() == 0) return true;

        int i = 0, j = 0;
        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
            if (i == s.length()) {
                return true;
            }
        }
        return false;
    }
}
