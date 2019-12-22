//给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。 
//如果可以，请返回 True；否则，返回 False。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,3,4,4,5,6], k = 4
//输出：true
//解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
// 
//
// 示例 2： 
//
// 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
//输出：true
//解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
// 
//
// 示例 3： 
//
// 输入：nums = [3,3,2,2,1,1], k = 3
//输出：true
// 
//
// 示例 4： 
//
// 输入：nums = [1,2,3,4], k = 3
//输出：false
//解释：数组不能分成几个大小为 3 的子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^9 
// 1 <= k <= nums.length 
// 
// Related Topics 贪心算法 数组
package com.aseara.leetcode.editor.cn.a5292;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
* desc: 5292.Divide Array in Sets of K Consecutive Numbers <br />
* Date: 2019/12/22 <br/>
*
* @author qiujingde
*/
class DivideArrayInSetsOfKConsecutiveNumbers {
private Solution solution = new Solution();

    @Test
    void test1() {
        int[] nums1 = {1,2,3,3,4,4,5,6};
        assertTrue(solution.isPossibleDivide(nums1, 4));
        int[] nums2 = {3,2,1,2,3,4,3,4,5,9,10,11};
        assertTrue(solution.isPossibleDivide(nums2, 3));
        int[] nums3 = {3,3,2,2,1,1};
        assertTrue(solution.isPossibleDivide(nums3, 3));
        int[] nums4 = {1,2,3,4};
        assertFalse(solution.isPossibleDivide(nums4, 3));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if (max - min < k - 1) {
            return false;
        }
        int[] memo = new int[max - min + 1];
        for (int num : nums) {
            memo[num - min] ++;
        }
        int i = 0;
        for (; i <= max - min + 1 - k; i++) {
            if (memo[i] != 0) {
                for (int j = 1; j < k; j++) {
                    if (memo[i + j] < memo[i]) {
                        return false;
                    }
                    memo[i + j] -= memo[i];
                }
            }
        }
        for(; i < max - min + 1; i++) {
            if (memo[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
