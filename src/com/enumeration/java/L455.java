package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//455. 分发饼干
public class L455 {

    @Test
    public void test() {

        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{3}));
    }

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0, m = g.length, n = s.length;
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            while (j < n && g[i] > s[j]) {
                j++;
            }
            if (j < n) {
                count++;
            }
        }
        return count;
    }
}
