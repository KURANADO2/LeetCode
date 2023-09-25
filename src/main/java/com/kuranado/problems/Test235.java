package com.kuranado.problems;

/**
 * 最多颜色的车辆 https://wiki.amoscloud.com/zh/ProgramingPractice/NowCoder/Adecco/Topic0235
 *
 * @author Xinling Jing
 * @date 2023-09-23 16:15
 */
public class Test235 {

    public static void main(String[] args) {
        //int[] a = new int[]{0, 2, 1, 1};
        //int N = 3;
        //int[] a = new int[]{0, 1, 2, 1};
        //int N = 2;
        int[] a = new int[]{0, 2, 1, 2, 0, 1, 2, 1, 1, 1, 2, 0};
        int N = 3;
        int max = fun(a, N);
        System.out.println(max);
    }

    private static int fun(int[] a, int N) {
        int max = -1;
        for (int i = 0; i < a.length - N + 1; i++) {
            int[] b = new int[3];
            for (int j = 0; j < N; j++) {
                b[a[i + j]]++;
            }
            int m = max(b);
            if (m > max) {
                max = m;
            }
        }
        return max;
    }

    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
