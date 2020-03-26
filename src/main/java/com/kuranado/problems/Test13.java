package com.kuranado.problems;

/**
 * 999. 车的可用捕获量
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-26 20:16
 */
public class Test13 {

    public static void main(String[] args) {
        // Test Sample 1 3
        //char[][] board = new char[][]{
        //    {'.', '.', '.', '.', '.', '.', '.', '.'},
        //    {'.', '.', '.', 'p', '.', '.', '.', '.'},
        //    {'.', '.', '.', 'R', '.', '.', '.', 'p'},
        //    {'.', '.', '.', '.', '.', '.', '.', '.'},
        //    {'.', '.', '.', '.', '.', '.', '.', '.'},
        //    {'.', '.', '.', 'p', '.', '.', '.', '.'},
        //    {'.', '.', '.', '.', '.', '.', '.', '.'},
        //    {'.', '.', '.', '.', '.', '.', '.', '.'}};
        // Test Sample 2 0
        //char[][] board = new char[][]{
        //    {'.', '.', '.', '.', '.', '.', '.', '.'},
        //    {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
        //    {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
        //    {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
        //    {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
        //    {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
        //    {'.', '.', '.', '.', '.', '.', '.', '.'},
        //    {'.', '.', '.', '.', '.', '.', '.', '.'}};
        // Test Sample 3 3
        char[][] board = new char[][]{
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', 'p', '.', '.', '.', '.'},
            {'.', '.', '.', 'p', '.', '.', '.', '.'},
            {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', 'B', '.', '.', '.', '.'},
            {'.', '.', '.', 'p', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(numRookCaptures(board));
    }

    public static int numRookCaptures(char[][] board) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    // 上
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] == 'p') {
                            sum ++;
                            break;
                        }
                        if (board[k][j] == 'B') {
                            break;
                        }
                    }
                    // 下
                    for (int k = i + 1; k < 8; k++) {
                        if (board[k][j] == 'p') {
                            sum ++;
                            break;
                        }
                        if (board[k][j] == 'B') {
                            break;
                        }
                    }
                    // 左
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] == 'p') {
                            sum++;
                            break;
                        }
                        if (board[i][k] == 'B') {
                            break;
                        }
                    }
                    // 右
                    for (int k = j + 1; k < 8; k++) {
                        if (board[i][k] == 'p') {
                            sum++;
                            break;
                        }
                        if (board[i][k] == 'B') {
                            break;
                        }
                    }
                }
            }
        }
        return sum;
    }
}
