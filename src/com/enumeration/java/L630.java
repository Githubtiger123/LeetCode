package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

//630. 课程表 III
public class L630 {


    @Test
    public void test() {

        int[][] arr = new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        int[][] arr1 = new int[][]{{5, 5}, {4, 6}, {2, 6}};
        int[][] arr2 = new int[][]{{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}};
        System.out.println(scheduleCourse(arr2));
    }

//    public int scheduleCourse(int[][] courses) {
//
//        Arrays.sort(courses, (a, b) -> (a[0] - b[0] == 0 ? (a[1] - b[1]) : a[0] - b[0]));
//        for (int i = 0; i < courses.length; i++) {
//            System.out.print(Arrays.toString(courses[i]));
//        }
//        int[][] arr = new int[courses.length][2];
//        int n = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (courses[i][0] <= courses[i][1]) {
//                arr[n][0] = courses[i][0];
//                arr[n][1] = courses[i][1];
//                n++;
//            }
//        }
//
//        int flag = 0, count = 0, last = 0;
//        for (int i = 0; i < n; i++) {
//            if(flag+arr[i][0] <= arr[i][1]){
//                count++;
//                flag += arr[i][0];
//            }else {
//                break;
//            }
//        }
//
//        return count;
//    }


//    public int scheduleCourse(int[][] courses) {
//
//        Arrays.sort(courses, (a, b) -> (a[1] - b[1] == 0 ? -(a[0] - b[0]) : a[1] - b[1]));
//        int n = courses.length;
//
//        int flag = 0, count = 0;
//        for (int i = 0; i < n; i++) {
//            if (flag + courses[i][0] <= courses[i][1]) {
//                flag = flag + courses[i][0];
//                courses[i][1] = flag;
//                count++;
//            } else {
//
//                int max = 0;
//                for (int j = 0; j < i; j++) {
//                    if (courses[j][1] != -1) {
//                        if (courses[max][0] < courses[j][0]) {
//                            max = j;
//                        }
//                    }
//                }
//
//                if (count == 0){
//                    courses[max][1] = -1;
//                    continue;
//                }
//                if (courses[max][0] > courses[i][0]) {
//                    flag = flag - courses[max][0] + courses[i][0];
//                }
//                courses[max][1] = -1;
//            }
//        }
//        return count;
//    }

    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> (a[1] - b[1] == 0 ? (a[0] - b[0]) : a[1] - b[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int time = 0;
        int n = courses.length;
        for (int i = 0; i < n; i++) {
            if (time + courses[i][0] <= courses[i][1]) {
                queue.add(courses[i][0]);
                time = time + courses[i][0];
            } else {
                if (!queue.isEmpty() && queue.peek() > courses[i][0]) {
                    time = time - queue.poll() + courses[i][0];
                    queue.add(courses[i][0]);
                }
            }
        }

        return queue.size();
    }
}
