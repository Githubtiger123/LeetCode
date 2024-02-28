package com.enumeration.java;

import java.util.ArrayList;
import java.util.List;

//54. 螺旋矩阵
public class L54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0, end = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int direction = 1, x = 0, y = 0;
        List<Integer> list = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) {
                list.add(Integer.valueOf(matrix[top][i]));
            }
            if (++top > end) {
                break;
            }

            for (int i = top; i <= end; i++) {
                list.add(Integer.valueOf(matrix[i][right]));
            }
            if (--right < left) {
                break;
            }

            for (int i = right; i >= left; i--) {
                list.add(Integer.valueOf(matrix[end][i]));
            }
            if (top > --end) {
                break;
            }

            for (int i = end; i >= top; i--) {
                list.add(Integer.valueOf(matrix[i][left]));
            }
            if (++left > right) {
                break;
            }
        }
        return list;
    }
}
