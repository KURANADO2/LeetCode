package com.kuranado.problems;

/**
 * 面试题 17.16. 按摩师
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-24 20:16
 */
public class Test12 {

    public static void main(String[] args) {
        // Test Sample 1
        //int[] nums = new int[]{1, 2, 3, 1};
        // Test Sample 2
        //int[] nums = new int[]{2, 7, 9, 3, 1};
        // Test Sample 3
        //int[] nums = new int[]{2, 1, 4, 5, 3, 1, 1, 3};
        // Test Sample 4
        //int[] nums = new int[]{};
        // Test Sample 5
        //int[] nums = new int[]{5};
        // Test Sample 6
        //int[] nums = new int[]{7, 3};
        // Test Sample 7
        //int[] nums = new int[]{3, 7};
        // Test Sample 8
        int[] nums = new int[]{3, 7, 2};
        System.out.println(massage(nums));

    }

    public static int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] r = new int[n + 1];
        r[0] = 0;
        r[1] = nums[n - 1];
        r[2] = Math.max(nums[n - 2], nums[n - 1]);
        for (int i = 3; i <= n; i++) {
            r[i] = Math.max(nums[n - i] + r[i - 2], nums[n - i + 1] + r[i - 3]);
        }
        return r[n];
    }

}
