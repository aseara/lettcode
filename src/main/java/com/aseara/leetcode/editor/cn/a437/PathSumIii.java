//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树
package com.aseara.leetcode.editor.cn.a437;

import com.aseara.leetcode.editor.cn.base.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.aseara.leetcode.editor.cn.base.TreeNode.fromArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 437.路径总和 III <br />
 * Date: 2019/12/25 <br/>
 *
 * @author qiujingde
 */
class PathSumIii {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        TreeNode root1 = fromArray(10,5,-3,3,2,null,11,3,-2,null,1);
        assertEquals(3, solution.pathSum(root1, 8));

        TreeNode root2 = fromArray(5,4,8,11,null,13,4,7,2,null,null,5,1);
        assertEquals(3, solution.pathSum(root2, 22));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int[] nums = new int[1000];
        return pathSum(root, sum, nums, 0);
    }

    private int pathSum(TreeNode node, int sum, int[] nums, int l) {
        if (node == null) {
            return 0;
        }
        int result = sum == node.val ? 1 : 0;
        int tmp = 0;
        for (int i = l - 1; i >= 0; i--) {
            tmp += nums[i];
            if (sum == tmp + node.val) {
                result ++;
            }
        }
        nums[l] = node.val;
        result += pathSum(node.left, sum, nums, l + 1);
        result += pathSum(node.right, sum, nums, l + 1);
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
