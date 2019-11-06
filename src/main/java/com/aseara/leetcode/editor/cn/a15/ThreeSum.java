//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针
package com.aseara.leetcode.editor.cn.a15;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * desc: 15.三数之和 <br />
 * Date: 2019/11/6 <br/>
 *
 * @author qiujingde
 */
class ThreeSum {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        System.out.println(solution.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(solution.threeSum(new int[] { 0, 0, 0 }));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        // 排序数组  复杂度 O(N * logN)
        Arrays.sort(nums);

        // 如果排序后的数组全部是正数或者全部是负数，
        // 不可能存在符合条件的组合
        if ((nums[0] > 0 && nums[nums.length - 1] > 0) ||
                (nums[0] < 0 && nums[nums.length - 1] < 0)) {
            return result;
        }

        //
        Map<Integer, Integer> intCntMap = new HashMap<>(nums.length);
        for (int num : nums) {
            intCntMap.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        if (intCntMap.getOrDefault(0, 0) > 2) {
            result.add(Arrays.asList(0, 0, 0));
        }

        int minLeft = 0;

        for (int right = nums.length - 1; nums[right] > 0; right -- ) {
            // 跳过重复
            if (nums[right] == nums[right - 1]) {
                continue;
            }

            for (int left = minLeft; nums[left] < 0; left ++) {
                // 跳过重复
                if (nums[left] == nums[left + 1]) {
                    continue;
                }
                int three = (nums[right] + nums[left]) * -1;

                // 继续遍历左边，three会越来越小，
                // 直接遍历下一个right
                if (three < nums[left]) {
                    break;
                }

                if (three > nums[right]) {
                    minLeft = left + 1;
                    continue;
                }

                int needCnt = 1;
                if (nums[left] == three) {
                    needCnt ++;
                }
                if (three == nums[right]) {
                    needCnt ++;
                }
                if (intCntMap.getOrDefault(three, 0) >= needCnt) {
                    result.add(Arrays.asList(nums[left], three, nums[right]));
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
