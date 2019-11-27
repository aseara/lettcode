//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组
package com.aseara.leetcode.editor.cn.a56;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * desc: 56.合并区间 <br />
 * Date: 2019/11/27 <br/>
 *
 * @author qiujingde
 */
class MergeIntervals {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expected1 = {{1,6},{8,10},{15,18}};
        assertArrayEquals(expected1, solution.merge(intervals1));

        int[][] intervals2 = {{1,4},{4,5}};
        int[][] expected2 = {{1,5}};
        assertArrayEquals(expected2, solution.merge(intervals2));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        return merge1(intervals);
    }

    private int[][] merge1(int[][] intervals) {
        List<int[]> result = new ArrayList<>(intervals.length);
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        for (int i = 0; i < intervals.length; i++) {
            int[] mer = new int[2];
            mer[0] = intervals[i][0];
            int end = intervals[i][1];
            while (i + 1 < intervals.length && end >= intervals[i + 1][0]) {
                i ++;
                end = Math.max(end, intervals[i][1]);
            }
            mer[1] = end;
            result.add(mer);
        }
        return result.toArray(new int[0][0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
