package com.kuranado.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典树（Trie 树、前缀树）
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-28 18:45
 */
public class TrieTree {

    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    /**
     * 字典树节点
     */
    class TrieNode {

        private int path;
        private int end;
        private Map<Character, TrieNode> map;

        public TrieNode() {
            path = 0;
            end = 0;
            map = new HashMap<>();
        }
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        TrieNode node = root;
        node.path++;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (node.map.get(words[i]) == null) {
                node.map.put(words[i], new TrieNode());
            }
            node = node.map.get(words[i]);
            node.path++;
        }
        node.end++;
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        TrieNode node = root;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (node.map.get(words[i]) == null) {
                return false;
            }
            node = node.map.get(words[i]);
        }
        return node.end > 0;
    }

    public void delete(String word) {
        if (search(word)) {
            char[] words = word.toCharArray();
            TrieNode node = root;
            node.path--;
            for (int i = 0; i < words.length; i++) {
                if (--node.map.get(words[i]).path == 0) {
                    node.map.remove(words[i]);
                    return;
                }
                node = node.map.get(words[i]);
            }
            node.end--;
        }
    }

    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }
        TrieNode node = root;
        char[] pres = pre.toCharArray();
        for (int i = 0; i < pres.length; i++) {
            if (node.map.get(pres[i]) == null) {
                return 0;
            }
            node = node.map.get(pres[i]);
        }
        return node.path;
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        System.out.println(trieTree.search("你好"));
        trieTree.insert("你好");
        trieTree.insert("你好吗");
        trieTree.insert("我很好");
        trieTree.insert("哈哈哈");
        trieTree.insert("哈嘿哈嘿");
        System.out.println(trieTree.search("哈哈哈"));
        trieTree.delete("哈哈哈");
        System.out.println(trieTree.search("哈哈哈"));
        System.out.println(trieTree.prefixNumber("你好"));
    }

}
