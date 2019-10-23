//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表
package com.aseara.leetcode.editor.cn.a94;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;


/**
 * desc: 94.二叉树的中序遍历 <br />
 * Date: 2019/10/23 <br/>
 *
 * @author qiujingde
 */
class BinaryTreeInorderTraversal {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode child = new TreeNode(2);
        root.right = child;
        child.left = new TreeNode(3);

        List<Integer> expected = Arrays.asList(1, 3, 2);
        assertIterableEquals(expected, solution.inorderTraversal(root));
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traversal(root, list);
        return list;
    }


    private void traversal(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }
        traversal(root.left, store);
        store.add(root.val);
        traversal(root.right, store);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
