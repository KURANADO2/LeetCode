package com.kuranado.problems;

import java.util.Stack;

/**
 * 42. 接雨水
 *
 * @author Xinling Jing
 * @date 2020-04-05 10:51
 * @since 1.0.0
 */
public class Test24 {

    public static void main(String[] args) {
        // Test Sample 1 6
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // Test Sample 2 0
        //int[] height = new int[]{0};
        // Test Sample 3 1
        //int[] height = new int[]{1, 0, 5};
        // Test Sample 4 1
        //int[] height = new int[]{4, 2, 3};
        // Test Sample 5 0
        //int[] height = new int[]{};
        System.out.println(trap4(height));
    }

    /**
     * 暴力法 123 ms 战胜 5.30%
     */
    private static int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            int lMax = -1;
            int rMax = -1;
            // 左侧所有柱子的最大值，包括当前柱子
            for (int j = 0; j <= i; j++) {
                if (height[j] > lMax) {
                    lMax = height[j];
                }
            }
            // 右侧所有柱子的最大值，包括当前柱子
            for (int j = i; j < height.length; j++) {
                if (height[j] > rMax) {
                    rMax = height[j];
                }
            }
            // 左侧柱子最大值和右侧柱子最大值取较小值之后，减去当前柱子的高度即为当前柱子的积雨亮
            sum += (Math.min(lMax, rMax) - height[i]);
        }
        return sum;
    }

    /**
     * 在暴力法的基础上，使用动态规划计算每个柱子左右高度的最大值 3ms 战胜 32.57%
     */
    private static int trap2(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int sum = 0;

        // dp[i][0] 表示第 i 个柱子左侧所有柱子的最大值，包括当前柱子
        // dp[i][1] 表示第 i 个柱子右侧所有柱子的最大值，包括当前柱子
        int[][] dp = new int[height.length][2];

        // 第 0 个柱子左侧所有柱子的最大值
        dp[0][0] = height[0];
        // 第 height.length - 1 个柱子右侧所有柱子的最大值
        dp[height.length - 1][1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], height[i]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            sum += Math.min(dp[i][0], dp[i][1]) - height[i];
        }
        return sum;
    }

    /**
     * 双指针 在动态规划的基础上进一步优化，使用两个指针变量代替二维数组 dp[height.length - 1][2]，一次遍历即出结果 1ms 战胜 99.98%
     */
    private static int trap3(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int sum = 0;

        int i = 0, j = height.length - 1;
        int lMax = -1;
        int rMax = -1;

        while (i <= j) {
            if (lMax <= rMax) {
                lMax = Math.max(lMax, height[i]);
                sum += lMax - height[i ++];
            } else {
                rMax = Math.max(rMax, height[j]);
                sum += rMax - height[j --];
            }
        }
        return sum;
    }

    /**
     * 单调栈
     */
    private static int trap4(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, index = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > stack.peek()) {
                stack.pop();
                index--;
            }
            if (!stack.isEmpty()) {
                sum += Math.min(stack.peek(), height[i]) * (i - index - 1);
            } else {
                sum += Math.min(stack.peek(), height[i]) * (i - index - 1);
            }
            stack.push(height[i]);
            index++;
        }

        return sum;
    }
}