//给你一个整数数组 nums 和一个正整数 threshold ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。 
//
// 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。 
//
// 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。 
//
// 题目保证一定有解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,5,9], threshold = 6
//输出：5
//解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
//如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5 (1+1+1+2)。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,5,7,11], threshold = 11
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：nums = [19], threshold = 5
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10^4 
// 1 <= nums[i] <= 10^6 
// nums.length <= threshold <= 10^6 
// 
// Related Topics 二分查找
package com.aseara.leetcode.editor.cn.a1283;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 1283.Find the Smallest Divisor Given a Threshold <br />
 * Date: 2019/12/12 <br/>
 *
 * @author qiujingde
 */
class FindTheSmallestDivisorGivenAThreshold {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        int[] nums1 = {1, 2, 5, 9};
        assertEquals(5, solution.smallestDivisor(nums1, 6));
        int[] nums2 = {2,3,5,7,11};
        assertEquals(3, solution.smallestDivisor(nums2, 11));
        int[] nums3 = {19};
        assertEquals(4, solution.smallestDivisor(nums3, 5));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // 1. 求最大值
        int left = 1;
        int right = max(nums);
        // 2. 从1到最大值，使用二分法查找不大于threshold的最小值
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sumDivideGt(nums, mid, threshold)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean sumDivideGt(int[] nums, int d, int t) {
        int result = 0;
        for (int num : nums) {
            result += (num + d - 1) / d;
        }
        return result > t;
    }

    private int max(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
