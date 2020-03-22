package com.kuranado.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-20 21:23
 */
public class Test8 {

    public static void main(String[] args) {
        // Test Sample 1
        //String s = "abcabcbb";
        // Test Sample 2
        //String s = "bbbbb";
        // Test Sample 3
        //String s = "pwwkew";
        // Test Sample 4
        //String s = "abgdefcchjklmnop";
        // Test Sample 5
        String s = "abcdefgchjklmnop";
        // Test Sample 6
        //String s = "a";
        // Test Sample 7
        //String s = "";
        System.out.println(lengthOfLongestSubstring2(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = -1;
        Set<Character> set = new HashSet<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean add = set.add(c);
            if (!add) {
                if (set.size() > max) {
                    max = set.size();
                }
                set.clear();
                while (j < i) {
                    if (s.charAt(j) == c) {
                        i = j;
                        j++;
                        break;
                    }
                    j++;
                }
            }
        }
        return Math.max(set.size(), max);
    }

    public static int lengthOfLongestSubstring2(String s) {
        if ("".equals(s)) {
            return
                0;
        }
        int max = -1;
        int tmp = 0;
        int length = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = tmp; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    length = i - tmp;
                    tmp = j + 1;
                    break;
                }
                if (j == s.length() - 2) {
                    length = s.length() - tmp;
                }
            }
            if (length > max) {
                max = length;
            }
        }
        return max;
    }
}
