package com.kuranado.problems;

/**
 * 892. 三维形体的表面积
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-26 21:05
 */
public class Test14 {

    public static void main(String[] args) {
        // Test Sample 1 10
        int[][] grid = new int[][]{
            {2}};
        // Test Sample 2 34
        //int[][] grid = new int[][]{
        //    {1, 2},
        //    {3, 4}};
        // Test Sample 3 16
        //int[][] grid = new int[][]{
        //    {1, 0},
        //    {0, 2}};
        // Test Sample 4 32
        //int[][] grid = new int[][]{
        //    {1, 1, 1},
        //    {1, 0, 1},
        //    {1, 1, 1}};
        // Test Sample 5 46
        //int[][] grid = new int[][]{
        //    {2, 2, 2},
        //    {2, 1, 2},
        //    {2, 2, 2}};
        // Test Sample 6 0
        //int[][] grid = new int[][]{
        //    {0}};
        // Test Sample 7 6
        //int[][] grid = new int[][]{
        //    {1}};
        // Test Sample 8 6
        //int[][] grid = new int[][]{
        //    {0, 1, 0}};
        System.out.println(surfaceArea(grid));
    }

    public static int surfaceArea(int[][] grid) {
        int[][] tmp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            tmp[i][grid.length] = 0;
            tmp[grid.length][i] = 0;
            for (int j = 0; j < grid[i].length; j++) {
                tmp[i][j] = grid[i][j];
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    sum += 4 * tmp[i][j] + 2 - Math.min(tmp[i][j], tmp[i][j + 1]) - Math.min(tmp[i][j], tmp[i + 1][j]);
                }
                if (i > 0) {
                    sum -= Math.min(tmp[i][j], tmp[i - 1][j]);
                }
                if (j > 0) {
                    sum -= Math.min(tmp[i][j], tmp[i][j - 1]);
                }
            }
        }
        return sum;
    }
}
