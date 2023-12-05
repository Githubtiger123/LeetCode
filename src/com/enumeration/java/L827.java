package com.enumeration.java;

import org.junit.Test;

//827. 最大人工岛
public class L827 {

    @Test
    public void test() {

    }

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static boolean isAdd;

    public int largestIsland(int[][] grid) {

        int max_len = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                isAdd = false;
                int l = dfs(grid, 0, i, j);
                max_len = Math.max(max_len, l);
            }
        }
        return max_len;
    }

    public int dfs(int[][] grid, int len, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        } else if (grid[i][j] == 0 && isAdd == false) {
            //继续
            isAdd = true;
            int sum = 0;
            for (int[] nums : directions) {
                sum += dfs(grid, len + 1, i + nums[0], j + nums[1]);
            }
            return sum;
        } else if (grid[i][j] != 0 && isAdd == true) {
            return 0;
        } else {

            int sum = 0;
            for (int[] nums : directions) {
                sum += dfs(grid, len + 1, i + nums[0], j + nums[1]);
            }
            return sum;
        }
    }
}
