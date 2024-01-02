package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//630. 课程表 III
public class L630 {


    @Test
    public void test() {

        int[][] arr = new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        int[][] arr1 = new int[][]{{5,5},{4,6},{2,6}};
        System.out.println(scheduleCourse(arr1));
    }


    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        for (int i = 0; i < courses.length; i++) {
            System.out.print(Arrays.toString(courses[i]));
        }
        int[][] arr = new int[courses.length][2];
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (courses[i][0] <= courses[i][1]) {
                arr[n][0] = courses[i][0];
                arr[n][1] = courses[i][1];
                n++;
            }
        }

        int flag = 0, count = 0, last = 0;
        for (int i = 0; i < n; i++) {

            if (flag + arr[i][0] <= arr[i][1]) {
                flag = flag + arr[i][0];
                arr[i][1] = flag;
                last = i;
                count++;
            } else {
                if (flag - arr[last][0] + arr[i][0] <= flag) {
                    count++;
                    last = i;
                    flag = flag - arr[last][0] + arr[i][0];
                }
            }
        }

        return count;
    }
}
