package com.enumeration.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//871. 最低加油次数
public class L871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        // 如果目标距离小于等于初始油量，则不需要加油，直接返回0
        if (target <= startFuel) {
            return 0;
        }
        // 初始油量
        int to = startFuel;
        // 记录加油次数
        int ans = 0;
        // 创建一个优先队列，用于存放所有加油站的加油量，按照从大到小的顺序排序
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));

        // 遍历所有加油站
        for (int[] station : stations) {
            int position = station[0];
            int fuel = station[1];

            // 如果当前油量不足以到达下一个加油站，则从队列中取出最大加油量，并加油，同时记录加油次数
            if (to < position) {
                while (!queue.isEmpty() && to < position) {
                    to += queue.poll();
                    ans++;
                    // 如果当前油量加上所有加油站的加油量后，仍然不足以到达目标距离，则返回-1
                    if (to >= target) {
                        return ans;
                    }
                }
                // 如果当前油量仍然不足以到达下一个加油站，则返回-1
                if (to < position) {

                    return -1;
                }
            }
            // 将当前加油站的加油量加入队列
            queue.add(fuel);
        }

        // 遍历完所有加油站后，如果当前油量不足以到达目标距离，则返回-1
        while (!queue.isEmpty()) {
            to += queue.poll();
            ans++;
            if (to >= target) {
                return ans;
            }
        }
        return -1;
    }


//    public int minRefuelStops(int target, int startFuel, int[][] stations) {
//
//
//        int n = target;
//
//        int position = 0;
//        int index = 0, res = 0;
//        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
//
//        for (int i = 0; i < stations.length; i++) {
//
//            int temp = position;
//            position += (stations[i][0] - position);
//            startFuel -= position - temp;
//
//
//            if (startFuel < 0 && queue.isEmpty()) {
//                return -1;
//            }
//            //come on
//
//            if (startFuel < 0) {
//                res++;
//                startFuel += queue.poll();
//            }
//            queue.add(stations[i][1]);
//
//        }
//
//        if (queue.isEmpty()) {
//            return position < n - 1 ? -1 : res;
//        }
//        return queue.poll() + position < n - 1 ? -1 : res + 1;

//        while (position + startFuel <= n - 1) {
//
//            if (index < stations.length && position == stations[index][0]) {
//                queue.add(stations[index][1]);
//                index++;
//            }
//            if (startFuel <= 0 && !queue.isEmpty()) {
//
//                res++;
//                startFuel += queue.poll();
//            } else if (startFuel <= 0 && queue.isEmpty()) {
//                return -1;
//            }
//
//            if (index + 1 < stations.length) {
//                int temp = position;
//                position = Math.min(stations[index + 1][0] - position - 1, startFuel);
//                startFuel -= temp - position;
//            } else {
//                startFuel--;
//                position++;
//            }
//
//        }
//        return res;
//    }


    @Test
    public void test() {

        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(minRefuelStops(100, 10, stations));
    }
}
