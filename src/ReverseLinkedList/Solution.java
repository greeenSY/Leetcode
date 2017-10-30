/**
 * @(#)Solution.java, 六月 29, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ReverseLinkedList;

/**
 * @author shenyang
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode now,next,tmp;
        now = head;
        tmp = null;
        while (now != null){
            next = now.next;
            now.next = tmp;
            tmp = now;
            now = next;
        }
        return tmp;
    }
}