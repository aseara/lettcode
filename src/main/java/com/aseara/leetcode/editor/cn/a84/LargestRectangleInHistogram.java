//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组
package com.aseara.leetcode.editor.cn.a84;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 84.柱状图中最大的矩形 <br />
 * Date: 2019/11/10 <br/>
 *
 * @author qiujingde
 */
class LargestRectangleInHistogram {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        assertEquals(10,
                solution.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        if (heights.length == 1) {
            return heights[0];
        }

        LinkedList<Node> stack = new LinkedList<>();

        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int height = i == heights.length ? 0 : heights[i];

            while (!stack.isEmpty() && stack.peek().height > height) {
                int beforeHeight = stack.pop().height;
                int left = stack.isEmpty() ? -1 : stack.peek().index;
                max = Math.max(max, beforeHeight * (i - left - 1));
            }

            stack.push(new Node(i, height));
        }

        return max;
    }

    private static class Node {
        int index;
        int height;
        Node(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
