//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索
package com.aseara.leetcode.editor.cn.a429;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 429.N叉树的层序遍历 <br />
 * Date: 2019/10/26 <br/>
 *
 * @author qiujingde
 */
class NAryTreeLevelOrderTraversal {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        Node root = new Node(1, new LinkedList<>());

        Node child = new Node(3, new LinkedList<>());
        child.children.add(new Node(5, null));
        child.children.add(new Node(6, null));

        root.children.add(child);
        root.children.add(new Node(2, null));
        root.children.add(new Node(4, null));

        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(1),
                Arrays.asList(3, 2, 4),
                Arrays.asList(5, 6)
        );
        assertIterableEquals(expected, solution.levelOrder(root));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> store = new LinkedList<>();

        if (root != null) {
//            LinkedList<Node> rootLevel = new LinkedList<>();
//            rootLevel.add(root);
//            traversal2(rootLevel, store);

            List<Node> curLevel = Collections.singletonList(root);
            List<Integer> curStore = Collections.singletonList(root.val);

            while (!curStore.isEmpty()) {
                store.add(curStore);

                curStore = new LinkedList<>();
                List<Node> nextLevel = new LinkedList<>();

                for (Node node : curLevel) {
                    if (node.children != null) {
                        for (Node child : node.children) {
                            curStore.add(child.val);
                            nextLevel.add(child);
                        }
                    }
                }
                curLevel = nextLevel;
            }
        }

        return store;
    }

    private void traversal(LinkedList<Node> curLevel, List<List<Integer>> store) {
        if (curLevel == null || curLevel.isEmpty()) {
            return;
        }
        traversal(storeCurLevelAndReturnNexLevel(curLevel, store), store);
    }

    private void traversal2(LinkedList<Node> curLevel, List<List<Integer>> store) {
        while (curLevel != null && !curLevel.isEmpty()) {
            curLevel = storeCurLevelAndReturnNexLevel(curLevel, store);
        }
    }

    private LinkedList<Node> storeCurLevelAndReturnNexLevel(
            List<Node> curLevel, List<List<Integer>> store) {
        List<Integer> curStore = new LinkedList<>();
        store.add(curStore);
        LinkedList<Node> nextLevel = new LinkedList<>();
        for (Node node : curLevel) {
            curStore.add(node.val);
            if (node.children != null) {
                nextLevel.addAll(node.children);
            }
        }
        return nextLevel;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
