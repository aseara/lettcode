//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 进阶： 
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串
package com.aseara.leetcode.editor.cn.a151;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* desc: 151.翻转字符串里的单词 <br />
* Date: 2020/1/4 <br/>
*
* @author qiujingde
*/
class ReverseWordsInAString {
private Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals("blue is sky the", solution.reverseWords("the sky is blue"));
        assertEquals("world! hello", solution.reverseWords("  hello world!  "));
        assertEquals("example good a", solution.reverseWords("a good   example"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        LinkedList<Integer> indexStack = new LinkedList<>();
        int len = chars.length;
        for (int i = 0; i < len; ) {
            int l = i;
            while (l < len && chars[l] == ' ') {
                l ++;
            }
            int r = l;
            if (r < len) {
                r ++;
                while (r < len && chars[r] != ' ') {
                    r ++;
                }
                indexStack.push(l);
                indexStack.push(r);
            }
            i = r;
        }

        StringBuilder sb = new StringBuilder();
        while (!indexStack.isEmpty()) {
            int r = indexStack.pop();
            int l = indexStack.pop();
            for (int i = l; i < r; i++) {
                sb.append(chars[i]);
            }
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private String method2(String s) {
        String[] words = s.split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
