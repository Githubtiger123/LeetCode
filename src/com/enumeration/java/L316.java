package com.enumeration.java;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Stack;

//316. 去除重复字母
public class L316 {

//    public String removeDuplicateLetters(String s) {
//
//        char[] array = s.toCharArray();
//        int i = 0, j = 0;
//        char min = Character.MIN_VALUE, index = 0;
//        while (i < array.length) {//bcabc
//            if (array[i] == Character.MIN_VALUE) {
//
//            }
//            j = i + 1;
//            min = Character.MIN_VALUE;
//            while (j < array.length) {
//                if (min > array[j]) {
//                    min = array[j];
//                }
//                if (array[j] == array[i]) {
//                    if (array[i] > min) {
//                        array[i] = Character.MIN_VALUE;
////                        i++;
//                    } else {
//                        array[j] = Character.MIN_VALUE;
//                    }
//                }
//                j++;
//            }
//            i++;
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int k = 0; k < array.length; k++) {
//            if (array[k] != Character.MIN_VALUE) {
//                stringBuilder.append(array[k]);
//            }
//        }
//        return new String(stringBuilder);
//    }

    public static String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c : array) {
//            if (hashMap.get(c) == null) {
//                hashMap.put(c, 1);
//            } else {
//                hashMap.put(c, hashMap.get(c) + 1);
//            }
            hashMap.merge(c, 1, Integer::sum);
            /*
            标注一
             */

        }
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty()) {
                stack.push(array[i]);
            } else {
                if (stack.search(array[i]) != -1) {
                    hashMap.put(array[i], hashMap.get(array[i]) - 1);
                    continue;
                }
                while (!stack.isEmpty() && hashMap.get(stack.peek()) > 1 && stack.peek() > array[i]) {
                    hashMap.put(stack.peek(), hashMap.get(stack.peek()) - 1);
                    stack.pop();
                }
                stack.push(array[i]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    /**
     * 注释一
     * 这行代码是Java中HashMap的一个常见用法，用于将指定的键值对合并到HashMap中。让我们来解释一下这行代码的含义：
     * <p>
     * java
     * hashMap.merge(c, 1, Integer::sum);
     * hashMap：表示一个HashMap对象，即要操作的HashMap实例。
     * c：表示要合并的键。
     * 1：表示要合并的值，如果键c已经存在于HashMap中，则将这个值与原值进行合并。
     * Integer::sum：表示一个函数，用于定义如何合并两个值。在这里，表示使用Integer类的sum方法将两个值相加。
     * 换句话说，这行代码的作用是：
     * <p>
     * 如果键c已经存在于HashMap中，则将其对应的值与1相加，并将结果放回HashMap中；
     * 如果键c不存在于HashMap中，则将键值对(c, 1)放入HashMap中。
     * 这种用法通常在需要对HashMap中的值进行计数或累加操作时非常有用。
     */

    public String removeDuplicateLetters1(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = removeDuplicateLetters("acbaba");
        System.out.println(s);
    }
}
