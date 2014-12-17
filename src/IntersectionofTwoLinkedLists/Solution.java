package IntersectionofTwoLinkedLists;

import java.io.IOException;

/**
 * Definition for singly-linked list.
 */

public class Solution {
	

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA == null || headB == null)
    		return null;
    	int lenA = 0, lenB = 0;
    	ListNode tail,tailA=headA,tailB = headB,Intersection=null;
    	tail = headA;
    	while(tail != null){
    		lenA++;
    		tail = tail.next;
    	}
    	tail = headB;
    	while(tail != null){
    		lenB++;
    		tail = tail.next;
    	}
    	if(lenA<lenB){
    		int tmp = lenB;
    		lenB = lenA;
    		lenA = tmp;
    		tail = tailA;
    		tailA = tailB;
    		tailB = tail;
    	} 
    		
    	for(int i = 0;i<lenA-lenB;i++){
			tailA = tailA.next;
		}
		while(tailB !=null){
			if(tailB == tailA){
				Intersection = tailB;
				break;
			}
			tailA = tailA.next;
			tailB = tailB.next;
		}
    	
		return Intersection;
        
    }
    
    public static void main(String[] args) throws IOException
	{
    	ListNode a = new ListNode(1);
    	ListNode tail = a;
    	for(int i = 2; i <= 5; i++){
    		tail.next = new ListNode(i);
    		tail = tail.next;
    	}
    	ListNode b = new ListNode(6);
    	b.next = a.next.next;
    	//ListNode a = new ListNode(1)
    	System.out.print("\na\n");
    	tail = a;
    	while(tail!=null){
    		System.out.print(tail.val);
    		tail = tail.next;
    	}
    	System.out.print("\nb\n");
    	tail = b;
    	while(tail!=null){
    		System.out.print(tail.val);
    		tail = tail.next;
    	}
    	System.out.print("\nover\n");
    	System.out.print(getIntersectionNode(b,a).val);
    	return;
	}
}
