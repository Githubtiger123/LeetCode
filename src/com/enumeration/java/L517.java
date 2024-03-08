package com.enumeration.java;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

//517. 超级洗衣机
public class L517 {


    public int findMinMoves(int[] machines) {

        int count = machines.length;
        int sum = 0, avg = 0, res = 0;
        for (int i = 0; i < count; i++) sum += machines[i];
        if ((sum / count) - (sum / (double) count) != 0) {
            return -1;
        }
        avg = sum / count;
        int[] nums = new int[count];
        int[] array = new int[count];
        nums[0] = machines[0] - avg;
        array[0] = nums[0];
        for (int i = 1; i < count; i++) {
            nums[i] = machines[i] - avg;
            array[i] = array[i - 1] + nums[i];
        }
        for (int i = 0; i < count; i++) {
            res = Math.max(res, Math.max(nums[i], Math.abs(array[i])));
        }

        return res;
    }

    @Test
    public void test() {


    }
}
