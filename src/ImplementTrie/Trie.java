/**
 * @(#)Trie.java, 十月 24, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ImplementTrie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenyang
 */
public class Trie {
    private class Node {
        char value;
        boolean isNode;
        List<Node> children;

        Node() {
            isNode = false;
            children = new ArrayList<>();
        }
    }

    Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node n = root;
        for (char c : chars) {
            boolean found = false;
            for (Node node : n.children) {
                if (node.value == c) {
                    found = true;
                    n = node;
                    break;
                }
            }
            if (!found) {
                Node newNode = new Node();
                newNode.value = c;
                n.children.add(newNode);
                n = newNode;
            }
        }
        n.isNode = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node n = root;
        for (char c : chars) {
            boolean found = false;
            for (Node node : n.children) {
                if (node.value == c) {
                    found = true;
                    n = node;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        if (n.isNode) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node n = root;
        for (char c : chars) {
            boolean found = false;
            for (Node node : n.children) {
                if (node.value == c) {
                    found = true;
                    n = node;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "abcde";
        String prefix = "abc";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
        boolean param_4 = obj.startsWith("avd");

        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

