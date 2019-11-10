//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组
package com.aseara.leetcode.editor.cn.a189;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * desc: 189.旋转数组 <br />
 * Date: 2019/11/9 <br/>
 *
 * @author qiujingde
 */
class RotateArray {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        int[] nums = { 1,2,3,4,5,6,7 };
        int[] expected = { 5,6,7,1,2,3,4 };

        solution.rotate(nums, 3);
        assertArrayEquals(expected, nums);

        nums = new int[]{ -1,-100,3,99 };
        expected = new int[]{ 3,99,-1,-100 };

        solution.rotate(nums, 2);
        assertArrayEquals(expected, nums);

        nums = new int[]{ 1, 2 };
        solution.rotate(nums, 3);
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        rotate3(nums, k);
    }

    private void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp2 = nums[j];
                nums[j] = temp;
                temp = temp2;
            }
        }
    }

    private void rotate2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    private void rotate3(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return;
        }
        k = k % len;
        int moves = 0;
        for (int i = 0; i < k; i++) {
            // 已经移动所有的节点
            if (moves == len) {
                return;
            }

            int cur = i;
            int temp = nums[i];
            do {
                // for i , shift pos i + k
                int next = cur + k > len - 1 ? cur + k - len : cur + k;

                int shift = nums[next];
                nums[next] = temp;
                temp = shift;
                moves ++;

                cur = next;
            } while (cur > i);

        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
