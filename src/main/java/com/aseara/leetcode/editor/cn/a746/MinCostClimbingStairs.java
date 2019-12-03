//数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。 
//
// 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。 
//
// 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。 
//
// 示例 1: 
//
// 
//输入: cost = [10, 15, 20]
//输出: 15
//解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
// 
//
// 示例 2: 
//
// 
//输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出: 6
//解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
// 
//
// 注意： 
//
// 
// cost 的长度将会在 [2, 1000]。 
// 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。 
// 
// Related Topics 数组 动态规划
package com.aseara.leetcode.editor.cn.a746;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 746.使用最小花费爬楼梯 <br />
 * Date: 2019/12/3 <br/>
 *
 * @author qiujingde
 */
class MinCostClimbingStairs {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        int[] test1 = {10, 15, 20};
        assertEquals(15, solution.minCostClimbingStairs(test1));

        int[] test2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        assertEquals(6, solution.minCostClimbingStairs(test2));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[cost.length];
        memo[0] = cost[0];
        memo[1] = cost[1];

        for (int i = 2; i < n; i++) {
            memo[i] = Math.min(memo[i - 1], memo[i - 2]) + cost[i];
        }

        return Math.min(memo[n - 1], memo[n - 2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
