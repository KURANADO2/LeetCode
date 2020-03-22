package com.kuranado.problems;

/**
 * 409. 最长回文串
 *
 * @Author: Xinling Jing
 * @Date: 2020/3/19 20:51
 */
public class Test6 {

    public static void main(String[] args) {

        // Test Sample 1
        //String s = "abccccdd";
        // Test Sample 2
        //String s = "AAAAAaabbbccccc";
        // Test Sample 3
        //String s = "a";
        // Test Sample 4
        String s = "abcddAAA";

        System.out.println(longestPalindrome2(s));
    }

    public static int longestPalindrome(String s) {

        int[] arr = new int[52];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                arr[c - 'A']++;
            }
            if (c >= 'a' && c <= 'z') {
                arr[c - 71]++;
            }
        }
        int sum = 0;
        boolean firstOdd = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            } else {
                if (firstOdd) {
                    sum += arr[i];
                    firstOdd = false;
                } else {
                    sum += (arr[i] - 1);
                }
            }
        }
        return sum;
    }

    public static int longestPalindrome2(String s) {

        int[] arr = new int[52];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                arr[c - 'A']++;
            }
            if (c >= 'a' && c <= 'z') {
                arr[c - 71]++;
            }
        }
        int sum = 0;
        int odd = 0;
        for (int num : arr) {
            if (num == 0) {
                continue;
            }
            sum += num / 2 * 2;

            if (num % 2 == 1) {
                odd = 1;
            }
        }
        sum += odd;
        return sum;
    }
}
