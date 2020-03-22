package com.kuranado.problems;

import java.util.Arrays;

/**
 * 945. 使数组唯一的最小增量
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-22 14:16
 */
public class Test10 {

    public static void main(String[] args) {
        // Test Sample 1 1
        //int[] arr = new int[]{1, 2, 2};
        // Test Sample 2 6
        //int[] arr = new int[]{3, 2, 1, 2, 1, 7};
        // Test Sample 3 4
        //int[] arr = new int[]{1, 1, 1, 3, 5, 7};
        // Test Sample 4 0
        //int[] arr = new int[]{1, 2, 3, 4, 5, 7};
        // Test Sample 5 3
        //int[] arr = new int[]{1, 2, 1, 3, 5, 7};
        // Test Sample 6 0
        //int[] arr = new int[]{1};
        // Test Sample 7 6
        //int[] arr = new int[]{2, 2, 2, 2, 0};
        // Test Sample 8 10
        //int[] arr = new int[]{1, 1, 1, 1, 1};
        // Test Sample 9 84
        int[] arr = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        //System.out.println(minIncrementForUnique(arr));
        System.out.println(minIncrementForUnique2(arr));
    }

    /**
     * 56 / 59 个通过测试用例，57 超出时间限制（第 57 组测试数据数组长度为 40000）
     */
    public static int minIncrementForUnique(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int move = 0;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                move++;
                A[i]++;
                boolean sorted = true;
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] > A[j - 1] || A[j] == A[j - 1]) {
                        break;
                    } else {
                        int tmp = A[j];
                        A[j] = A[j - 1];
                        A[j - 1] = tmp;
                        sorted = false;
                    }
                }
                if (!sorted) {
                    i--;
                }
            }
        }
        return move;
    }

    /**
     * 16 ms
     */
    public static int minIncrementForUnique2(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int move = 0;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int n = A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
                move += n;
            }
        }
        return move;
    }
}
