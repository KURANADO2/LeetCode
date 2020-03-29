package com.kuranado.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 820. 单词的压缩编码
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-28 17:31
 */
public class Test16 {

    public static void main(String[] args) {
        // Test Sample 1 10
        //String[] words = new String[]{"time", "me", "bell"};
        // Test Sample 2 10
        //String[] words = new String[]{"time", "me", "bell", "e"};
        // Test Sample 3 13
        //String[] words = new String[]{"time", "me", "bell", "e", "el"};
        // Test Sample 4 10
        //String[] words = new String[]{"time", "me", "bell", "ell"};
        // Test Sample 5 7
        // eb#e#c# [3, 1, 5, 0]
        //String[] words = new String[]{"e", "b", "c", "eb"};
        // be#b#c# [1, 3, 5, 0]
        // Test Sample 6 7
        String[] words = new String[]{"e", "b", "c", "be"};
        System.out.println(minimumLengthEncoding3(words));
    }

    /**
     * 19 ms 战胜 93.51%
     */
    public static int minimumLengthEncoding3(String[] words) {
        TrieNode root = new TrieNode();
        // key 节点，value 数组下标索引
        Map<TrieNode, Integer> map = new HashMap<>(words.length);

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = root;
            for (int j = word.length() - 1; j >= 0; --j) {
                cur = cur.get(word.charAt(j));
            }

            map.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node : map.keySet()) {
            // 只有叶子节点的 count 为 0
            if (node.count == 0) {
                ans += words[map.get(node)].length() + 1;
            }
        }
        return ans;

    }

    static class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }
    ///**
    // * 27 ms 战胜 62.50%
    // */
    //public static int minimumLengthEncoding2(String[] words) {
    //    Set<String> stringSet = new HashSet<>(Arrays.asList(words));
    //    for (int i = 0; i < words.length; i++) {
    //        for (int j = 1; j < words[i].length(); j++) {
    //            stringSet.remove(words[i].substring(j));
    //        }
    //    }
    //    int sum = 0;
    //    for (String s : stringSet) {
    //        sum += s.length();
    //        sum++;
    //    }
    //    return sum;
    //}
    //
    ///**
    // * 38 ms 战胜 46.43%
    // */
    //public static int minimumLengthEncoding(String[] words) {
    //    TrieNode root = new TrieNode();
    //    Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
    //    int sum = 0;
    //    for (int i = 0; i < words.length; i++) {
    //        String word = reverseString(words[i].toCharArray());
    //        if (prefixNumber(word, root) == 0) {
    //            insert(word, root);
    //            sum += word.length();
    //            sum++;
    //        }
    //    }
    //    return sum;
    //}
    //
    //public static String reverseString(char[] chars) {
    //    StringBuilder sb = new StringBuilder();
    //    for (int i = chars.length - 1; i >= 0; i--) {
    //        sb.append(chars[i]);
    //    }
    //    return sb.toString();
    //}
    //
    //static class TrieNode {
    //
    //    private int path;
    //    private int end;
    //    private TrieNode[] arr;
    //
    //    public TrieNode() {
    //        path = 0;
    //        end = 0;
    //        arr = new TrieNode[26];
    //    }
    //}
    //
    //public static void insert(String word, TrieNode root) {
    //    if (word == null) {
    //        return;
    //    }
    //    TrieNode node = root;
    //    node.path++;
    //    char[] words = word.toCharArray();
    //    int index;
    //    for (int i = 0; i < words.length; i++) {
    //        index = words[i] - 'a';
    //        if (node.arr[index] == null) {
    //            node.arr[index] = new TrieNode();
    //        }
    //        node = node.arr[index];
    //        node.path++;
    //    }
    //    node.end++;
    //}
    //
    //public static int prefixNumber(String pre, TrieNode root) {
    //    if (pre == null) {
    //        return 0;
    //    }
    //    TrieNode node = root;
    //    char[] pres = pre.toCharArray();
    //    int index;
    //    for (int i = 0; i < pres.length; i++) {
    //        index = pres[i] - 'a';
    //        if (node.arr[index] == null) {
    //            return 0;
    //        }
    //        node = node.arr[index];
    //    }
    //    return node.path;
    //}

}
