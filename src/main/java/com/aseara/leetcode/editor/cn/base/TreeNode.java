package com.aseara.leetcode.editor.cn.base;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * desc: <br />
 * Date: 2019/12/20 <br/>
 *
 * @author qiujingde
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode fromArray(Integer... array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = root;
        for (int i = 1; i < array.length; i++) {
            TreeNode next = null;
            if (array[i] != null) {
                next = new TreeNode(array[i]);
                queue.add(next);
            }
            if (i % 2 == 1) {
              node.left = next;
            } else  {
                node.right = next;
                queue.poll();
                node = queue.peek();
                if (node == null) {
                    break;
                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = fromArray(10,5,-3,3,2,null,11,3,-2,null,1);
        System.out.println(root.val);
    }

}
