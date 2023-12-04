package com.enumeration.java;

import org.junit.Test;

//130. 被围绕的区域
public class L130 {

    @Test
    public void test() {

    }

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int j = 0; j < board[0].length; j++) {
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public void dfs(char[][] board, int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == 'B') {
            return;
        } else if (board[i][j] == 'O') {
            board[i][j] = 'B';
            dfs(board, i + directions[0][0], j + directions[0][1]);
            dfs(board, i + directions[1][0], j + directions[1][1]);
            dfs(board, i + directions[2][0], j + directions[2][1]);
            dfs(board, i + directions[3][0], j + directions[3][1]);
        }

    }

//不对
//    public void solve(char[][] board) {
//
//
//        for(int i=0;i<board.length;i++) {
//            for(int j=0;j<board[0].length;j++) {
//                dfs(board,i,j);
//            }
//        }
//    }
//
//    private static final int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
//    public boolean dfs(char[][] board,int i,int j) {
//
//        if(i<0 || j <0 || i>=board.length || j>=board[0].length) {
//            return false;
//        }else if(board[i][j] == 'X'){
//            return true;
//        }else {
//
//            board[i][j] = 'X';
//            boolean dfs = dfs(board,i+directions[0][0],j+directions[0][1]);
//            boolean dfs2 = dfs(board,i+directions[1][0],j+directions[1][1]);
//            boolean dfs3 = dfs(board,i+directions[2][0],j+directions[2][1]);
//            boolean dfs1 = dfs(board,i+directions[3][0],j+directions[3][1]);
//            if(dfs&& dfs1&&dfs2&&dfs3) {
//                return true;
//            }else {
//                board[i][j] = 'O';
//                return false;
//            }
//        }
//
//    }
}
