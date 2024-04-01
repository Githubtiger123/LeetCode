package com.enumeration.java;

import java.util.ArrayList;
import java.util.List;

//51. N 皇后
public class L51 {

    List<List<String>> lists;

    private void backTracking(int[] temp, int m) {
        int len = temp.length;

        if (len == m) {

            printParse(temp);
            return;
        }

        for (int i = 0; i < len; i++) {

            temp[m] = i;
            boolean b = isPass(temp, m);
            if (b) {
                backTracking(temp, m + 1);
            }
        }
    }

    private boolean isPass(int[] temp, int n) {

        for (int i = 0; i < n; i++) {
            if (temp[i] == temp[n] || (Math.abs(n - i) == Math.abs(temp[n] - temp[i]))) {
                return false;
            }
        }
        return true;
    }

    private void printParse(int[] temp) {

        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            stringBuilder.append('.');
        }
        for (int i = 0; i < temp.length; i++) {
            int n = temp[i];
            StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
            stringBuilder1.setCharAt(n, 'Q');
            list.add(stringBuilder1.toString());
        }
        lists.add(list);
    }

    public List<List<String>> solveNQueens(int n) {
        lists = new ArrayList<>();
        int[] temp = new int[n];
        backTracking(temp, 0);
        return lists;
    }
}
