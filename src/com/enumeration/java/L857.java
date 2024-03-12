package com.enumeration.java;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//857. 雇佣 K 名工人的最低成本
public class L857 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        int n = quality.length;
        double[][] worker = new double[n][3];
        for (int i = 0; i < n; i++) {
            worker[i][0] = quality[i];
            worker[i][1] = wage[i];
            worker[i][2] = (double) wage[i] / quality[i];
        }
        Arrays.sort(worker, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {

                return Double.compare(o1[2], o2[2]);
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int sum = 0, count = 0;
        double ans = 0;
        for (int i = 0; i < n; i++) {
            if (count < k) {
                queue.offer((int) worker[i][0]);
                sum += (int) worker[i][0];
                count++;
                if (k == count) {
                    ans = sum * worker[i][2];
                }
            } else {

                Integer peek = queue.peek();
                if (worker[i][0] < peek) {
                    sum -= queue.poll();
                    sum += worker[i][0];
                    queue.offer((int) worker[i][0]);
                    ans = Math.min(ans, sum * worker[i][2]);
                }
            }
        }

        return ans;
    }

    @Test
    public void test() {

        System.out.println(mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
    }
}
