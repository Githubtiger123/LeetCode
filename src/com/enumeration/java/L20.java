package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//22. 括号生成
public class L20 {

    @Test
    public void test() {

        System.out.println(generateParenthesis(8));
    }

    public List<String> generateParenthesis(int n) {

        ArrayList<String> list = new ArrayList<>();
        dfs(n, n, list, "");
        return list;
    }

    public void dfs(int left, int right, List<String> result, String s) {

        if (left == 0 && right == 0) {
            result.add(new String(s));
        } else if (right == left) {
            s += '(';
            dfs(left - 1, right, result, new String(s));
        } else if (left == 0) {
            s += ')';
            dfs(left, right - 1, result, new String(s));
        } else {
            String s1 = new String(s);
            s += ')';
            dfs(left, right - 1, result, new String(s));
            s1 += '(';
            dfs(left - 1, right, result, new String(s1));
        }
    }
}
