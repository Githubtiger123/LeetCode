package com.competition.java.C374;

import org.junit.Test;

import java.util.Arrays;
import java.util.Hashtable;

//2953. 统计完全子字符串
public class L2953 {

    @Test
    public void test() {

        System.out.println(countCompleteSubstrings("aaabbbccc", 3));
    }

    public int countCompleteSubstrings(String word, int k) {

        int i = 0, j, sum = 0;
        char[] str = word.toCharArray();
        while (i < word.length()) {
            j = i;
            j++;
            while (j < word.length() && Math.abs(str[j] - str[j - 1]) <= 2) {
                j++;
            }
            sum += f(word.substring(i, j), k);
            System.out.println(word.substring(i, j));
            i = j;
        }
        return sum;
    }

    // 定义一个私有的int类型的方法f，接收两个参数，一个是字符串s，一个是int类型的k
    private int f(String s, int k) {

        // 将字符串s转换为字符数组
        char[] array = s.toCharArray();
        int ans = 0;
        // 遍历1到26，且m*k小于等于字符串s的长度
        for (int m = 1; m <= 26 && m * k <= s.length(); m++) {
            // 定义一个长度为26的int类型数组，用于统计每个字母出现的次数
            int[] cnt = new int[26];
            // 遍历字符数组
            for (int right = 0; right < array.length; right++) {
                // 统计每个字母出现的次数
                cnt[array[right] - 'a']++;
                // 计算左指针的位置
                int left = (right + 1) - m * k;
                // 如果左指针的位置大于等于0
                if (left >= 0) {
                    // 定义一个boolean类型的变量，用于判断是否满足条件
                    boolean flag = true;
                    // 遍历26个字母
                    for (int i = 0; i < 26; i++) {
                        // 如果某个字母出现的次数不为0且不等于k
                        if (cnt[i] != 0 && cnt[i] != k) {
                            // 将flag设置为false
                            flag = false;
                            // 跳出循环
                            break;
                        }
                    }
                    // 如果满足条件，ans加1
                    if (flag) ans++;
                    // 将左指针指向的字母出现的次数减1
                    cnt[array[left] - 'a']--;
                }
            }
        }


        // 返回ans
        return ans;
    }
}
