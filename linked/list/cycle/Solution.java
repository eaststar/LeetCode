package linked.list.cycle;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	   val = x;
	   next = null;
	}
}

	public class Solution {
	    public ListNode detectCycle(ListNode head) {
	        ListNode pre = head;
	        ListNode fow = head;
	        while(fow.next!=null){
	            pre = pre.next.next;
	            fow = fow.next;
	            if(pre == fow){
	                fow = head;
	                while(fow!=pre){
	                	fow = fow.next;
	                	pre = pre.next;
	                }
	                return fow;
	            }
	        }
	        return null;
	    }
	}