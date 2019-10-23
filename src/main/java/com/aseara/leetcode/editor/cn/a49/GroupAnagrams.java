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
        String[] test = new String[] { "tao","pit","cam","aid","pro","dog" };
        List<List<String>> result = solution.groupAnagrams(test);
        System.out.println(result);
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] alphas = new int[26];
            for (char sChar : str.toCharArray()) {
                alphas[sChar - 'a'] ++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : alphas) {
                sb.append('.').append(i);
            }
            map.computeIfAbsent(sb.toString(), k -> new LinkedList<>())
                    .add(str);
        }

        return new ArrayList<>(map.values());
    }

}
//leetcode submit region end(Prohibit modification and deletion)
