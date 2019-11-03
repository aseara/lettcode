//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找
package com.aseara.leetcode.editor.cn.a74;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * desc: 74.搜索二维矩阵 <br />
 * Date: 2019/11/3 <br/>
 *
 * @author qiujingde
 */
class SearchA2dMatrix {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        int[][] matrix = new int[][] {
                new int[] {1,   3,  5,  7},
                new int[] {10, 11, 16, 20},
                new int[] {23, 30, 34, 50}
        };
        assertTrue(solution.searchMatrix(matrix, 3));
        assertFalse(solution.searchMatrix(matrix, 13));

        matrix = new int[][] {
                new int[] {1,   1}
        };
        assertFalse(solution.searchMatrix(matrix, 0));
        assertFalse(solution.searchMatrix(matrix, 2));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return binarySearch(target, matrix, 0,
                matrix.length * matrix[0].length - 1, matrix[0].length);
    }

    private boolean binarySearch(int target, int[][] matrix,
                                 int start, int end, int length) {
        if (start == end || end < 0) {
            return matrix[start / length][start % length] == target;
        }

        if (end - start == 1) {
            return matrix[start / length][start % length] == target ||
                    matrix[end / length][end % length] == target;
        }

        int mid = start + (end - start) / 2;
        if (matrix[mid / length][mid % length] == target) {
            return true;
        }
        if (matrix[mid / length][mid % length] > target) {
            return binarySearch(target, matrix, start, mid - 1, length);
        }
        return binarySearch(target, matrix, mid + 1, end, length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
