//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划
package com.aseara.leetcode.editor.cn.a300;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 300.最长上升子序列 <br />
 * Date: 2019/12/12 <br/>
 *
 * @author qiujingde
 */
class LongestIncreasingSubsequence {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        int[] nums1 = {10,9,2,5,3,7,101,18};
        assertEquals(4, solution.lengthOfLIS(nums1));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int n = nums.length;
        // memo[i][0] 不包含当前节点的lis，max(memo[i-1][0], memo[i-1][1])
        // memo[i][1] 包含当前节点的lis，i之前第一个比nums[i]小的节点j, memo[j][1] + 1
        int[][] memo = new int[n][2];
        memo[0][1] = 1;
        for (int i = 1; i < n; i++) {
            memo[i][0] = Math.max(memo[i-1][0], memo[i-1][1]);
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    memo[i][1] = Math.max(memo[i][1], memo[j][1]);
                }
            }
            memo[i][1] = memo[i][1] + 1;
        }
        return Math.max(memo[n-1][0], memo[n-1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
