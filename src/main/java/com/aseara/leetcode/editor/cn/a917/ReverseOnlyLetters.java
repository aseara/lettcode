//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 字符串
package com.aseara.leetcode.editor.cn.a917;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* desc: 917.仅仅反转字母 <br />
* Date: 2020/1/4 <br/>
*
* @author qiujingde
*/
class ReverseOnlyLetters {
private Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals("dc-ba", solution.reverseOnlyLetters("ab-cd"));
        assertEquals("j-Ih-gfE-dCba", solution.reverseOnlyLetters("a-bC-dEf-ghIj"));
        assertEquals("Qedo1ct-eeLg=ntse-T!", solution.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        assertEquals("7_28]", solution.reverseOnlyLetters("7_28]"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        char[] chars = S.toCharArray();
        int len = S.length();
        for (int i = 0, j = len - 1; i < j; i ++, j --) {
            while (i < len - 1 && notAlpha(chars[i])) {
                i ++;
            }
            while (j > 0 && notAlpha(chars[j])) {
                j --;
            }
            if (i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
        }
        return new String(chars);
    }

    private boolean notAlpha(char c) {
        return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
