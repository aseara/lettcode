//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学
package com.aseara.leetcode.editor.cn.a2;

import com.aseara.leetcode.editor.cn.base.ListNode;
import org.junit.jupiter.api.Test;

/**
 * desc: 2.两数相加 <br />
 * Date: 2019/10/20 <br/>
 *
 * @author qiujingde
 */
class AddTwoNumbers {
    private Solution solution = new Solution();
    
    @Test
    void test1() {

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return upAdd(l1, l2, 0);
    }

    private ListNode upAdd(ListNode l1, ListNode l2, int up) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int val = l1.val + l2.val;
        up = val > 10 ? 1 : 0;
        val = val > 10 ? val - 10 : val;

        ListNode node = new ListNode(val);
        node.next = upAdd(l1.next, l2.next, up);

        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
