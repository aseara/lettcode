//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
// Related Topics 链表 双指针
package com.aseara.leetcode.editor.cn.a142;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * desc: 142.环形链表 II <br />
 * Date: 2019/11/9 <br/>
 *
 * @author qiujingde
 */
class LinkedListCycleIi {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        assertNull(solution.detectCycle(null));

        ListNode node = new ListNode(1);
        assertNull(solution.detectCycle(node));

        node.next = node;
        assertEquals(node, solution.detectCycle(node));

        ListNode head = new ListNode(3);
        node = head.next = new ListNode(2);
        node = node.next = new ListNode(0);
        node = node.next = new ListNode(-4);
        node.next = head.next;
        assertEquals(head.next, solution.detectCycle(head));

        head = new ListNode(1);
        node = head.next = new ListNode(2);
        node.next = head;
        assertEquals(head, solution.detectCycle(head));
    }
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode prt2 = null;
        for (ListNode slow = head.next, fast = head.next.next;
            // 到达结束节点，没有环
             fast != null && fast.next != null;
             slow = slow.next, fast = fast.next.next) {
            // fast 和 slow 重合， 有环
            if (fast == slow) {
                prt2 = slow;
                break;
            }
        }

        if (prt2 == null) {
            return null;
        }

        for (ListNode prt1 = head; prt1 != prt2; ){
            prt1 = prt1.next;
            prt2 = prt2.next;
        }

        return prt2;
    }

    private ListNode method2(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        for (ListNode crt = head; crt != null; crt = crt.next) {
            if (nodeSet.contains(crt)) {
                return crt;
            }
            nodeSet.add(crt);
        }
        return null;
    }

    private ListNode method3(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        for (; fast != null && fast.next != null; ) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        for (fast = head; fast != slow; ) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    private ListNode method4(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        for (; fast != null && fast.next != null; ) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                for (fast = head; fast != slow; ) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
