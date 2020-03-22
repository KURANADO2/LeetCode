package com.kuranado.problems;

/**
 * 365. 水壶问题
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-21 20:05
 */
public class Test9 {

    public static void main(String[] args) {

        // Test Sample 1 true
        //int x = 3, y = 5, z = 4;
        // Test Sample 2 false
        //int x = 2, y = 6, z = 5;
        // Test Sample 3 true
        //int x = 4, y = 6, z = 8;
        // Test Sample 4 true
        //int x = 4, y = 10, z = 10;
        // Test Sample 5 false
        //int x = 0, y = 2, z = 1;
        // Test Sample 6 false
        //int x = 2, y = 0, z = 1;
        // Test Sample 6 true
        //int x = 2, y = 0, z = 2;
        // Test Sample 8 true
        //int x = 1, y = 0, z = 0;
        // Test Sample 9 true
        //int x = 1, y = 1, z = 0;
        // Test Sample 10 true
        int x = 11, y = 3, z = 13;
        System.out.println(canMeasureWater(x, y, z));
    }

    public static boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
