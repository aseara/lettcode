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
        int n = matrix[0].length;
        int[] dp = new int[n];
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (char[] chars : matrix) {
            for (int j = 0; j < n; j++) {
                dp[j] = chars[j] == '1' ? dp[j] + 1 : 0;
                while (stack.peek() != -1 && dp[stack.peek()] > dp[j]) {
                    max = Math.max(max, dp[stack.pop()] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
            while (stack.peek() != -1) {
                max = Math.max(max, dp[stack.pop()] * (n - stack.peek() - 1));
            }
        }
        return max;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
