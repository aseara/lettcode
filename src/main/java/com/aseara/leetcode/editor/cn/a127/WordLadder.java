//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索
package com.aseara.leetcode.editor.cn.a127;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 127.单词接龙 <br />
 * Date: 2019/10/31 <br/>
 *
 * @author qiujingde
 */
class WordLadder {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        String begin = "hit";
        String end = "cog";
        List<String> dict = Arrays.asList("hot","dot","dog","lot","log","cog");
        assertEquals(5, solution.ladderLength(begin, end, dict));

        begin = "hit";
        end = "cog";
        dict = Arrays.asList("hot","dot","dog","lot","log");
        assertEquals(0, solution.ladderLength(begin, end, dict));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> checkList = new LinkedList<>();
        for (String w : wordList) {
            if (!w.equals(endWord)) {
                checkList.add(w);
            }
        }

        if (checkList.size() == wordList.size()) {
            return 0;
        }

        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int step = 1;
        while (!queue.isEmpty() && !wordList.isEmpty()) {
            step ++;
            int batch = queue.size();
            for (int i = 0; i < batch; i++) {
                String crt = queue.poll();
                if (canGo(crt, endWord)) {
                    return step;
                }
                List<String> nextWords = new LinkedList<>();
                for (String next : checkList) {
                    if (canGo(crt, next)) {
                        queue.add(next);
                    } else {
                        nextWords.add(next);
                    }
                }
                checkList = nextWords;
            }
        }

        return 0;
    }

    private boolean canGo(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            diff += a.charAt(i) == b.charAt(i) ? 0 : 1;
        }
        return diff == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
