//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。 
//
// 示例 : 
//
// 输入: [1,2,1,3,2,5]
//输出: [3,5] 
//
// 注意： 
//
// 
// 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。 
// 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
// 
// Related Topics 位运算

package com.aseara.leetcode.editor.cn.a260;

import org.junit.jupiter.api.Test;

/**
 * desc: 260.只出现一次的数字 III <br />
 * Date: 2020/4/3 <br/>
 *
 * @author qiujingde
 */
class SingleNumberIii {
    private Solution solution = new Solution();
    
    @Test
    void test1() {

    }
    
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[2];

        // 1. 全部异或
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // 2. 找出最低位的1
        int low = xor & -xor;

        // 3. 找出第一个数字
        int num1 = 0;
        for (int num : nums) {
            if ((num & low) != 0) {
                num1 ^= num;
            }
        }

        // 4. 获取所有结果
        result[0] = num1;
        result[1] = xor ^ num1;

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
