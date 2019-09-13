package com.github.stiangao.tree;

import java.util.ArrayList;
import java.util.List;

public class P208Trie {
    static class Trie {
        class TrieNode {
            private int v;
            private int e;
            TrieNode(char ch) {
                v = 1 << (ch - 'a');
            }

            void end(char ch) {
                e |= 1 << (ch - 'a');
            }

            boolean has(char ch) {
                return (v & (1 << (ch - 'a'))) == 1;
            }

            boolean isEnd(char ch) {
                return (e & (1 << (ch - 'a'))) == 1;
            }
        }
        List<TrieNode> list;
        /** Initialize your data structure here. */
        public Trie() {
            list = new ArrayList<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            int n = chars.length;
            for (int i = 0; i < n; i++) {
                if (i < list.size()) {
                    list.add(new TrieNode(chars[i]));
                } else {
                    list.get(i).end(chars[i]);
                }
            }
            list.get(n-1).end(chars[n-1]);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word.length() > list.size()) {
                return false;
            }
            char[] chars = word.toCharArray();
            int n = chars.length;
            for (int i = 0; i < chars.length; i++) {
                if (!list.get(i).has(chars[i])) {
                    return false;
                }
            }
            return list.get(n-1).isEnd(chars[n-1]);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (!list.get(i).has(chars[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));   // 返回 false
        trie.insert("app");
        System.out.println(trie.search("app"));   // 返回 true
        System.out.println(trie.search("appd"));   // 返回 true
        trie.search("app");     // 返回 true
    }
}
