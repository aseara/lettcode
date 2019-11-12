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


        int m = chars1.length;
        int n = chars2.length;
        int[][] maxCache = new int[m][n];


        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1) {
                    maxCache[i][j] = chars1[i] == chars2[j] ? 1 :
                            j == n - 1 ? 0 : maxCache[i][j + 1];
                } else if (j == n - 1) {
                    maxCache[i][j] = chars1[i] == chars2[j] ? 1 : maxCache[i + 1][j];
                } else if (chars1[i] == chars2[j]) {
                    maxCache[i][j] = maxCache[i + 1][j + 1] + 1;
                } else {
                    maxCache[i][j] = Math.max(maxCache[i][j + 1], maxCache[i + 1][j]);
                }
            }
        }

        return maxCache[0][0];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
