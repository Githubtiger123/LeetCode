package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//639. 解码方法 II
public class L639 {


    long func(char[] chars, int index) {

        if (index == chars.length) {
            return 1;
        } else if (chars[index] == '0') {
            return 0;
        } else {
            long ans = 0;
            if (chars[index] == '*') {

                for (int i = '1'; i <= '9'; i++) {

                    if (index + 1 < chars.length && chars[index + 1] != '*' && (i - '0') * 10 + chars[index + 1] - '0' <= 26) {

                        ans += func(chars, index + 2);
                    } else if (index + 1 < chars.length && chars[index + 1] == '*') {
                        for (int j = '1'; j <= '9'; j++) {
                            if ((i - '0') * 10 + j - '0' <= 26) {
                                ans += func(chars, index + 2);
                            }
                        }
                    }
                    ans += func(chars, index + 1);
                }

            } else {
                if (index + 1 < chars.length && chars[index + 1] != '*' && (chars[index] - '0') * 10 + chars[index + 1] - '0' <= 26) {

                    ans += func(chars, index + 2);
                } else if (index + 1 < chars.length && chars[index + 1] == '*') {
                    for (int i = '1'; i <= '9'; i++) {
                        if ((chars[index] - '0') * 10 + i - '0' <= 26) {
                            ans += func(chars, index + 2);
                        }
                    }
                }
                ans += func(chars, index + 1);
            }
            return ans;
        }
    }

    long func1_1(char[] chars, int index, long[] dp) {

        if (dp[index] != Long.MIN_VALUE) {

            return dp[index];
        }

        long ans = 0;
        if (index == chars.length) {
            ans = 1;
        } else if (chars[index] == '0') {
            ans = 0;
        } else {
            ans = func1_1(chars, index + 1, dp) * (chars[index] == '*' ? 9 : 1);
            if (index + 1 < chars.length) {

                if (chars[index] != '*') {

                    if (chars[index + 1] != '*') {

                        if ((chars[index] - '0') * 10 + chars[index + 1] - '0' <= 26) {
                            ans += func1_1(chars, index + 2, dp);
                        }
                    } else {//num *

                        if (chars[index] == '1') {
                            ans += func1_1(chars, index + 2, dp) * 9;
                        } else if (chars[index] == '2') {
                            ans += func1_1(chars, index + 2, dp) * 6;
                        }
                    }
                } else {

                    if (chars[index + 1] != '*') { //* num
                        if (chars[index + 1] <= '6') {
                            ans += func1_1(chars, index + 2, dp) * 2;
                        } else {
                            ans += func1_1(chars, index + 2, dp);
                        }
                    } else {//* *
                        ans += func1_1(chars, index + 2, dp) * 15;
                    }

                }
            }

        }
        ans %= (1000000007);//10e8+7
        dp[index] = ans;
        return ans;
    }

    long func1(char[] chars, int index, long[] dp) {

        if (dp[index] != Long.MIN_VALUE) {

            return dp[index];
        }

        long ans = 0;
        if (index == chars.length) {
            ans = 1;
        } else if (chars[index] == '0') {
            ans = 0;
        } else {
            ans = func1(chars, index + 1, dp) * (chars[index] == '*' ? 9 : 1);
            if (index + 1 < chars.length) {

                if (chars[index] != '*') {

                    if (chars[index + 1] != '*') {

                        if ((chars[index] - '0') * 10 + chars[index + 1] - '0' <= 26) {
                            ans += func1(chars, index + 2, dp);
                        }
                    } else {//num *

                        if (chars[index] == '1') {
                            ans += func1(chars, index + 2, dp) * 9;
                        } else if (chars[index] == '2') {
                            ans += func1(chars, index + 2, dp) * 6;
                        }
                    }
                } else {

                    if (chars[index + 1] != '*') { //* num
                        if (chars[index + 1] <= '6') {
                            ans += func1(chars, index + 2, dp) * 2;
                        } else {
                            ans += func1(chars, index + 2, dp);
                        }
                    } else {//* *
                        ans += func1(chars, index + 2, dp) * 15;
                    }

                }
            }

        }
        ans %= (1000000007);
        dp[index] = ans;
        return ans;
    }


    public int numDecodings(String s) {

        long[] dp = new long[s.length() + 1];
        Arrays.fill(dp, Long.MIN_VALUE);
//        return (int) (func1(s.toCharArray(), 0, dp) %  (10e9 + 7));
        return (int) (func1(s.toCharArray(), 0, dp));
    }

    @Test
    public void test() {

        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("11106"));
        System.out.println(numDecodings("*"));
        System.out.println(numDecodings("1*"));
        System.out.println(numDecodings("2*"));
        System.out.println(numDecodings("**"));
    }
}
