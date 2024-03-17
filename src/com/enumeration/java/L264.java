package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//264. 丑数 II
public class L264 {


    public int nthUglyNumber1(int n) {

        HashMap<Integer, Boolean> dp = new HashMap<>();
        int count = 5, ans = 0;
        dp.put(0, false);
        for (int i = 1; i <= 5; i++) {
            dp.put(i, false);
        }
        if (n <= 5) {
            return n;
        }
        for (int i = 6; true; i++) {

            if (i % 2 == 0 && dp.get(i / 2) != null || i % 3 == 0 && dp.get(i / 3) != null || i % 5 == 0 && dp.get(i / 5) != null) {
                dp.put(i, true);
                count++;
            }
            if (count == n) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        int ans1 = 0, ans2 = 0, ans3 = 0, a = 1, b = 1, c = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {

            a = dp[ans1] * 2;
            b = dp[ans2] * 3;
            c = dp[ans3] * 5;

            int flag = Math.min(a, Math.min(b, c));
            dp[i] = flag;


            if (a <= flag) {
                ans1++;
            }
            if (b <= flag) {
                ans2++;
            }
            if (c <= flag) {
                ans3++;
            }
        }

        return dp[n - 1];
    }

    @Test
    public void test() {
        System.out.println(nthUglyNumber(2));
    }
}
