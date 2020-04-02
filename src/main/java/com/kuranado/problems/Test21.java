package com.kuranado.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-04-02 21:12
 */
public class Test21 {

    public static void main(String[] args) {
        // Test Sample 1 4
        //int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        // Test Sample 2 -1
        //int[][] grid = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        // Test Sample 3 0
        //int[][] grid = new int[][]{{0, 2}};
        // Test Sample 4 0
        //int[][] grid = new int[][]{{0}};
        // Test Sample 5 -1
        int[][] grid = new int[][]{{1, 1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{-1, 1, 0, 0};

        int freshOrangeNum = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    int[] point = new int[]{i, j};
                    queue.offer(point);
                }
                if (grid[i][j] == 1) {
                    freshOrangeNum++;
                }
            }
        }

        if (queue.isEmpty()) {
            if (freshOrangeNum > 0) {
                return -1;
            } else {
                return 0;
            }
        }

        int[] point = new int[0];
        while (!queue.isEmpty()) {
            point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = point[0] + dx[i];
                int nextY = point[1] + dy[i];
                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] == 1) {
                    grid[nextX][nextY] = grid[point[0]][point[1]] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return grid[point[0]][point[1]] - 2;
    }
}
