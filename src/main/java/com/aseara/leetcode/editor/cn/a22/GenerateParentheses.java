//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法
package com.aseara.leetcode.editor.cn.a22;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 22.括号生成 <br />
 * Date: 2019/11/21 <br/>
 *
 * @author qiujingde
 */
class GenerateParentheses {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        Set<String> expected = new HashSet<>(Collections.singletonList("()"));
        assertIterableEquals(expected, new HashSet<>(solution.generateParenthesis(1)));

        expected = new HashSet<>(Arrays.asList("(())", "()()"));
        assertIterableEquals(expected, new HashSet<>(solution.generateParenthesis(2)));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        List<String> result = new LinkedList<>();
        dfs("(", n - 1, n, result);
        return result;
    }

    private void dfs(String prefix, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(prefix);
            return;
        }
        if (left > 0) {
            dfs(prefix + "(", left - 1, right, result);
        }
        if (right > left) {
            dfs(prefix + ")", left, right - 1, result);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
