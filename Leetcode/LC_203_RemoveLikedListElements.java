//203. Remove Linked List Elements
//Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//Return: 1 --> 2 --> 3 --> 4 --> 5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr = dummy;
        while (ptr.next != null) {
            if (ptr.next.val == val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }
        return dummy.next;
    }
}