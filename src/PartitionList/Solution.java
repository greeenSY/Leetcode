package PartitionList;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	 	next = null;
	}
}
public class Solution {

	public static ListNode partition(ListNode head, int x) {
		if(head == null)
			return head;
		ListNode lessNodes = new ListNode(0),lessTmp=null;
		ListNode tmp=null,bfg=null,pre = new ListNode(-1);
		pre.next = head;
		tmp = pre;
		while(tmp.next != null){
			if(tmp.next.val >= x){
				bfg = tmp;
				break;
			}
			tmp = tmp.next;
		}
		if(bfg ==null)
			return head;
		tmp = bfg;
		lessTmp = lessNodes;
		while(tmp.next != null){
			if(tmp.next.val < x){
				lessTmp.next = tmp.next;
				tmp.next = tmp.next.next;
				lessTmp = lessTmp.next;
				lessTmp.next = null;
			}else
				tmp = tmp.next;
		}
		if(lessNodes.next != null){
			
			lessTmp.next = bfg.next;
			bfg.next = lessNodes.next;
		}
		return pre.next;
        
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(6);
		ListNode tmp;
		tmp = head;
		tmp.next = new ListNode(4);tmp = tmp.next;
		tmp.next = new ListNode(3);tmp = tmp.next;
		tmp.next = new ListNode(2);tmp = tmp.next;
		tmp.next = new ListNode(5);tmp = tmp.next;
		tmp.next = new ListNode(2);
		tmp = head;
		while(tmp != null){
			System.out.print(tmp.val);
			System.out.print("->");
			tmp = tmp.next;
		}
		System.out.println("");
		tmp = partition(head,3);
		while(tmp != null){
			System.out.print(tmp.val);
			System.out.print("->");
			tmp = tmp.next;
		}

	}

}
