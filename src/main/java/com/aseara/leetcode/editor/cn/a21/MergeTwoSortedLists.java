//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表
package com.aseara.leetcode.editor.cn.a21;

import com.aseara.leetcode.editor.cn.base.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.aseara.leetcode.editor.cn.base.ListNode.toArr;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 21.合并两个有序链表 <br />
 * Date: 2019/11/10 <br/>
 *
 * @author qiujingde
 */
class MergeTwoSortedLists {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        ListNode l1 = ListNode.fromArr(1, 2, 4);
        ListNode l2 = ListNode.fromArr(1, 3, 4);

        assertIterableEquals(Arrays.asList(1, 1, 2, 3, 4, 4),
                toArr(solution.mergeTwoLists(l1, l2)));
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
