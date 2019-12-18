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
        int n = nums.length;
        int[] memo = new int[n];
        int[] nums2 = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums2[i] = nums[i] == 1 ? 1 : -1;
            sum += nums2[i];
        }
        memo[0] = sum;
        for (int i = n; i > 1; i--) {
            for (int j = 0; j <= n-i; j++) {
                if (memo[j] == 0) {
                    return i;
                }
                memo[j] -= nums2[i+j-1];
            }
            memo[n-i+1] = memo[n-i] - nums2[n-i] + nums2[n-1];
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
