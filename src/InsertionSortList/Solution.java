/**
 * @(#)Solution.java, 六月 29, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package InsertionSortList;

/**
 * @author shenyang
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode result = null;
        ListNode now = head;

        while (now != null) {
            ListNode tmp = now.next;
            result = insert(result, now);
            now = tmp;
        }

        return result;
    }

    public ListNode insert(ListNode sorted, ListNode notSorted) {
        ListNode now = new ListNode(-1);
        now.next = sorted;
        while (now.next != null) {
            if (now.next.val < notSorted.val) {
                now = now.next;
            } else {
                break;
            }
        }
        ListNode tmp = now.next;
        now.next = notSorted;
        notSorted.next = tmp;

        if (notSorted.next == sorted) {
            sorted = notSorted;
        }
        return sorted;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(2);
        head.next = head2;
        head2.next = head3;

        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }

        head = s.insertionSortList(head);

        tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
}