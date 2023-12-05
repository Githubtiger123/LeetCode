package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//17. 电话号码的字母组合
public class L17 {

    @Test
    public void test() {
        System.out.println(letterCombinations("9"));
    }

    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {

        ArrayList<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        dfs(0, digits, result, new StringBuilder());
        return result;
    }

    public void dfs(int i, String digits, List<String> result, StringBuilder s) {

        if (i == digits.length()) {
            result.add(s.toString());
        } else {

            int index = digits.charAt(i);
            String s1 = phoneMap.get((char) index);
            for (int j = 0; j < s1.length(); j++) {
                s.append(s1.charAt(j));
                dfs(i + 1, digits, result, s);
                s.deleteCharAt(i);
            }
        }
    }

//    private static final char[][] text = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
//
//    public List<String> letterCombinations(String digits) {
//
//        ArrayList<String> result = new ArrayList<>();
//        if (digits.isEmpty()) {
//            return result;
//        }
//        dfs(0, digits, result, "");
//        return result;
//    }
//
//    public void dfs(int i, String digits, List<String> result, String s) {
//
//        if (i == digits.length()) {
//            result.add(s);
//        } else if (digits.charAt(i) == '7' || digits.charAt(i) == '9') {
//            for (int j = 0; j < 4; j++) {
//                dfs(i + 1, digits, result, new String(s + text[digits.charAt(i) - '0'][j]));
//            }
//        } else {
//            for (int j = 0; j < 3; j++) {
//                dfs(i + 1, digits, result, new String(s + text[digits.charAt(i) - '0'][j]));
//            }
//        }
//    }
}
