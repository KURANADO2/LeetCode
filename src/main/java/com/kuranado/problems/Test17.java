package com.kuranado.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1162. 地图分析
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-29 10:19
 */
public class Test17 {

    public static void main(String[] args) {
        // Test Sample 1 2
        //int[][] grid = new int[][]{
        //    {1, 0, 1},
        //    {0, 0, 0},
        //    {1, 0, 1}
        //};
        // Test Sample 2 4
        //int[][] grid = new int[][]{
        //    {1, 0, 0},
        //    {0, 0, 0},
        //    {0, 0, 0}
        //};
        // Test Sample 3 3
        //int[][] grid = new int[][]{
        //    {1, 0, 0, 0, 0, 1},
        //    {0, 0, 0, 0, 0, 0},
        //    {0, 0, 0, 0, 0, 1},
        //    {0, 0, 0, 0, 0, 0},
        //    {1, 0, 0, 0, 0, 0},
        //    {1, 0, 1, 0, 0, 0}
        //};
        // Test Sample 4 -1
        //int[][] grid = new int[][]{
        //    {1}
        //};
        // Test Sample 5 -1
        int[][] grid = new int[][]{
            {0}
        };
        System.out.println(maxDistance(grid));
    }

    public static int maxDistance(int[][] grid) {

        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (queue.size() == 0 || queue.size() == grid.length * grid[0].length) {
            return -1;
        }

        int[] point = new int[]{};
        while (!queue.isEmpty()) {
            point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = point[0] + dx[i];
                int y = point[1] + dy[i];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0) {
                    grid[x][y] = grid[point[0]][point[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return grid[point[0]][point[1]] - 1;
    }
}
