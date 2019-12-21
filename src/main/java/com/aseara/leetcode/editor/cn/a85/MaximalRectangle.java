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

import java.util.Arrays;
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

        int[] heights = new int[n];
        int[] lefts = new int[n];
        int[] rights = new int[n];
        Arrays.fill(rights, n);

        int max = 0;
        for (char[] row : matrix) {
            int left = 0;
            for (int i = 0; i < n; i++) {
                heights[i] = row[i] == '1' ? heights[i] + 1 : 0;
                lefts[i] = row[i] == '1' ? Math.max(lefts[i], left) : 0;
                left = row[i] == '1' ? left : i + 1;
            }
            int right = n;
            for (int i = n - 1; i >= 0; i--) {
                rights[i] = row[i] == '1' ? Math.min(rights[i], right) : n;
                right = row[i] == '1' ? right : i;

                max = Math.max(max, heights[i] * (rights[i] - lefts[i]));
            }
        }
        return max;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
