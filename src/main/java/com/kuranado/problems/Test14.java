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
        //int[][] grid = new int[][]{
        //    {2}};
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
        int[][] grid = new int[][]{
            {0, 1, 0}};
        System.out.println(surfaceArea(grid));
    }

    public static int surfaceArea(int[][] grid) {
       
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    sum += 4 * grid[i][j] + 2;
                }
                // 上边一列    
                if (i > 0) {
                    sum -= Math.min(grid[i][j], grid[i - 1][j]);
                }
                // 下边一列
                if (i < grid.length - 1) {
                    sum -= Math.min(grid[i][j], grid[i + 1][j]);
                }
                // 左边一列
                if (j > 0) {
                    sum -= Math.min(grid[i][j], grid[i][j - 1]);
                }
                // 右边一列
                if (j < grid[i].length - 1) {
                    sum -= Math.min(grid[i][j], grid[i][j + 1]);
                }
            }
        }
        return sum;
    }
}
