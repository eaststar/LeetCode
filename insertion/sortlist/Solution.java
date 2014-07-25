package insertion.sortlist;

//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class Solution {
	public static ListNode insertionSortList(ListNode head) {
    	ListNode list = new ListNode(head.val);
    	ListNode op = head;
    	ListNode listop = list;
    	while(op.next != null){
    		while(listop.next != null && listop.next.val > op.val){
    			ListNode listopnext = listop.next;
    			listop.next = op;
    			op.next = listopnext;
    		}
    		listop = list;
    		op = op.next;
    	}
		return list;
    }

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
 
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
 
		n1 = insertionSortList(n1);
 
		printList(n1);
 
	}
 
	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}
}