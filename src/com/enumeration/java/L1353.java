package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//1353. 最多可以参加的会议数目
public class L1353 {

//    超时
//    public static int maxEvents(int[][] events) {
//
//        Arrays.sort(events, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//
//                return o1[1] - o2[1];
//            }
//        });
//
//        int count = 0;
//        int day = events[events.length - 1][1];
//        int n = events.length;
//        boolean[] days = new boolean[day];
//        for (int i = 0; i < day; i++) {
//            if (days[i] == true) {
//                continue;
//            }
//            for (int j = 0; j < n; j++) {
//                if (events[j][0] == -1) {
//                    continue;
//                }
//                if (events[j][0] <= i + 1 && events[j][1] >= i + 1) {
//
//                    days[i] = true;
//                    events[j][0] = -1;
//                    events[j][1] = -1;
//                    break;
//                }
//            }
//        }
//        for (int i = 0; i < day; i++) {
//            if (days[i] == true) {
//                count++;
//            }
//        }
//        return count;
//    }

    public static int maxEvents(int[][] events) {

        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//小根堆存储结束时间
        int n = events.length, i = 0, currDay = 1, res = 0;
        //i是会议，currDay代表天数，res代表参加过的会议(要返回的结果)
        while (i < n || !minHeap.isEmpty()) {//判断所有的会议是否全部处理遍历完成

            while (i < n && events[i][0] == currDay) { //将这一天开始的所有会议加入到小根堆中

                minHeap.add(events[i][1]);//只需要结束时间(只有结束时间有价值)
                i++;
            }
            while (!minHeap.isEmpty() && minHeap.peek() < currDay) { //判断并且将结束时间比今天更早的会议弹出(已将赶不上了)
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {//判断是不是空，是则是今天没有参加任何会议，不是则参加了一次
                res++;//将结果加一
                minHeap.poll();//弹出此次参见过的会议
            }
            currDay++;//天数加一
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}}));
    }
}
