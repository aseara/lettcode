//给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。 
//
// 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是） 
//
// 示例 1: 
//
// 输入: S = "rabbbit", T = "rabbit"
//输出: 3
//解释:
//
//如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// 示例 2: 
//
// 输入: S = "babgbag", T = "bag"
//输出: 5
//解释:
//
//如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
//(上箭头符号 ^ 表示选取的字母)
//
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 
// Related Topics 字符串 动态规划
package com.aseara.leetcode.editor.cn.a115;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* desc: 115.不同的子序列 <br />
* Date: 2019/12/21 <br/>
*
* @author qiujingde
*/
class DistinctSubsequences {
private Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals(3, solution.numDistinct("rabbbit", "rabbit"));
        assertEquals(5, solution.numDistinct("babgbag", "bag"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0 ||
                t == null || t.length() == 0) {
            return 0;
        }
        int m = s.length();
        int n = t.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[][] dp = new int[n + 1][m + 1];
        Arrays.fill(dp[0], 1);
        // 外层遍历t
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = sChars[j] == tChars[i] ? dp[i][j] + dp[i + 1][j] : dp[i + 1][j];
            }
        }
        return dp[n][m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
