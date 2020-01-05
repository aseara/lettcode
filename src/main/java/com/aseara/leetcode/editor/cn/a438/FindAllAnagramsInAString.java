//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表
package com.aseara.leetcode.editor.cn.a438;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* desc: 438.找到字符串中所有字母异位词 <br />
* Date: 2020/1/5 <br/>
*
* @author qiujingde
*/
class FindAllAnagramsInAString {
private Solution solution = new Solution();

    @Test
    void test1() {
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution.findAnagrams("abab", "ab"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        int[] map = new int[26];
        for(char c : p.toCharArray()) {
            map[c - 'a'] ++;
        }
        char[] sChars = s.toCharArray();
        for (int i = 0; i + pLen - 1< sLen; i++) {
            if (i == 0) {
                for (int j = 0; j < pLen; j++) {
                    map[sChars[j] - 'a'] --;
                }
            } else {
                map[sChars[i - 1] - 'a'] ++;
                map[sChars[i + pLen - 1] - 'a'] --;
            }
            if (checkAnagrams(map)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean checkAnagrams(int[] map) {
        for (int cnt : map) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
