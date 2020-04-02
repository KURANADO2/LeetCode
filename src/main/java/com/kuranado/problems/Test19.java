package com.kuranado.problems;

import java.util.Arrays;

/**
 * 912. 排序数组
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-31 20:11
 */
public class Test19 {

    public static void main(String[] args) {
        // Test Sample 1
        int[] nums = new int[]{5, 2, 3, 1};
        int[] result = sortArray(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("0 & 1:" + (0 & 1));
        System.out.println("1 & 1:" + (1 & 1));
        System.out.println("2 & 1:" + (2 & 1));
        System.out.println("3 & 1:" + (3 & 1));
        System.out.println("4 & 1:" + (4 & 1));
    }

    /**
     * Java API 排序
     */
    public static int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}
