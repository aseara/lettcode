//给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数： 
//
// 
// 子串中不同字母的数目必须小于等于 maxLetters 。 
// 子串的长度必须大于等于 minSize 且小于等于 maxSize 。 
// 
//
// 
//
// 示例 1： 
//
// 输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
//输出：2
//解释：子串 "aab" 在原字符串中出现了 2 次。
//它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
// 
//
// 示例 2： 
//
// 输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
//输出：2
//解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
// 
//
// 示例 3： 
//
// 输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
//输出：3
// 
//
// 示例 4： 
//
// 输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 1 <= maxLetters <= 26 
// 1 <= minSize <= maxSize <= min(26, s.length) 
// s 只包含小写英文字母。 
// 
// Related Topics 位运算 字符串
package com.aseara.leetcode.editor.cn.a5293;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
* desc: 5293.Maximum Number of Occurrences of a Substring <br />
* Date: 2019/12/22 <br/>
*
* @author qiujingde
*/
class MaximumNumberOfOccurrencesOfASubstring {
private Solution solution = new Solution();

    @Test
    void test1() {
    
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int max = 0;
        char[] chars = s.toCharArray();
        int size = s.length();

        Map<String, Integer> freqMap = new HashMap<>();

        for (int i = 0; i <= size - minSize; i++) {
            for (int j = 0; j <= maxSize - minSize; j++) {
                if (i + j + minSize > size) {
                    break;
                }
                if (checkMaxLetters(chars, i, minSize + j, maxLetters)) {
                    String sub = new String(chars, i, minSize + j);
                    int freq = freqMap.getOrDefault(sub, 0) + 1;
                    freqMap.put(sub, freq);
                    max = Math.max(max, freq);
                }
            }
        }
        return max;
    }

    private boolean checkMaxLetters(char[] chars, int offset, int count, int maxLetters) {
        int cnt = 0;
        boolean[] check = new boolean[26];
        for (int i = 0; i < count; i++) {
            int index = chars[offset + i] - 'a';
            if (!check[index]) {
                check[index] = true;
                cnt ++;
                if (cnt > maxLetters) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
