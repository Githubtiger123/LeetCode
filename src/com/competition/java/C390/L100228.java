package com.competition.java.C390;

import org.junit.Test;

//100228. 执行操作使数据元素之和大于等于 K
public class L100228 {

    public int minOperations(int k) {

        int sum_before = 1, sum = 1, max_before = 1, max = 1;
        int count = 0;
        while (true) {

            if (sum >= k) {
                break;
            }

//            if (sum_before + 1 >= sum_before + max_before) {
//                sum = sum_before + 1;
//                max = max_before + 1;
//            } else {
//                sum = sum_before + max_before;
//                max = max_before;
//            }

            if (2 * max_before <= k - sum_before) {
                sum = sum_before + max_before;
                max = max_before;
            } else {
                sum = sum_before + 1;
                max = max_before + 1;
            }

            sum_before = sum;
            max_before = max;

            count++;
        }
        return count;
    }

    @Test
    public void test() {

        System.out.println(minOperations(11));
        System.out.println(minOperations(1));
        System.out.println(minOperations(2));
        System.out.println(minOperations(3));
        System.out.println(minOperations(4));
    }
}
