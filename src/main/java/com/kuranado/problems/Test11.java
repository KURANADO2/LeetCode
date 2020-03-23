package com.kuranado.problems;

/**
 * 37. 解数独
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-22 20:51
 */
public class Test11 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        printSudoku(board);
    }

    public static void solveSudoku(char[][] board) {
        fun(board, false);
    }

    static void fun(char[][] board, boolean solved) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int[] candidates = new int[10];
                    for (int m = 0; m < 9; m++) {
                        // 当行中已有数字
                        if (board[i][m] != '.') {
                            candidates[board[i][m] - 48]++;
                        }
                        // 当前列中已有数字
                        if (board[m][j] != '.') {
                            candidates[board[m][j] - 48]++;
                        }
                    }
                    // 当前 3 * 3 方格已有数字
                    int x = i / 3 * 3;
                    int y = j / 3 * 3;
                    for (int m = x; m < x + 3; m++) {
                        for (int n = y; n < y + 3; n++) {
                            if (board[m][n] != '.') {
                                candidates[board[m][n] - 48]++;
                            }
                        }
                    }
                    boolean flag = false;
                    for (int m = 1; m < candidates.length; m++) {
                        if (candidates[m] == 0) {
                            candidates[m] = -1;
                            flag = true;
                            board[i][j] = (char) (m + 48);
                            if (i == 8 && j == 8) {
                                solved = true;
                            }
                            solveSudoku(board);
                        }
                        if (solved) {
                            return;
                        }
                        if (candidates[m] == -1) {
                            flag = false;
                            board[i][j] = '.';
                        }
                    }
                    if (!flag) {
                        return;
                    }
                }
                if (i == 8 && j == 8) {
                    return;
                }
            }
        }
    }

    static void printSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
