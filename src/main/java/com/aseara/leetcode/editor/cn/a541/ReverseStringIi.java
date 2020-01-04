//给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。 
//
// 示例: 
//
// 
//输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 要求: 
//
// 
// 该字符串只包含小写的英文字母。 
// 给定字符串的长度和 k 在[1, 10000]范围内。 
// 
// Related Topics 字符串
package com.aseara.leetcode.editor.cn.a541;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* desc: 541.反转字符串 II <br />
* Date: 2020/1/4 <br/>
*
* @author qiujingde
*/
class ReverseStringIi {
private Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals("bacdfeg", solution.reverseStr("abcdefg", 2));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i += 2 * k) {
            int l = i;
            int r = Math.min(i + k, len) - 1;
            for (; l < r; l++, r--) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
            }
        }
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
