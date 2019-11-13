//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划
package com.aseara.leetcode.editor.cn.a322;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 322.零钱兑换 <br />
 * Date: 2019/11/13 <br/>
 *
 * @author qiujingde
 */
class CoinChange {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        assertEquals(3, solution.coinChange(new int[] {1, 2, 5}, 11));
        assertEquals(-1, solution.coinChange(new int[] {2}, 1));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] memo = new int[amount + 1];
        for (int coin : coins) {
            if (coin < amount) {
                memo[coin] = 1;
            } else if (coin == amount) {
                return 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            if (memo[i] > 0) {
                continue;
            }
            int min = -1;
            for (int coin : coins) {
                if (i - coin > 0) {
                    int curMin = memo[i - coin] == -1 ? -1 : memo[i - coin] + 1;
                    min = curMin == -1 || min == -1 ? min + curMin + 1 : Math.min(min, curMin);
                }
            }
            memo[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return memo[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
