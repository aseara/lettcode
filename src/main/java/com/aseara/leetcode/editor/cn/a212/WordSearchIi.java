//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法
package com.aseara.leetcode.editor.cn.a212;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 212.单词搜索 II <br />
 * Date: 2019/11/19 <br/>
 *
 * @author qiujingde
 */
class WordSearchIi {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        Set<String> result = new HashSet<>(solution.findWords(board, words));
        Set<String> expected = new HashSet<>(Arrays.asList("eat","oath"));

        assertIterableEquals(expected, result);
    }
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null) {
            return Collections.emptyList();
        }

        Trie trie = new Trie();
        // 所有单词存入字典树
        for (String word : words) {
            trie.insert(word);
        }

        Trie.TrieNode root = trie.getRoot();

        Map<Character, List<Cor>> corMap = new HashMap<>();
        // 遍历二维矩阵
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                corMap.computeIfAbsent(board[i][j], c -> new LinkedList<>())
                        .add(new Cor(i, j));
            }
        }

        List<String> result = new LinkedList<>();
        LinkedList<Character> charStack = new LinkedList<>();

        List<Character> links = root.getLinks();
        for (char c : links) {
            List<Cor> cors = corMap.get(c);
            Trie.TrieNode nextNode = root.getNode(c);
            if (cors != null) {
                for (Cor nextCor : cors) {
                    backtrace(board, nextNode, nextCor, charStack, result);
                }
            }
        }
        return result;
    }

    private void backtrace(char[][] board, Trie.TrieNode node, Cor cor,
                           LinkedList<Character> charStack,
                           List<String> result) {
        char c = board[cor.x][cor.y];
        board[cor.x][cor.y] = 0;
        charStack.add(c);

        if (node.isEnd()) {
            result.add(toString(charStack));
            node.setEnd(false);
        }

        List<Cor> nextCors = cor.getNeighbors(board.length, board[0].length);
        for (Cor nextCor: nextCors) {
            char nextC = board[nextCor.x][nextCor.y];
            Trie.TrieNode nextNode;
            if (nextC != 0 && (nextNode = node.getNode(nextC)) != null) {
                backtrace(board, nextNode, nextCor, charStack, result);
            }
        }

        charStack.removeLast();
        board[cor.x][cor.y] = c;
    }

    private String toString(LinkedList<Character> charStack) {
        StringBuilder sb = new StringBuilder();
        for (Character c : charStack) {
            sb.append(c);
        }
        return sb.toString();
    }
}

class Cor {
    final int x;
    final int y;

    public Cor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Cor> getNeighbors(int maxX, int maxY) {
        List<Cor> nextCors = new LinkedList<>();
        // 上
        if (x - 1 >= 0) {
            nextCors.add(new Cor(x - 1, y));
        }
        // 下
        if (x + 1 < maxX) {
            nextCors.add(new Cor(x + 1, y));
        }
        // 左
        if (y - 1 >= 0) {
            nextCors.add(new Cor(x, y - 1));
        }
        // 右
        if (y + 1 < maxY) {
            nextCors.add(new Cor(x, y + 1));
        }
        return nextCors;
    }
}

class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            node = node.computeIfAbsent(c);
        }
        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = getEndNode(word);
        return node != null && node.isEnd();
    }

    public TrieNode getRoot() {
        return root;
    }

    private TrieNode getEndNode(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length && node != null; i++) {
            node = node.getNode(chars[i]);
        }
        return node;
    }

    static class TrieNode {
        private TrieNode[] links = new TrieNode[26];
        private List<Character> linkChars = new LinkedList<>();

        private boolean isEnd;

        public TrieNode computeIfAbsent(char c) {
            TrieNode node = getNode(c);
            if (node == null) {
                setNode(c, new TrieNode());
                linkChars.add(c);
            }
            return getNode(c);
        }

        public TrieNode getNode(char c) {
            return links[c - 'a'];
        }

        private void setNode(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public List<Character> getLinks() {
            return linkChars;
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
