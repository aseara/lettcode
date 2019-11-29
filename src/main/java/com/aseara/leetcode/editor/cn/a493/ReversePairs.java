//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法
package com.aseara.leetcode.editor.cn.a493;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 493.翻转对 <br />
 * Date: 2019/11/28 <br/>
 *
 * @author qiujingde
 */
class ReversePairs {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        int[] test1 = {1,3,2,3,1};
        assertEquals(2, solution.reversePairs(test1));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return merge(nums, 0, nums.length - 1);
    }

    private int merge(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) >> 1;
        int cnt = merge(nums, l, mid);
        cnt += merge(nums,mid + 1, r);

        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1;
        int k = 0;

        int n = mid + 1;
        for (int m = l; m <= mid; m++) {
            for (; n <= r; n++) {
                if (nums[m] > 2L * nums[n]) {
                    cnt += mid - m + 1;
                } else {
                    break;
                }
            }
        }

        while (i <= mid && j <= r) {
            tmp[k++] = nums[i] > nums[j] ? nums[j++] : nums[i++];
        }
        if (i <= mid) {
            System.arraycopy(nums, i, tmp, k, mid - i + 1);
        }
        if (j <= r) {
            System.arraycopy(nums, j, tmp, k, r - j + 1);
        }
        System.arraycopy(tmp, 0, nums, l, tmp.length);
        return cnt;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
