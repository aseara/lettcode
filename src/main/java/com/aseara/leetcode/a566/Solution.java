package com.aseara.leetcode.a566;

import java.util.Arrays;

/**
 * Created by qiujingde on 2017/5/13.
 * Algorithm 566
 */
public class Solution {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int total = nums.length * nums[0].length;
        if (total != r * c) {
            return nums;
        }

        int[][] reshaped = new int[r][c];
        int i = 0, j = 0;
        for (int[] num : nums) {
            for (int aNum : num) {
                reshaped[i][j] = aNum;
                j++;
                if (j == c) {
                    j = 0;
                    i++;
                }
            }
        }

        return reshaped;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
        System.out.println(Arrays.deepToString(s.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4)));

    }

}
