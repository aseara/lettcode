//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例 1: 
//
// 
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
// 
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// Related Topics 字符串
package com.aseara.leetcode.editor.cn.a557;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* desc: 557.反转字符串中的单词 III <br />
* Date: 2020/1/4 <br/>
*
* @author qiujingde
*/
class ReverseWordsInAStringIii {
private Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", solution.reverseWords("Let's take LeetCode contest"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = s.length();
        for (int l = 0; l < len; ) {
            int r = l + 1;
            while (r < len && chars[r] != ' ') {
                r ++;
            }
            for (int i = l, j = r - 1; i < j; i++, j--) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
            l = r + 1;
        }
        return new String(chars);
    }

    private String method2(String s) {
        Pattern pattern = Pattern.compile("\\S+");
        Matcher matcher = pattern.matcher(s);
        boolean find = matcher.find();
        if (find) {
            StringBuilder sb = new StringBuilder();
            int end = 0;
            do {
                sb.append(s.substring(end, matcher.start()));
                sb.append(new StringBuilder(matcher.group()).reverse());
                end = matcher.end();
                find = matcher.find();
            } while (find);
            sb.append(s.substring(end));
            return sb.toString();
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
