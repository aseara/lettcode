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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        return path3(beginWord, endWord, wordList);
    }

    private int path1(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> checkList = new LinkedList<>();
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
                int checkSize = checkList.size();
                for (int j = 0; j < checkSize; j++) {
                    String next = checkList.poll();
                    if (canGo(crt, next)) {
                        queue.add(next);
                    } else {
                        checkList.add(next);
                    }
                }
            }
        }

        return 0;
    }

    private boolean canGo(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            diff += a.charAt(i) == b.charAt(i) ? 0 : 1;
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    private int path2(String beginWord, String endWord, List<String> wordList) {
        // abc -> *bc, a*c, ab*
        Map<String, List<String>> map1 = new HashMap<>(wordList.size());
        // *bc -> abc, bbc, cbc
        Map<String, List<String>> map2 = new HashMap<>(wordList.size() * 3);

        for(String word : wordList) {
            fillMap(map1, map2, word);
        }
        fillMap(map1, map2, beginWord);

        if (map1.get(endWord) == null) {
            return 0;
        }

        // endWord -> *bc, a*c, ab*
        Set<String> checkSet = new HashSet<>(map1.remove(endWord));

        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int step = 1;
        while (!queue.isEmpty() && !map1.isEmpty()) {
            step++;
            int batch = queue.size();
            for (int i = 0; i < batch; i++) {
                String crt = queue.poll();
                List<String> paths = map1.remove(crt);
                if (paths == null) {
                    continue;
                }
                for (String path: paths) {
                    if (checkSet.contains(path)) {
                        return step;
                    }
                    for (String next : map2.get(path)) {
                        if (map1.containsKey(next)) {
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private void fillMap(Map<String, List<String>> map1, Map<String, List<String>> map2, String word) {
        for (int i = 0; i < word.length(); i++) {
            String pathWord = word.substring(0, i) + '*' + word.substring(i + 1);
            map1.computeIfAbsent(word, k -> new LinkedList<>()).add(pathWord);
            map2.computeIfAbsent(pathWord, k -> new LinkedList<>()).add(word);
        }
    }

    // 双向BFS
    private int path3(String beginWord, String endWord, List<String> wordList) {
        // abc -> *bc, a*c, ab*
        Map<String, List<String>> map1 = new HashMap<>(wordList.size());
        // *bc -> abc, bbc, cbc
        Map<String, List<String>> map2 = new HashMap<>(wordList.size() * 3);

        for(String word : wordList) {
            fillMap(map1, map2, word);
        }
        fillMap(map1, map2, beginWord);

        if (!map1.containsKey(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        int step = 1;
        while (!beginSet.isEmpty() && visited.size() < map1.size()) {
            step ++;

            Set<String> tempSet = new HashSet<>();
            for (String curWord : beginSet) {
                if (visited.contains(curWord)) {
                    continue;
                }
                visited.add(curWord);
                for(String path : map1.get(curWord)) {
                    for (String nextWord : map2.get(path)) {
                        if (endSet.contains(nextWord)) {
                            return step;
                        }

                        if (!visited.contains(nextWord)) {
                            tempSet.add(nextWord);
                        }
                    }
                }
            }

            beginSet = endSet;
            endSet = tempSet;
        }

        return 0;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
