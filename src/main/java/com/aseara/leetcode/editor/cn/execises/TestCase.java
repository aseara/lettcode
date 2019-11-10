//在柠檬水摊上，每一杯柠檬水的售价为 5 美元。 
//
// 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。 
//
// 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。 
//
// 注意，一开始你手头没有任何零钱。 
//
// 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。 
//
// 示例 1： 
//
// 输入：[5,5,5,10,20]
//输出：true
//解释：
//前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
//第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
//第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
//由于所有客户都得到了正确的找零，所以我们输出 true。
// 
//
// 示例 2： 
//
// 输入：[5,5,10]
//输出：true
// 
//
// 示例 3： 
//
// 输入：[10,10]
//输出：false
// 
//
// 示例 4： 
//
// 输入：[5,5,10,10,20]
//输出：false
//解释：
//前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
//对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
//对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
//由于不是每位顾客都得到了正确的找零，所以答案是 false。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= bills.length <= 10000 
// bills[i] 不是 5 就是 10 或是 20 
// 
// Related Topics 贪心算法
package com.aseara.leetcode.editor.cn.execises;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 860.柠檬水找零 <br />
 * Date: 2019/11/3 <br/>
 *
 * @author qiujingde
 */
class LemonadeChange {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        TreeNode root = new TreeNode(3);

        TreeNode node = root;
        node.left = new TreeNode(9);
        node = node.right = new TreeNode(20);

        node.left = new TreeNode(15);
        node.right = new TreeNode(7);

        assertEquals(3, solution.maxDepth(root));

        assertEquals(1, solution.climbStairs(1));
        assertEquals(2, solution.climbStairs(2));
        assertEquals(3, solution.climbStairs(3));
        assertEquals(5, solution.climbStairs(4));
        assertEquals(8, solution.climbStairs(5));


        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] expected = {0, 1};
        assertArrayEquals(expected, solution.twoSum(nums, target));
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.right),
                maxDepth(root.left)) + 1;
    }

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int pre2 = 1;
        int pre1 = 2;
        int cnt = 0;
        for (int i = 3; i <= n; i++) {
            cnt = pre1 + pre2;
            pre2 = pre1;
            pre1 = cnt;
        }

        return cnt;
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
