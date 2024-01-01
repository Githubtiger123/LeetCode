package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//1029. 两地调度
public class L1029 {


    @Test
    public void test() {


        int[][] arr = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(twoCitySchedCost(arr));
    }


    public int twoCitySchedCost(int[][] costs) {

        int n = costs.length / 2;
        int ans = 0;
        Arrays.sort(costs, (a, b) -> -((a[0] - a[1]) - (b[0] - b[1])));
//        for (int i = 0; i < n * 2; i++) {
//            System.out.print(Arrays.toString(costs[i]));
//        }
        for (int i = 0; i < n; i++) {
            ans += costs[i][1];
        }
        for (int i = n * 2 - 1; i >= n; i--) {
            ans += costs[i][0];
        }

        return ans;
    }
}
