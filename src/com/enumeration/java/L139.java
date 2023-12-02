package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//139. 单词拆分
public class L139 {

    @Test
    public void test() {

        System.out.println(minDistance("ros", "horse"));
        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("qwe", "w"));
        System.out.println(minDistance("dylxtzavqyljuxwvneofgaxkqxdvfbbguwowrgtwmiltocgmbtszlmvrxjeuyzsfndmfmwfpeficorikqnwiazmsaldmpsdbuyxgcbfzsdvwwyagpwlsavbhdoxjshwaloxrkhupkykiqybfbigtdwsosnzpslpyccfvygxwvdqziwtxmeiwakhxmipwrgxjipzlqskevpmdhtziwdywmygpsozhpdywumopwyxzthiacyvukgwhgfviatpggcwkmbveljkujlqultpujnqhfdjtscnijnazwiwvbovklzrjvzasrrunofskcinvrbdwzjprkytgherccclsvonzdpsvgbmnhcgdvjdwamratkgecxygzoacjeosvoythxbsgookxiahpxyazxqrfgagppkdflzbrmpxmthaqwjroygvqbawljrjjjqektkustacfnddkzzmwixopooazvenkuihkypoieqepadjcshbojcbczcovmy", "sxwmgzemymevjakkyyauyjzuqblijtflqjniudlwzgdoaymtekxuczfnofflcewrskknxevhzsdmdnizhnukwammssyvdydmpbykbfsbdafdsaavyoiszhoserqsrhowzmkcvjxhvnsnuimssknuhbvnlbqlfbufmaeeqxbiweynvdmfvemaikircnhlqtndllqtcvgljnjjkrhqwwoprqzyihnvghhxzmjpizruxcccceqpdisydxvhkcnwugcuounexppjsdmyhkuorppfeiuxdrujsqmdaocmoenbxcdcukhhcslnlnmhplxgkmedjnqegrjenknghdnexbmkkyyeyxvvyezpimswojxggyofdnjtqrqjhzrbdizjuzjucriwzesiubaucqnitupwceyicilyjixtuocoxuqyqpuqiqkdpawptqjtwexvndawzabpwrnlkxgfrovtaokdalinnaljfmsvmrlesyhucoytyxisyjf"));
    }

    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int replace = dp[i - 1][j - 1] + 1;
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }

        return dp[m][n];
    }

    public int minDistance(String word1, String word2) {
//        return func(word1.toCharArray(), word2.toCharArray(), 0, 0);


//        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//        for (int i = 0; i < word1.length() + 1; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return func2(word1.toCharArray(), word2.toCharArray(), 0, 0, dp);

        //方法三:动态规划
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[word1.length()][word2.length()] = 0;
        for (int i = word1.length(); i >= 0; i--) {
            for (int j = word2.length(); j >= 0; j--) {
                int ans = 0;
                if (i == str1.length && j == str2.length) {
                    ans = 0;
                } else if (i == str1.length) {
                    ans = str2.length - j;
                } else if (j == str2.length) {
                    ans = str1.length - i;
                } else if (str1[i] == str2[j]) {
                    ans = dp[i + 1][j + 1];
                } else {
                    int ans1 = 1 + dp[i + 1][j + 1];//改
                    int ans2 = 1 + dp[i][j + 1];//删
                    int ans3 = 1 + dp[i + 1][j];//插
                    ans = Math.min(ans1, Math.min(ans2, ans3));
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }

    //方法二:记忆化搜索,傻缓存,时间过但是很消耗内存
    public int func2(char[] str1, char[] str2, int i, int j, int[][] dp) {

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (i == str1.length && j == str2.length) {
            ans = 0;
        } else if (i == str1.length) {
            ans = str2.length - j;
        } else if (j == str2.length) {
            ans = str1.length - i;
        } else if (str1[i] == str2[j]) {
            ans = func2(str1, str2, i + 1, j + 1, dp);
        } else {
            int ans1 = 1 + func2(str1, str2, i + 1, j + 1, dp);//改
            int ans2 = 1 + func2(str1, str2, i, j + 1, dp);//删
            int ans3 = 1 + func2(str1, str2, i + 1, j, dp);//插
            ans = Math.min(ans1, Math.min(ans2, ans3));
        }
        dp[i][j] = ans;
        return ans;
    }

    //方法一:暴力递归(时间超出限制)
    public int func(char[] str1, char[] str2, int i, int j) {

        if (i == str1.length && j == str2.length) {
            return 0;
        } else if (i == str1.length) {
            return str2.length - j;
        } else if (j == str2.length) {
            return str1.length - i;
        } else if (str1[i] == str2[j]) {
            return func(str1, str2, i + 1, j + 1);
        } else {
            int ans1 = 1 + func(str1, str2, i + 1, j + 1);//改
            int ans2 = 1 + func(str1, str2, i, j + 1);//删
            int ans3 = 1 + func(str1, str2, i + 1, j);//插
            return Math.min(ans1, Math.min(ans2, ans3));
        }
    }
}
