//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串
package com.aseara.leetcode.editor.cn.a49;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * desc: 49.字母异位词分组 <br />
 * Date: 2019/10/23 <br/>
 *
 * @author qiujingde
 */
class GroupAnagrams {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        String[] test = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = solution.groupAnagrams(test);
        System.out.println(result);
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>(strs.length);

        int[] anagramLength = new int[strs.length];
        int[][] anagramAlphaMaps = new int[strs.length][];

        for (String str : strs) {
            int[] curAlphaMap = alphaMap(str);
            int curLength = str.length();
            int anagramIndex = getAnagramIndex(result.size(), anagramLength, anagramAlphaMaps,
                    curLength, curAlphaMap);
            if (anagramIndex == result.size()) {
                result.add(new LinkedList<>());
                anagramAlphaMaps[anagramIndex] = curAlphaMap;
                anagramLength[anagramIndex] = curLength;
            }
            result.get(anagramIndex).add(str);
        }

        return result;
    }

    /**
     * 获取当前字符串的字母映射
     * @param str 字符串
     * @return 字母映射
     */
    private int[] alphaMap(String str) {
        int[] result = new int[26];
        for (char iChar : str.toCharArray()) {
            result[iChar - 'a'] ++;
        }
        return result;
    }

    /**
     * 判断当前字符串是否在之前的异位词列表中，如果是返回对应的序号，不是返回size
     * @param size 当前异位词组数
     * @param anagramLength 之前的异位词长度
     * @param anagramAlphaMaps 之前的异位词映射
     * @param curLength 当前异位词长度
     * @param curAlphaMap 当前异位词映射
     * @return 当前字符串在异位词列表的序号
     */
    private int getAnagramIndex(int size, int[] anagramLength, int[][] anagramAlphaMaps,
                                int curLength, int[] curAlphaMap) {
        anaGroup:
        for (int i = 0; i < size; i++) {
            if (curLength != anagramLength[i]) {
                continue;
            }
            int[] expected = anagramAlphaMaps[i];
            for (int j = 0; j < 26; j++) {
                if (expected[j] != curAlphaMap[j]) {
                    // 不匹配，检查下一组
                    continue anaGroup;
                }
            }
            // 确认与 i 组是异味词
            return i;
        }
        return size;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
