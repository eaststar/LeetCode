package reorder.list;
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

	/**
	 * @param args
	 */
	public void reorderList(ListNode head) {
	    // IMPORTANT: Please reset any member data you declared, as
	    // the same Solution instance will be reused for each test case.
	    if (head == null || head.next == null) return;
	    ListNode fast = head;
	    ListNode slow = head;
	    while(fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    ListNode reverseHead = slow.next;           // find the second half of list
	    slow.next = null;                           // make first half end point to null
	    reverseHead = reverse(reverseHead);         // reverse second half     
	    ListNode cur = head;        
	    while(reverseHead != null) {                // link together
	        ListNode tmp = reverseHead.next;
	        reverseHead.next = cur.next;
	        cur.next = reverseHead;
	        cur = cur.next.next;
	        reverseHead = tmp;
	    }
	}
	private ListNode reverse(ListNode head) {
	    if (head == null || head.next == null) return head;
	    ListNode prev = new ListNode(0);
	    prev.next = head;
	    head = prev;
	    ListNode cur = prev.next;
	    while(cur.next != null) {
	        ListNode tmp = cur.next;
	        cur.next = tmp.next;
	        tmp.next = prev.next;
	        prev.next = tmp;
	    }
	    return prev.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
