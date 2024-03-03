package com.enumeration.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//502. IPO
public class L502 {


    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            ints[i][0] = capital[i];
            ints[i][1] = profits[i];
        }
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[0] - o2[0];
            }
        });

        int index = 0;
        for (int i = 0; i < k; i++) {

            while (index < n && ints[index][0] <= w) {
                queue.add(ints[index][1]);
                index++;
            }

            if (!queue.isEmpty()) {
                w += queue.poll();
            }
        }
        return w;
    }
}
