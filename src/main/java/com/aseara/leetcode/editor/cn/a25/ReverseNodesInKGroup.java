//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 示例 : 
//
// 给定这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 说明 : 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
// 
// Related Topics 链表
package com.aseara.leetcode.editor.cn.a25;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 25.K 个一组翻转链表 <br />
 * Date: 2019/11/9 <br/>
 *
 * @author qiujingde
 */
class ReverseNodesInKGroup {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        ListNode head = fromArr(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> expected = Arrays.asList(2, 1, 4, 3, 5);
        head = solution.reverseKGroup(head, 2);
        assertIterableEquals(expected, toArr(head));

        head = fromArr(Arrays.asList(1, 2, 3, 4, 5));
        expected = Arrays.asList(3, 2, 1, 4, 5);
        head = solution.reverseKGroup(head, 3);
        assertIterableEquals(expected, toArr(head));
    }

    private ListNode fromArr(List<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return null;
        }
        ListNode next = null;
        ListNode head = null;
        for (int i = arr.size() - 1; i >= 0; i--) {
            head = new ListNode(arr.get(i));
            head.next = next;
            next = head;
        }
        return head;
    }

    private List<Integer> toArr(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        for (ListNode next = head; next != null; next = next.next) {
            arr.add(next.val);
        }
        return arr;
    }
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if (k < 2) {
            return head;
        }

        ListNode tail = head;
        for (int i = 0; i < k - 1; i++) {
            tail = tail.next;
            // 不够k个，返回head
            if (tail == null) {
                return head;
            }
        }

        ListNode next = reverseKGroup(tail.next, k);
        tail.next = null;
        reverse(head);
        head.next = next;
        return tail;
    }

    private void reverse(ListNode head) {
        ListNode pre = null;
        ListNode crt = head;
        while (crt != null) {
            ListNode tmp = crt.next;
            crt.next = pre;
            pre = crt;
            crt = tmp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
