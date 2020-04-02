package com.kuranado.problems;

/**
 * 289. 生命游戏
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-04-02 22:39
 */
public class Test23 {

    public static void main(String[] args) {
        // Test Sample 1
        //{
        //    {0,0,0},
        //    {1,0,1},
        //    {0,1,1},
        //    {0,1,0}
        //}
        int[][] board = new int[][]{
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void gameOfLife(int[][] board) {

        int[][] result = new int[board.length][board[0].length];

        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{1, 0, -1, 1, -1, 1, 0, -1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];
                    if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length && board[nextX][nextY] == 1) {
                        live++;
                    }
                }
                if (board[i][j] == 1) {
                    if (live != 2 && live != 3) {
                        result[i][j] = 0;
                    } else {
                        result[i][j] = 1;
                    }
                }
                if (board[i][j] == 0) {
                    if (live == 3) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                board[i][j] = result[i][j];
            }
        }
    }
}
