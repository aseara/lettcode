//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树
package com.aseara.leetcode.editor.cn.a145;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 145.二叉树的后序遍历 <br />
 * Date: 2019/10/24 <br/>
 *
 * @author qiujingde
 */
class BinaryTreePostorderTraversal {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode child = new TreeNode(2);
        root.right = child;
        child.left = new TreeNode(3);

        List<Integer> expected = Arrays.asList(3, 2, 1);
        assertIterableEquals(expected, solution.postorderTraversal(root));
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> store = new LinkedList<>();
        traversal2(root, store);
        return store;
    }

    private void traversal(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }
        traversal(root.left, store);
        traversal(root.right, store);
        store.add(root.val);
    }

    private void traversal2(TreeNode root, List<Integer> store) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Boolean> direction = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            while (node.left != null) {
                stack.push(node.left);
                direction.push(true);
                node = node.left;
            }

            boolean r = true;
            while (!r || node.right == null) {
                node = stack.pop();
                store.add(node.val);
                if (stack.isEmpty()) {
                    return;
                }
                node = stack.peek();
                r = direction.pop();
            }

            stack.push(node.right);
            direction.push(false);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
