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
        // Test Sample 1
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
        // Answer
        // 5  3  4  6  7  8  9  1  2
        // 6  7  2  1  9  5  3  4  8
        // 1  9  8  3  4  2  5  6  7
        // 8  5  9  7  6  1  4  2  3
        // 4  2  6  8  5  3  7  9  1
        // 7  1  3  9  2  4  8  5  6
        // 9  6  1  5  3  7  2  8  4
        // 2  8  7  4  1  9  6  3  5
        // 3  4  5  2  8  6  1  7  9

        // Test Sample 2
        //char[][] board = new char[][]{
        //    {'.','.','9','7','4','8','.','.','.'},
        //    {'7','.','.','.','.','.','.','.','.'},
        //    {'.','2','.','1','.','9','.','.','.'},
        //    {'.','.','7','.','.','.','2','4','.'},
        //    {'.','6','4','.','1','.','5','9','.'},
        //    {'.','9','8','.','.','.','3','.','.'},
        //    {'.','.','.','8','.','3','.','2','.'},
        //    {'.','.','.','.','.','.','.','.','6'},
        //    {'.','.','.','2','7','5','9','.','.'}};
        // Answer
        // 5  1  9  7  4  8  6  3  2
        // 7  8  3  6  5  2  4  1  9
        // 4  2  6  1  3  9  8  7  5
        // 3  5  7  9  8  6  2  4  1
        // 2  6  4  3  1  7  5  9  8
        // 1  9  8  5  2  4  3  6  7
        // 9  7  5  8  6  3  1  2  4
        // 8  3  2  4  9  1  7  5  6
        // 6  4  1  2  7  5  9  8  3

        solveSudoku(board);
        printSudoku(board);
    }

    private static void solveSudoku(char[][] board) {
        fun(board, false);
    }

    private static boolean fun(char[][] board, boolean solved) {
        boolean s = solved;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (solved) {
                    return true;
                }
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
                                s = true;
                            }
                            s = fun(board, s);
                        }
                        if (s) {
                            return true;
                        }
                        if (candidates[m] == -1) {
                            flag = false;
                            board[i][j] = '.';
                        }
                    }
                    if (!flag) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void printSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
