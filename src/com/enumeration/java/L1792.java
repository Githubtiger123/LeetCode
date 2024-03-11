package com.enumeration.java;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//1792. 最大平均通过率
public class L1792 {


    public double maxAverageRatio(int[][] classes, int extraStudents) {


        double sum = 0, n = classes.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return -Double.compare((o1[0] + 1.0) / (o1[1] + 1.0) - ((double) o1[0] / o1[1]), (o2[0] + 1.0) / (o2[1] + 1.0) - ((double) o2[0] / o2[1]));
            }
        });

//        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Double.compare(((b[0] + 1.0) / (b[1] + 1.0) - (double) b[0] / b[1]), ((a[0] + 1.0) / (a[1] + 1.0) - (double) a[0] / a[1])));
        for (int i = 0; i < n; i++) {
            queue.add(classes[i]);
        }

        while (!queue.isEmpty() && extraStudents != 0) {

            int[] poll = queue.poll();
            if (poll[0] == poll[1]) {
                sum++;
                continue;
            }
            poll[0]++;
            poll[1]++;
            queue.add(poll);
            extraStudents--;
        }
        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            sum += (double) poll[0] / poll[1];
        }
        return sum / n;
    }

    @Test
    public void test() {
        System.out.println(maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
    }
}
