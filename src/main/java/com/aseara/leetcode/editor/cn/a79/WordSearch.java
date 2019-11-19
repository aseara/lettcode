//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true.
//给定 word = "SEE", 返回 true.
//给定 word = "ABCB", 返回 false. 
// Related Topics 数组 回溯算法
package com.aseara.leetcode.editor.cn.a79;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * desc: 79.单词搜索 <br />
 * Date: 2019/11/19 <br/>
 *
 * @author qiujingde
 */
class WordSearch {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        assertTrue(solution.exist(board, "ABCCED"));
        assertTrue(solution.exist(board, "SEE"));
        assertFalse(solution.exist(board, "ABCB"));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0
                || board[0] == null || board[0].length == 0
                || word == null || word.length() == 0) {
            return false;
        }

        char[] wordArr = word.toCharArray();

        int m = board.length;
        int n = board[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, wordArr, 0, m, n)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] wordArr, int level, int m, int n) {
        if (board[i][j] != wordArr[level]) {
            return false;
        }
        if (level == wordArr.length - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = 0;

        int[] di = {1, -1, 0, 0};
        int[] dj = {0, 0, 1, -1};

        boolean result = false;
        for (int k = 0; k < 4; k++) {
            if (i + di[k] >= 0 && i + di[k] < m
                    && j + dj[k] >= 0 && j + dj[k] < n) {
                if (dfs(board, i + di[k], j + dj[k], wordArr, level + 1, m, n)) {
                   result = true;
                   break;
                }
            }
        }

        board[i][j] = temp;
        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
