package com.kuranado.problems;

/**
 * 面试题 01.06. 字符串压缩
 *
 * @Author: Xinling Jing
 * @Date: 2020/3/16 22:36
 */
public class Test3 {

    public static void main(String[] args) {

        // Test Sample 1
        //String str = "aabcccccaaa";
        // Test Sample 2
        //String str = "abbccd";
        // Test Sample 3
        //String str = "ab";
        // Test Sample 4
        //String str = "aaaaaaaaa";
        // Test Sample 5
        String str = "aa";
        // Test Sample 6
        //String str = "";

        System.out.println(compressString(str));
    }

    public static String compressString(String S) {
        if ("".equals(S)) {
            return S;
        }
        int sum = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length() - 1; i ++) {
            char m = S.charAt(i);
            char n = S.charAt(i + 1);
            if (n == m) {
                sum++;
            } else {
                sb.append(m).append(sum);
                sum = 1;
            }
        }
        sb.append(S.charAt(S.length() - 1)).append(sum);
        String result = sb.toString();
        if (result.length() >= S.length()) {
            return S;
        }
        return sb.toString();
    }
}
