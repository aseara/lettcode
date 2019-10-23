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

import java.util.Arrays;
import java.util.Comparator;
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
        List<List<String>> result = new LinkedList<>();

        // 按长度排序
        Arrays.sort(strs, Comparator.comparingInt(String::length));

        int lastLength = -1;
        List<List<String>> groupResult = new LinkedList<>();
        int[][] groupAnagramAlphaMaps = null;
        for (String str : strs) {
            int curLength = str.length();

            if (curLength != lastLength) {
                groupResult.clear();
                groupAnagramAlphaMaps = new int[strs.length][];
                lastLength = curLength;
            }

            groupAnagrams(result, groupResult, groupAnagramAlphaMaps, str);
        }

        return result;
    }

    private void groupAnagrams(List<List<String>> result, List<List<String>> groupResult, int[][] anagramAlphaMaps, String str) {
        int[] curAlphaMap = alphaMap(str);
        int anagramIndex = getAnagramIndex(groupResult.size(), anagramAlphaMaps, curAlphaMap);
        if (anagramIndex == groupResult.size()) {
            List<String> anagrams = new LinkedList<>();
            result.add(anagrams);
            groupResult.add(anagrams);
            anagramAlphaMaps[anagramIndex] = curAlphaMap;
        }
        groupResult.get(anagramIndex).add(str);
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
     * @param anagramAlphaMaps 之前的异位词映射
     * @param curAlphaMap 当前异位词映射
     * @return 当前字符串在异位词列表的序号
     */
    private int getAnagramIndex(int size, int[][] anagramAlphaMaps, int[] curAlphaMap) {
        anaGroup:
        for (int i = 0; i < size; i++) {
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
