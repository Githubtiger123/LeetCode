package com.enumeration.java;

import org.junit.Test;

//10. 正则表达式匹配
public class L10 {


    //s:源,p:目标
    private boolean func(String s, String p) {

        boolean match = false;
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        if (!s.isEmpty()) {

            match = s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
        }
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return match && func(s.substring(1), p) || func(s, p.substring(2));
        }
        return match && func(s.substring(1), p.substring(1));
    }


    public boolean isMatch(String s, String p) {

        return func(s, p);
    }

    @Test
    public void test() {

        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("a", "."));
        System.out.println(isMatch("aba", "*c*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aab", ".*"));
        System.out.println(isMatch("aa", "**"));
//        System.out.println(isMatch("asdfghhjgfdrseawq", "*h*r*e*"));
    }
}
