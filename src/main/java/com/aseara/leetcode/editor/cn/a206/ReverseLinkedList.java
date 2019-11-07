//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表
package com.aseara.leetcode.editor.cn.a206;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 206.反转链表 <br />
 * Date: 2019/11/7 <br/>
 *
 * @author qiujingde
 */
class ReverseLinkedList {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        ListNode head = fromArr(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> expected = Arrays.asList(5, 4, 3, 2, 1);
        head = solution.reverseList(head);
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
    public ListNode reverseList(ListNode head) {
        return recursive(head);
    }

    private ListNode loop(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private ListNode recursive(ListNode head) {
        return recursive(null, head);
    }

    private ListNode recursive(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return recursive(cur, next);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
