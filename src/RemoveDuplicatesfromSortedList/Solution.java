package RemoveDuplicatesfromSortedList;

public class Solution {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
			}
		}
	

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode tmp = head;
		while(tmp != null){
			while(tmp.next != null && tmp.val == tmp.next.val){
				tmp.next = tmp.next.next;
			}
			tmp = tmp.next;
		}
		return head;    
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode a = s.new ListNode(1);
		ListNode b = s.new ListNode(1);
		ListNode c = s.new ListNode(2);
		ListNode d = s.new ListNode(3);
		ListNode e = s.new ListNode(3);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		ListNode tmp = deleteDuplicates(a);
		while(tmp != null){
			System.out.println(tmp.val);
			tmp = tmp.next;
		}

	}

}
