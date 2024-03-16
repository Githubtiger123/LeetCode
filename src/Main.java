import java.util.Arrays;

public class Main {

    static int func(char[] chars, int index) {

        if (index == chars.length) {
            return 1;
        } else if (chars[index] == '0') {
            return 0;
        } else {
            int ans = 0;
            if (index + 1 < chars.length && (chars[index] - '0') * 10 + chars[index + 1] - '0' <= 26) {

                ans += func(chars, index + 2);
            }
            ans += func(chars, index + 1);

            return ans;
        }
    }

    static int func1(char[] chars, int index, int[] dp) {

        if (dp[index] != Integer.MIN_VALUE) {
            return dp[index];
        }

        int ans = 0;
        if (index == chars.length) {
            ans = 1;
        } else if (chars[index] == '0') {
            ans = 0;
        } else {
            if (index + 1 < chars.length && (chars[index] - '0') * 10 + chars[index + 1] - '0' <= 26) {

                ans += func1(chars, index + 2, dp);
            }
            ans += func1(chars, index + 1, dp);
        }
        dp[index] = ans;
        return ans;
    }


    public static int numDecodings(String s) {
//        int n = s.length();
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, Integer.MIN_VALUE);
//        return func1(s.toCharArray(), 0, dp);

        int n = s.length();
        int[] dp = new int[n + 1];
        char[] chars = s.toCharArray();
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {

            if (chars[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < chars.length && (chars[i] - '0') * 10 + chars[i + 1] - '0' <= 26) {

                    dp[i] += dp[i + 2];
                }

            }
        }
        return dp[0];
    }

    public static void main(String[] args) {

        System.out.println(numDecodings("11106"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
    }
}
