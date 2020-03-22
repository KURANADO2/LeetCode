package com.kuranado.problems;

/**
 * 836. 矩形重叠
 *
 * @Author: Xinling Jing
 * @Date: 2020/3/18 22:36
 */
public class Test5 {

    public static void main(String[] args) {

        // Test Sample 1
        int[] rec1 = new int[]{0, 0, 2, 2};
        int[] rec2 = new int[]{1, 1, 3, 3};
        // Test Sample 2
        //int[] rec1 = new int[]{0, 0, 1, 1};
        //int[] rec2 = new int[]{1, 0, 2, 1};
        System.out.println(isRectangleOverlap(rec1, rec2));
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec2[2] > rec1[0] && rec2[0] < rec1[2] && rec2[1] < rec1[3] && rec2[3] > rec1[1]) {
            return true;
        }
        return false;
    }
}
