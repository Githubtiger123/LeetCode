package com.enumeration.java;

//45. 跳跃游戏 II
public class L45 {

    public int jump(int[] nums) {

        int step = 0;
        int n = nums.length;
        int cur = 0, next = 0;

        for (int i = 0; i < n; i++) {
            if (cur < i) {
                step++;
                cur = next;
                next = 0;
            }
//
            next = Math.max(next, i + nums[i]);
        }
        return step;
    }
}
