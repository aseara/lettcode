//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例: 
//
// 输入: [1,8,6,2,5,4,8,3,7]
//输出: 49 
// Related Topics 数组 双指针
package com.aseara.leetcode.editor.cn.a11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 11.盛最多水的容器 <br />
 * Date: 2019/11/5 <br/>
 *
 * @author qiujingde
 */
class ContainerWithMostWater {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        int[] arr = new int[] {1,8,6,2,5,4,8,3,7};
        assertEquals(49, solution.maxArea(arr));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length -1; i != j; ) {
            int minHeight = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, (j - i) * minHeight);
            while (height[j] <= minHeight && i != j) {
                j --;
            }
            while (height[i] <= minHeight && i != j) {
                i ++;
            }
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
