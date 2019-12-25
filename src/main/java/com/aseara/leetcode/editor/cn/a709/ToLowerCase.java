//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串
package com.aseara.leetcode.editor.cn.a709;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* desc: 709.转换成小写字母 <br />
* Date: 2019/12/25 <br/>
*
* @author qiujingde
*/
class ToLowerCase {
private Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals("hello", solution.toLowerCase("Hello"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toLowerCase(String str) {
        if(str == null || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        int offset = 'A' - 'a';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char)(chars[i] - offset);
            }
        }

        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
