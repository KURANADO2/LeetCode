package com.kuranado.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. 拼写单词
 *
 * @Author: Xinling Jing
 * @Date: 2020/3/17 20:30
 */
public class Test4 {

    public static void main(String[] args) {

        // Test Sample 1
        //String[] words = new String[]{"cat","bt","hat","tree"};
        //String chars = "abbbceetach";
        // Test Sample 2
        String[] words = new String[]{"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters2(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        Map<String, Integer> map = new HashMap<>(26);
        for (int i = 0; i < chars.length(); i++) {
            String s = chars.substring(i, i + 1);
            Integer sum = map.get(s);
            if (sum == null) {
                sum = 1;
            } else {
                sum++;
            }
            map.put(s, sum);
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            Map<String, Integer> mapCopy = new HashMap<>(map);
            String word = words[i];
            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {
                String s = word.substring(j, j + 1);
                Integer sum = mapCopy.get(s);
                if (sum == null || sum == 0) {
                    flag = false;
                    break;
                } else {
                    sum--;
                    mapCopy.put(s, sum);
                }
            }
            if (flag) {
                result += word.length();
            }
        }
        return result;
    }

    public static int countCharacters2(String[] words, String chars) {
        int[] table = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            table[chars.charAt(i) - 'a'] ++;
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean flag = true;
            int[] tmp = new int[26];
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'a';
                if (tmp[index] == table[index]) {
                    flag = false;
                    break;
                }
                tmp[index]++;
            }
            if (flag) {
                result += word.length();
            }
        }
        return result;
    }

}
