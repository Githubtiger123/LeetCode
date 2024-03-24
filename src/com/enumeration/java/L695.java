package com.enumeration.java;

import org.junit.Test;

//695. 岛屿的最大面积
public class L695 {

    public int maxAreaOfIsland(int[][] grid) {

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {

            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        } else {

            grid[i][j] = 0;//标记为0防止重复
            int ans = 1;
            ans += dfs(grid, i - 1, j);
            ans += dfs(grid, i, j - 1);
            ans += dfs(grid, i + 1, j);
            ans += dfs(grid, i, j + 1);
            return ans;
        }

    }

    @Test
    public void test() {

        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] grid1 = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
//        System.out.println(maxAreaOfIsland(grid));
        System.out.println(maxAreaOfIsland(grid1));
    }
}
