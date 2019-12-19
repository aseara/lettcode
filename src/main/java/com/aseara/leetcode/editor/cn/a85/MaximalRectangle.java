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

        int max = 0;

        int[][] memo = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = j + 1;

                if (matrix[i][j] == '1') {


                } else {
                    for (int k = 0; k <= i; k++) {
                        int r = k + 1;
                        // memo[]
                    }
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
