//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 案例: 
//
// 
//s = "leetcode"
//返回 0.
//
//s = "loveleetcode",
//返回 2.
// 
//
// 
//
// 注意事项：您可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串
package com.aseara.leetcode.editor.cn.a387;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* desc: 387.字符串中的第一个唯一字符 <br />
* Date: 2019/12/25 <br/>
*
* @author qiujingde
*/
class FirstUniqueCharacterInAString {
private Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals(0, solution.firstUniqChar("leetcode"));
        assertEquals(2, solution.firstUniqChar("loveleetcode"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cnt[c - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (cnt[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
