//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 回溯算法
package com.aseara.leetcode.editor.cn.a52;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 52.N皇后 II <br />
 * Date: 2019/11/22 <br/>
 *
 * @author qiujingde
 */
class NQueensIi {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        assertEquals(1, solution.totalNQueens(1));
        assertEquals(2, solution.totalNQueens(4));
        assertEquals(92, solution.totalNQueens(8));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        count = 0;
        if (n < 1) {
            return count;
        }
        boolean[] col = new boolean[n];
        // 撇
        boolean[] left = new boolean[2 * n];
        // 捺
        boolean[] right = new boolean[2 * n];
        // 位置记录
        LinkedList<Integer> stack = new LinkedList<>();
        dfs(0, stack, n, col, left, right);
        return count;
    }

    private void dfs(int row, LinkedList<Integer> stack, int n,
                     boolean[] col, boolean[] left, boolean[] right) {
        if (row == n) {
            // 遍历完成，合法数据
            count ++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !left[i - row + n] && !right[i + row]) {
                stack.add(i);
                col[i] = true;
                left[i - row + n] = true;
                right[i + row] = true;

                dfs(row + 1, stack, n, col, left, right);

                right[i + row] = false;
                left[i - row + n] = false;
                col[i] = false;
                stack.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
