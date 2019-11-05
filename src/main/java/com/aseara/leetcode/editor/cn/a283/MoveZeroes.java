//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针
package com.aseara.leetcode.editor.cn.a283;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * desc: 283.移动零 <br />
 * Date: 2019/11/5 <br/>
 *
 * @author qiujingde
 */
class MoveZeroes {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        int[] array = new int[] {0,1,0,3,12};
        solution.moveZeroes(array);

        assertArrayEquals(new int[] {1,3,12,0,0}, array);

        array = new int[] {0,0,0,0,0,1};
        solution.moveZeroes(array);
        assertArrayEquals(new int[] {1,0,0,0,0,0}, array);

        array = new int[] {0,1,0};
        solution.moveZeroes(array);
        assertArrayEquals(new int[] {1,0,0}, array);

        array = new int[] {0,0,1};
        solution.moveZeroes(array);
        assertArrayEquals(new int[] {1,0,0}, array);
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        path2(nums);
    }

    private void path1(int[] nums) {
        int zeroSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroSize ++;
            } else if (zeroSize != 0) {
                nums[i - zeroSize] = nums[i];
            }
        }
        for (int i = 0; i < zeroSize; i++) {
            nums[nums.length - zeroSize + i] = 0;
        }
    }

    private void path2(int[] nums) {
        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (slowIndex != i) {
                    nums[slowIndex] = nums[i];
                    nums[i] = 0;
                }
                slowIndex ++;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
