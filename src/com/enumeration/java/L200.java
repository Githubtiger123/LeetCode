package com.enumeration.java;

import org.junit.Test;

//200. 岛屿数量
public class L200 {

    @Test
    public void test() {

        System.out.println(numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }

    public int numIslands(char[][] grid) {

        int count = 0;
        boolean[][] used = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                boolean dfs = dfs(grid, used, i, j);
                if (dfs) count++;
            }
        }
        return count;
    }

    public static final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean dfs(char[][] grid, boolean[][] used, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || used[i][j] || grid[i][j] == '0') {
            return false;
        } else {        //grid[i][j] == '1'

            used[i][j] = true;
            for (int[] nums : directions) {
                dfs(grid, used, i + nums[0], j + nums[1]);
            }
            return true;
        }
    }
}
