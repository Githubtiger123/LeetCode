package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

//1553. 吃掉 N 个橘子的最少天数
public class L1553 {

    @Test
    public void test() {
        System.out.println(minDays(900));
    }

    public int minDays(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return dfs2(n, map);


        //改用动态规划(这个不对,卡内存)
//        int[] dp = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//
//            int ans1 = 0, ans2 = Integer.MAX_VALUE, ans3 = Integer.MAX_VALUE;
//            ans1 = 1 + dp[i - 1];
//            if (i % 2 == 0) {
//                ans2 = 1 + dp[i / 2];
//            }
//            if (i % 3 == 0) {
//                ans3 = 1 + dp[i - (2 * (i / 3))];
//            }
//            int ans = Math.min(ans1, Math.min(ans2, ans3));
//            dp[i] = ans;
//        }
////        System.out.println(Arrays.toString(dp));
//        return dp[n];
    }

    public int dfs2(int n, HashMap<Integer, Integer> map) {
        if (map.get(n) != null) {
            return map.get(n);
        }
        int ans = 0;

        if (n <= 1) {
            ans = n;
        } else {

            int ans1 = n % 2 + 1 + dfs2(n / 2, map);
            int ans2 = n % 3 + 1 + dfs2((n / 3), map);
            ans = Math.min(ans1, ans2);
        }
        map.put(n, ans);
        return ans;
    }


    //DFS优化过后可以通过,注意递归调用的顺序2/3 --> 1/2 --> 1(这样写也是错的)
    public int dfs1(int n, HashMap<Integer, Integer> map) {

        if (map.get(n) != null) {
            return map.get(n);
        }
        int ans = 0;
        if (n == 0) {
            ans = 0;
        } else if (n == 1) {
            ans = 1;
        } else if (n % 2 == 0) {
            ans = 1 + dfs1(n / 2, map);
        } else if (n % 3 == 0) {
            ans = 1 + dfs1(n - (2 * (n / 3)), map);
        } else {
            ans = 1 + dfs1(n - 1, map);
        }
        map.put(n, ans);
        return ans;
    }

    //直接暴力递归不行(其实是想法错了)
    public int dfs(int n, HashMap<Integer, Integer> map) {

        if (map.get(n) != null) {
            return map.get(n);
        }
        int ans = 0;
        if (n == 0) {
            ans = 0;
        } else {
            int ans1 = 0, ans2 = Integer.MAX_VALUE, ans3 = Integer.MAX_VALUE;
            ans1 = 1 + dfs(n - 1, map);
            if (n % 2 == 0) {
                ans2 = 1 + dfs(n / 2, map);
            }
            if (n % 3 == 0) {
                ans3 = 1 + dfs(n - (2 * (n / 3)), map);
            }
            ans = Math.min(ans1, Math.min(ans2, ans3));
        }
        map.put(n, ans);
        return ans;
    }
}
