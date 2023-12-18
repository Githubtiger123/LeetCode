package com.enumeration.java;

import org.junit.Test;

//134. 加油站
public class L134 {


    @Test
    public void test() {

        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int capacity = 0;
        boolean flag = false;
        int i = 0, n = gas.length;
        int k = i;
        while (true) {

            capacity += gas[i] - cost[i];
            i++;
            if (i == n) {
                i = 0;
                flag = true;
            }
            if (capacity < 0 && !flag) {
                k = i;
                capacity = 0;
            } else if (capacity < 0 && flag) {
                return -1;
            } else if (k == i) {
                return k;
            }
        }
    }

    //标准写发
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i]; //如果一圈过后小于零，那么在任意一位置都不行，反之肯定有答案
            if (curSum < 0) {
                index = (i + 1) % gas.length;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return index;
    }

    //暴力超时
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        for (int i = 0; i < cost.length; i++) {
            int rest = gas[i] - cost[i]; // 记录剩余油量
            int index = (i + 1) % cost.length;
            while (rest > 0 && index != i) { // 模拟以i为起点行驶一圈（如果有rest==0，那么答案就不唯一了）
                rest += gas[index] - cost[index];
                index = (index + 1) % cost.length;
            }
            // 如果以i为起点跑一圈，剩余油量>=0，返回该起始位置
            if (rest >= 0 && index == i) return i;
        }
        return -1;
    }


//    public int canCompleteCircuit(int[] gas, int[] cost) {
//
//        int capacity = 0, t = 0;
//        boolean flag = false;
//        int n = gas.length;
//        for (int i = 0; i < n; i++) {
//            t = 0;
//            flag = false;
//            for (int j = i; j < n; j++) {
//                t += (gas[j] - cost[j]);
//                if (t < 0) {
//                    flag = true;
//                }
//            }
//            System.out.println("capacity:" + capacity + ",t:" + t);
//            if (t >= capacity && gas[i] - cost[i] >= 0 && !flag) {
//                return i;
//            }
//            capacity += (gas[i] - cost[i]);
//        }
//        return -1;
//    }
}
