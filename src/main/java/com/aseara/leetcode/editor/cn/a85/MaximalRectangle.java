//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 示例: 
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6 
// Related Topics 栈 数组 哈希表 动态规划
package com.aseara.leetcode.editor.cn.a85;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 85.最大矩形 <br />
 * Date: 2019/12/13 <br/>
 *
 * @author qiujingde
 */
class MaximalRectangle {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        assertEquals(6, solution.maximalRectangle(matrix));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            memo[i][0] = matrix[i][0] == '1' ? 1 : 0;
            for (int j = 1; j < n; j++) {
                memo[i][j] = matrix[i][j] == '1' ? memo[i][j-1] + 1 : 0;
            }
        }
        int max = 0;
        LinkedList<Tuple> stack = new LinkedList<>();
        Tuple edge = new Tuple(-1, 0);
        stack.push(edge);
        for (int j = 0; j < n; j++) {
            Tuple left;
            for (int i = 0; i < m; i++) {
                left = stack.peek();
                while (left.val > memo[i][j]) {
                    int width = left.val;
                    stack.pop();
                    left = stack.peek();
                    max = Math.max(max, (i - left.index - 1) * width);
                }
                stack.push(new Tuple(i, memo[i][j]));
            }
            left = stack.peek();
            while (left != edge) {
                int width = left.val;
                stack.pop();
                left = stack.peek();
                max = Math.max(max, (m - left.index - 1) * width);
            }
        }
        return max;
    }

    private static class Tuple {
        int index;
        int val;
        Tuple(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
