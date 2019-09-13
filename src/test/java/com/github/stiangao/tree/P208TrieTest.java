package com.github.stiangao.tree;


import org.junit.Assert;

public class P208TrieTest {

    @org.junit.Test
    public void test1() {
        String[] funs = {
                "insert", "insert", "insert", "insert", "insert",
                "insert", "search", "search", "search", "search",
                "search", "search", "search", "search", "search",
                "startsWith", "startsWith", "startsWith", "startsWith",
                "startsWith", "startsWith", "startsWith", "startsWith"};
        String[] words = {
                "app", "apple", "beer", "add", "jam",
                "rental", "apps", "appd", "app", "applepie",
                "rest", "jan", "rent", "beer", "jam",
                "apps", "app", "ad", "applepie",
                "jan", "rent", "beer", "jam"};
        Boolean[] result = {
                null, null, null, null, null,
                null, false, false, true, false,
                false, false, false, true, true,
                false, true, true, false,
                false, true, true, true};
        P208Trie.Trie trie = new P208Trie.Trie();
        for (int i = 0; i < funs.length; i++) {
            System.out.println(funs[i] + " " + words[i]);
            switch (funs[i]) {
                case "insert":
                    trie.insert(words[i]);
                    break;
                case "search":
                    Assert.assertEquals(result[i], trie.search(words[i]));
                    break;
                case "startsWith":
                    Assert.assertEquals(result[i], trie.startsWith(words[i]));
                    break;
            }
        }

    }
}
