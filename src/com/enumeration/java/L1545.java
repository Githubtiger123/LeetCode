package com.enumeration.java;

import org.junit.Test;

//1545. 找出第 N 个二进制字符串中的第 K 位
public class L1545 {

    @Test
    public void test() {

        System.out.println(findKthBit(3, 1));
        System.out.println(findKthBit(4, 11));
        System.out.println(findKthBit(3, 2));
        System.out.println(findKthBit(2, 2));
        System.out.println(func(1));
        System.out.println(func(2));
        System.out.println(func(3));
        System.out.println(func(4));
    }

    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        while (sb.length() < k) {
            int i = sb.length() - 1;
            sb.append("1");
            while (i >= 0) {
                char c = sb.charAt(i--) == '1' ? '0' : '1';
                sb.append(c);
            }
        }
        return sb.charAt(k - 1);
    }

    public char findKthBit1(int n, int k) {
        String func = func(n);
        return func.charAt(k - 1);
    }

    public String func(int n) {

        if (n == 1) {
            return "0";
        } else {//Si = Si-1 + "1" + reverse(invert(Si-1))

            String s = func(n - 1);
            String invert = invert(s);
            return s + ("1") + (invert);
        }
    }

    public String invert(String s) {
        StringBuilder string = new StringBuilder("");
        char[] array = s.toCharArray();
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == '1') {
                string.append('0');
            } else {
                string.append('1');
            }
        }
        return string.toString();
    }
}
