package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//79. 单词搜索
public class L79 {

    @Test
    public void test() {
        char[][] arr = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(arr, "ABCCED"));
    }

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {

        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                boolean dfs = dfs(board, word, 0, i, j, used);
                if (dfs) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int len, int i, int j, boolean used[][]) {

        if (len == word.length()) {
            return true;
        } else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j] || word.charAt(len) != board[i][j]) {
            return false;
        } else {

            used[i][j] = true;
            for (int[] arr : directions) {
                boolean b = dfs(board, word, len + 1, i + arr[0], j + arr[1], used);
                if (b) return b;
            }

            used[i][j] = false;
            return false;
        }
    }
}
