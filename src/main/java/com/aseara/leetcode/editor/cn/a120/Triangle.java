//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划
package com.aseara.leetcode.editor.cn.a120;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 120.三角形最小路径和 <br />
 * Date: 2019/11/12 <br/>
 *
 * @author qiujingde
 */
class Triangle {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        List<List<Integer>> triangle = Arrays.asList(
                Collections.singletonList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );

        assertEquals(11, solution.minimumTotal(triangle));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] cache = new int[triangle.size()];
        cache[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> level = triangle.get(i);
            cache[level.size() - 1] = cache[level.size() - 2] +
                    level.get(level.size() - 1);
            for (int j = level.size() - 2; j > 0; j--) {
                cache[j] = Math.min(cache[j - 1], cache[j]) + level.get(j);
            }
            cache[0] = cache[0] + level.get(0);

        }

        int min = Integer.MAX_VALUE;
        for (int i : cache) {
            min = Math.min(min, i);
        }

        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
