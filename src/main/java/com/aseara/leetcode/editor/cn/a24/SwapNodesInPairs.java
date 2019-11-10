//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表
package com.aseara.leetcode.editor.cn.a24;


import com.aseara.leetcode.editor.cn.base.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.aseara.leetcode.editor.cn.base.ListNode.fromArr;
import static com.aseara.leetcode.editor.cn.base.ListNode.toArr;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 24.两两交换链表中的节点 <br />
 * Date: 2019/11/8 <br/>
 *
 * @author qiujingde
 */
class SwapNodesInPairs {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        ListNode head = fromArr(Arrays.asList(1, 2, 3, 4));
        List<Integer> expected = Arrays.asList(2, 1, 4, 3);
        head = solution.swapPairs(head);
        assertIterableEquals(expected, toArr(head));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
