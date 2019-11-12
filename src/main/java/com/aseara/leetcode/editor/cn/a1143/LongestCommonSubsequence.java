//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划
package com.aseara.leetcode.editor.cn.a1143;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 1143.最长公共子序列 <br />
 * Date: 2019/11/11 <br/>
 *
 * @author qiujingde
 */
class LongestCommonSubsequence {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        assertEquals(3, solution.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, solution.longestCommonSubsequence("abc", "abc"));
        assertEquals(0, solution.longestCommonSubsequence("abc", "def"));
        assertEquals(6, solution.longestCommonSubsequence("papmretkborsrurgtina",
                "nsnupotstmnkfcfavaxgl"));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        int[][] maxCache = new int[chars1.length][chars2.length];
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                maxCache[i][j] = -1;
            }
        }

        return longestCommonSubsequence(chars1, chars2, 0, 0, true, maxCache);
    }

    private int longestCommonSubsequence(char[] lChars, char[] sChars, int lStart, int sStart,
                                         boolean dir, int[][] maxCache) {
        if (lChars.length == lStart || sChars.length == sStart) {
            return 0;
        }

        if (lChars.length - lStart < sChars.length - sStart) {
            return longestCommonSubsequence(sChars, lChars, sStart, lStart, !dir, maxCache);
        }

        int cacheMax = dir ? maxCache[lStart][sStart] : maxCache[sStart][lStart];
        if (cacheMax != -1) {
            return cacheMax;
        }

        char c = sChars[sStart];
        int nextStart = lStart;
        boolean find = false;
        for (; nextStart < lChars.length && !find; nextStart++) {
            find = lChars[nextStart] == c;
        }

        int max;

        // 没有找到 c
        if (!find) {
            max = longestCommonSubsequence(lChars, sChars, lStart, sStart + 1, dir, maxCache);
        } else {
            int max1 = longestCommonSubsequence(lChars, sChars, nextStart, sStart + 1, dir, maxCache);
            if (max1 == sChars.length - sStart - 1 || nextStart == lStart + 1) {
                max = max1 + 1;
            } else {
                max = Math.max(max1 + 1, longestCommonSubsequence(lChars, sChars, lStart, sStart + 1, dir, maxCache));
            }
        }

        if (dir) {
            maxCache[lStart][sStart] = max;
        } else {
            maxCache[sStart][lStart] = max;
        }

        return max;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
