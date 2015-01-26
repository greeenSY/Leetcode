package SortList;

public class Solution {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
			}
	}
	private static ListNode mergeList(ListNode list1, ListNode list2) {
		Solution s = new Solution();
		ListNode dummyHead = s.new ListNode(-1);  
        ListNode curr = dummyHead;  
        while(list1!=null && list2!=null) {  
            if(list1.val <= list2.val) {  
                curr.next = list1 ; 
                list1 = list1.next;  
            } else {  
                curr.next=list2;
                list2 = list2.next;  
            }  
            curr  = curr.next;  
        }  
        curr.next = list1 != null ? list1 : list2;  
        return dummyHead.next;  
	}
	private static ListNode getMiddleNode(ListNode head) {
		ListNode mid = head;
		ListNode end = head;
		while(end.next != null && end.next.next != null){
			mid = mid.next;
			end = end.next.next;
		}
		return mid;
	}
	
	public static ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode mid = getMiddleNode(head);
		ListNode rightHead = mid.next;
		mid.next = null;
		return mergeList(sortList(head),sortList(rightHead));
        
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode a = s.new ListNode(1);
		ListNode b = s.new ListNode(2);
		ListNode c = s.new ListNode(3);
		b.next = a;
		a.next = c;
		
		ListNode t = sortList(b);;
		while(t != null){
			System.out.println(t.val);
			t = t.next;
		}


	}

}
