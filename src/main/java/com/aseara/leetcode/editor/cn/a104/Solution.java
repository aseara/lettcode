package com.aseara.leetcode.editor.cn.a104;

import com.aseara.leetcode.editor.cn.base.TreeNode;

/**
 * Created by 邱境德 on 2017/4/23.
 * Algorithm 104
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 :
                Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
