//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。 
//
// 
//
// 示例 1： 
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
// Related Topics 双指针 字符串
package com.aseara.leetcode.editor.cn.a344;

import org.junit.jupiter.api.Test;

/**
* desc: 344.反转字符串 <br />
* Date: 2020/1/4 <br/>
*
* @author qiujingde
*/
class ReverseString {
    private Solution solution = new Solution();

    @Test
    void test1() {
        char[] s = {'h','e','l','l','o'};
        System.out.println(s);
        solution.reverseString(s);
        System.out.println(s);
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }
        int mid = s.length / 2;
        char tmp;
        for (int i = 0; i < mid; i++) {
            tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
