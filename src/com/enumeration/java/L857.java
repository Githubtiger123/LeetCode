package com.enumeration.java;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

//857. 雇佣 K 名工人的最低成本
public class L857 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        int n = quality.length;
        double[][] worker = new double[n][3];
        for (int i = 0; i < n; i++) {
            worker[i][0] = quality[i];
            worker[i][1] = wage[i];
            worker[i][2] = (double) quality[i] / wage[i];
        }
        Arrays.sort(worker, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {

                return Double.compare(o1[2], o2[2]);
            }
        });

        double ratio = worker[k - 1][2], ans = 0;
        for (int i = 0; i < k; i++) {
            ans += worker[i][0] / ratio;
        }
        return ans;
    }
}
