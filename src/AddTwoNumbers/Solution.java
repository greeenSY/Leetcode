package AddTwoNumbers;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class Solution {

	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode res = new ListNode(-1),p = null,p1=l1,p2=l2;
		 p = res;
		 int sum = 0;
		 boolean add = false;
		 while(p1 != null || p2 != null || sum != 0){
			 if(p1 != null)
				 sum += p1.val;
			 if(p2 != null)
				 sum += p2.val;
			 p.next = new ListNode(sum % 10);
			 if(sum >= 10){
				 sum = 1;
			 }else{
				 sum = 0;
			 }
			
			 p = p.next;
			 if(p1 != null)
				 p1 = p1.next;
			 if(p2 != null)
				 p2 = p2.next;
		 }
	     
		 return res.next;
	 }
	public static void main(String[] args) {
		ListNode p1 = new ListNode(5);
		//p1.next = new ListNode(4);
		//p1.next.next = new ListNode(3);

		ListNode p2 = new ListNode(5);
		//p2.next = new ListNode(6);
		//p2.next.next = new ListNode(4);
		
		Solution s = new Solution();
		ListNode res = s.addTwoNumbers(p1, p2);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
		return;
	}

}
