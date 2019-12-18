//给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。 
//
// 示例 2: 
//
// 输入: [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 注意: 给定的二进制数组的长度不会超过50000。 
// Related Topics 哈希表
package com.aseara.leetcode.editor.cn.a525;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 525.连续数组 <br />
 * Date: 2019/12/18 <br/>
 *
 * @author qiujingde
 */
class ContiguousArray {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        int[] nums1 = {0, 1};
        assertEquals(2, solution.findMaxLength(nums1));

        int[] nums2 = {1, 0, 1};
        assertEquals(2, solution.findMaxLength(nums2));

        int[] nums3 = {1, 0, 1, 1, 0, 1};
        assertEquals(4, solution.findMaxLength(nums3));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = 0;
        int n = nums.length;
        int[] memo = new int[2 * n + 1];
        Arrays.fill(memo, -2);
        int sum = n;
        memo[sum] = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (memo[sum] == -2) {
                memo[sum] = i;
            } else {
                max = Math.max(max, i - memo[sum]);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
