package com.aseara.leetcode.a463;

/**
 * Created by 邱境德 on 2017/4/17.
 * Algorithm 463
 */
public class Solution {

    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i-1][j] == 1) {
                        result -= 2;
                    }
                    if (j > 0 && grid[i][j-1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }

}
