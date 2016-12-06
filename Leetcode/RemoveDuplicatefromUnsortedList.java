//removeDuplicate from unsorted ListNode
public class removeDuplicate {

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
 
		n1 = SortList(n1);
		n1 = deleteDuplicates(n1);
		printList(n1);
 

	}
		private static ListNode deleteDuplicates(ListNode head) {
		       if (head == null || head.next == null) return head;
		       ListNode dummy = new ListNode(-1);
		       dummy.next = head;
		       ListNode fast = head;
		       ListNode slow = dummy;
	       while (fast != null) {
	           boolean isDup = false;
	           while (fast.next != null && fast.val == fast.next.val) {
	               fast = fast.next;
	               isDup = true;
	           }
	           if (isDup) {
	               slow.next = fast.next;
	               fast = fast.next;
	           } else {
	               fast = fast.next;
	               slow = slow.next;
	           }
	       }
	        return dummy.next;
	    }
	
	private static ListNode SortList(ListNode head) {
	        ListNode dummy = new ListNode(0);

	        while (head != null) {
	            ListNode node = dummy;
	            while (node.next != null && node.next.val < head.val) {
	                node = node.next;
	            }
		            ListNode temp = head.next;
		            head.next = node.next;
		            node.next = head;
		            head = temp;
		        }
	
		        return dummy.next;
			}
	private static void printList(ListNode x) {
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
	 
	 
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

//2 5 