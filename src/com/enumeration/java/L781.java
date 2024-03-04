package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//781. 森林中的兔子
public class L781 {
    public int numRabbits(int[] answers) {

        Arrays.sort(answers);
        int num = 0, count = 0;
        int res = 0;
        int start = 0;
        int n = answers.length;
        while (start < n) {

            boolean flag = false;
            count = 1;
            num = answers[start++];
            while (start < n && num == answers[start]) {
                if (num == 0) {
                    res += 1;
                    start++;
                    continue;
                }

                count++;
                start++;
                if (count >= num + 1) {

                    flag = true;
                    res = res + num + 1;
                    break;
                }
            }
            if (!flag) {
                res += num + 1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(numRabbits(new int[]{0, 0}));
    }
}
