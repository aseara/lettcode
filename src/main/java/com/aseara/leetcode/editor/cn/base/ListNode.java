package com.aseara.leetcode.editor.cn.base;

import java.util.ArrayList;
import java.util.List;

/**
 * desc: <br />
 * Date: 2019/11/10 <br/>
 *
 * @author qiujingde
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode fromArr(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode next = null;
        ListNode head = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            head = new ListNode(nums[i]);
            head.next = next;
            next = head;
        }
        return head;
    }

    public static ListNode fromArr(List<Integer> arr) {
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

    public static List<Integer> toArr(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        for (ListNode next = head; next != null; next = next.next) {
            arr.add(next.val);
        }
        return arr;
    }

}
