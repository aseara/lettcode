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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

        Map<Integer, List<List<String>>> resultMap = new HashMap<>(strs.length);
        Map<Integer, int[][]> anagramAlphaMapsMap = new HashMap<>(strs.length);
        List<Integer> lengthList = new LinkedList<>();

        for (String str : strs) {
            int curLength = str.length();
            if (!resultMap.containsKey(curLength)) {
                resultMap.put(curLength, new LinkedList<>());
                anagramAlphaMapsMap.put(curLength, new int[strs.length][]);
                lengthList.add(curLength);
            }
            List<List<String>> groupResult = resultMap.get(curLength);
            int[][] groupAnagramAlphaMaps = anagramAlphaMapsMap.get(curLength);

            groupAnagrams(groupResult, groupAnagramAlphaMaps, str);
        }

        for(int length : lengthList) {
            result.addAll(resultMap.get(length));
        }

        return result;
    }

    private void groupAnagrams(List<List<String>> result, int[][] anagramAlphaMaps, String str) {
        int[] curAlphaMap = alphaMap(str);
        int anagramIndex = getAnagramIndex(result.size(), anagramAlphaMaps, curAlphaMap);
        if (anagramIndex == result.size()) {
            result.add(new LinkedList<>());
            anagramAlphaMaps[anagramIndex] = curAlphaMap;
        }
        result.get(anagramIndex).add(str);
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
