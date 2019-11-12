//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划
package com.aseara.leetcode.editor.cn.a70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 70.爬楼梯 <br />
 * Date: 2019/11/5 <br/>
 *
 * @author qiujingde
 */
class ClimbingStairs {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        assertEquals(2, solution.climbStairs(2));
        assertEquals(3, solution.climbStairs(3));
        assertEquals(5, solution.climbStairs(4));
        assertEquals(13, solution.climbStairs(6));
    }
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] stairs = new int[] {1, 2};
        int tmp;
        for (int i = 3; i <= n; i++) {
            tmp = stairs[1];
            stairs[1] = stairs[0] + stairs[1];
            stairs[0] = tmp;
        }
        return stairs[1];
    }

    /**
     * 一次可以走1，2，3级台阶，相邻走法不能相同
     * @param n 台阶数
     * @return 可能的走法
     */
    public int climbStairs3(int n) {
        int[][] cache = {
                {1, 0, 1},
                {0, 1, 1},
                {1, 0, 1}};
        if (n <= 3) {
            return cache[0][n - 1] + cache[1][n - 1] + cache[2][n - 1];
        }

        for (int i = 4; i <= n; i++) {
            int s1 = cache[1][2] + cache[2][2];
            int s2 = cache[0][1] + cache[2][1];
            int s3 = cache[0][0] + cache[1][0];

            for (int j = 0; j < 3; j++) {
                cache[j][0] = cache[j][1];
                cache[j][1] = cache[j][2];
            }

            cache[0][2] = s1;
            cache[1][2] = s2;
            cache[2][2] = s3;
        }

        return cache[0][2] + cache[1][2] + cache[2][2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
