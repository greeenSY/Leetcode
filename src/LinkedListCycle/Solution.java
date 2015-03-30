package LinkedListCycle;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {

	public static boolean hasCycle(ListNode head) {
		if(head == null)
			return false;
		ListNode t = head,tmp=null;
		
		while(t != null){
			if(t.next == head){
				return true;
			}
			tmp = t.next;
			t.next = head;
			t = tmp;
		}
		return false;
        
    }
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = b;
		System.out.println(hasCycle(a));
	}

}
