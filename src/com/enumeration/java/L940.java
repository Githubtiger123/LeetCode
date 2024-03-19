package com.enumeration.java;

import org.junit.Test;

//940. 不同的子序列 II
public class L940 {

    public int distinctSubseqII1(String s) {

        long[] letter = new long[26];
        long MOD = 1000000007;
        char[] chars = s.toCharArray();
        long all = 1;
        int n = s.length();
        for (int i = 0; i < n; i++) {

            long temp = all;
            all = ((all * 2) % MOD - letter[chars[i] - 'a'] + MOD) % MOD;
            letter[chars[i] - 'a'] += (all - temp + MOD) % MOD;
        }

//        long ans = 0;
//        for (int i = 0; i < 26; i++) {
//
//            ans += letter[i];
//            ans %= MOD;
//        }
//        return (int) ans;

        return (int) ((all - 1) % MOD);
    }

    public int distinctSubseqII(String s) {

        int[] letter = new int[26];
        int MOD = 1000000007;
        char[] chars = s.toCharArray();
        int all = 1;
        int n = s.length();
        for (int i = 0; i < n; i++) {

            int newAdd = (all - letter[chars[i] - 'a'] + MOD) % MOD;
            all = (all + newAdd) % MOD;
            letter[chars[i] - 'a'] = (letter[chars[i] - 'a'] + newAdd) % MOD;
        }
        return (all - 1 + MOD) % MOD;
    }

    @Test
    public void test() {

        System.out.println(distinctSubseqII("abc"));
        System.out.println(distinctSubseqII("aba"));
        System.out.println(distinctSubseqII("aaa"));
        System.out.println(distinctSubseqII("aaa"));
        System.out.println(distinctSubseqII("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn"));
    }
}
