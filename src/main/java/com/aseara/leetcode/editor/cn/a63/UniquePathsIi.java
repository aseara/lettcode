//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划
package com.aseara.leetcode.editor.cn.a63;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 63.不同路径 II <br />
 * Date: 2019/11/11 <br/>
 *
 * @author qiujingde
 */
class UniquePathsIi {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        assertEquals(0, solution.uniquePathsWithObstacles(null));

        int[][] grid1 = {};
        assertEquals(0, solution.uniquePathsWithObstacles(grid1));

        int[][] grid2 = {{}, {}};
        assertEquals(0, solution.uniquePathsWithObstacles(grid2));

        int[][] grid3 = {{0,0,0}, {0,1,0}, {0,0,0}};
        assertEquals(2, solution.uniquePathsWithObstacles(grid3));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 ||
                obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if (obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }

        int[][] pathNums = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    pathNums[i][j] = 0;
                    continue;
                }
                // 最后一行
                if (i == n - 1) {
                    pathNums[i][j] = j == m - 1 ? 1 : pathNums[i][j + 1];
                    continue;
                }
                if (j == m - 1) {
                    pathNums[i][j] = pathNums[i + 1][j];
                    continue;
                }
                pathNums[i][j] = pathNums[i][j + 1] + pathNums[i + 1][j];
            }
        }

        return pathNums[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
