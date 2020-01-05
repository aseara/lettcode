//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串
package com.aseara.leetcode.editor.cn.a125;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
* desc: 125.验证回文串 <br />
* Date: 2020/1/5 <br/>
*
* @author qiujingde
*/
class ValidPalindrome {
private Solution solution = new Solution();

    @Test
    void test1() {
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < len && !Character.isAlphabetic(chars[i]) && !Character.isDigit(chars[i])) {
                i ++;
            }
            while (j >=0 && !Character.isAlphabetic(chars[j]) && !Character.isDigit(chars[j])) {
                j --;
            }
            char l = chars[i];
            char r = chars[j];
            if (i < j && Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
