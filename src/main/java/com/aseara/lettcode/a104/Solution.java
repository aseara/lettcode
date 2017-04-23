package com.aseara.lettcode.a104;

/**
 * Created by 邱境德 on 2017/4/23.
 *
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 :
                Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
