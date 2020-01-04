//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串
package com.aseara.leetcode.editor.cn.a14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* desc: 14.最长公共前缀 <br />
* Date: 2020/1/4 <br/>
*
* @author qiujingde
*/
class LongestCommonPrefix {
private Solution solution = new Solution();

    @Test
    void test1() {
        String[] strs1 = {"flower","flow","flight"};
        assertEquals("fl", solution.longestCommonPrefix(strs1));

        String[] strs2 = {"dog","racecar","car"};
        assertEquals("", solution.longestCommonPrefix(strs2));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int index = 0;
        for (; index < strs[0].length(); index++) {
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index == strs[i].length() || c != strs[i].charAt(index)) {
                    return strs[0].substring(0, index);
                }
            }
        }
        return strs[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
