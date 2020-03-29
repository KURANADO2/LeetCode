package com.kuranado.problems;

/**
 * 914. 卡牌分组
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-27 21:17
 */
public class Test15 {

    public static void main(String[] args) {
        // Test Sample 1 true
        int[] deck = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        // Test Sample 2 false
        //int[] deck = new int[]{1, 1, 1, 2, 2, 2, 3, 3};
        // Test Sample 3 false
        //int[] deck = new int[]{1};
        // Test Sample 4 true
        //int[] deck = new int[]{1, 1};
        // Test Sample 5 true
        //int[] deck = new int[]{1, 1, 2, 2, 2, 2};
        // Test Sample 6 true
        //int[] deck = new int[]{1, 1, 2, 2, 2, 2, 4, 4, 9999, 9999};
        // Test Sample 7 true
        //int[] deck = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
        // Test Sample 8 false
        //int[] deck = new int[]{1, 1, 1, 1, 1, 0, 0, 0};
        // Test Sample 9 true
        //int[] deck = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3,
        //    3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 7, 7, 8, 8};
        // Test Sample 10 false
        //int[] deck = new int[]{0, 0, 1, 1, 1, 1, 2, 2, 3, 4};

        System.out.println(hasGroupsSizeX(deck));
    }

    public static boolean hasGroupsSizeX(int[] deck) {

        int[] table = new int[10005];
        for (int i = 0; i < deck.length; i++) {
            table[deck[i]]++;
        }

        int x = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] > 0) {
                x = gcd(x, table[i]);
                if (x == 1) {
                    return false;
                }
            }
        }
        return x >= 2;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
