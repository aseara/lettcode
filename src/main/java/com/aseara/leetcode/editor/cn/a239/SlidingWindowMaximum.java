//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
// Related Topics 堆 Sliding Window
package com.aseara.leetcode.editor.cn.a239;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * desc: 239.滑动窗口最大值 <br />
 * Date: 2019/11/10 <br/>
 *
 * @author qiujingde
 */
class SlidingWindowMaximum {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        int[] nums = { 1,3,-1,-3,5,3,6,7 };
        int[] expected = { 3,3,5,5,6,7 };

        assertArrayEquals(expected, solution.maxSlidingWindow(nums, 3));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length -k + 1];
        LinkedList<Node> maxStack = new LinkedList<>();
        // 初始化
        for (int i = 0; i < k; i++) {
            int curVal = nums[i];
            while (!maxStack.isEmpty() && curVal > maxStack.peek().val) {
                maxStack.pop();
            }
            maxStack.push(new Node(i, curVal));
        }
        result[0] = maxStack.peekLast().val;
        for (int i = k; i < nums.length; i++) {
            if (i - maxStack.peekLast().index == k) {
                maxStack.removeLast();
            }
            int curVal = nums[i];
            while (!maxStack.isEmpty() && curVal > maxStack.peek().val) {
                maxStack.pop();
            }
            maxStack.push(new Node(i, curVal));
            result[i - k + 1] = maxStack.peekLast().val;
        }
        return result;
    }

    private static class Node {
        int index;
        int val;
        Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
