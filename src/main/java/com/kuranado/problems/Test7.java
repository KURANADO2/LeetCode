package com.kuranado.problems;

import java.util.Arrays;

/**
 * 面试题40. 最小的k个数
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-20 20:52
 */
public class Test7 {

    public static void main(String[] args) {
        // Test Sample 1
        //int[] arr = new int[]{3, 2, 1};
        //int k = 2;
        // Test Sample 2
        //int[] arr = new int[]{0, 1, 2, 1};
        //int k = 1;
        // Test Sample 3
        int[] arr = new int[]{1, 4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        int[] result = getLeastNumbers(arr, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        Arrays.sort(arr);
        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }
}
