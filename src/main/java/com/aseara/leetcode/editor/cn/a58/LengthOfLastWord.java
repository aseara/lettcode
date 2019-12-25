//给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指由字母组成，但不包含任何空格的字符串。 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串
package com.aseara.leetcode.editor.cn.a58;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* desc: 58.最后一个单词的长度 <br />
* Date: 2019/12/25 <br/>
*
* @author qiujingde
*/
class LengthOfLastWord {
private Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals(1, solution.lengthOfLastWord("a "));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        boolean find = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (chars[i] == ' ' && find) {
                return result;
            }
            if (chars[i] != ' ') {
                find = true;
                result ++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
