//61. Rotate List
//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        ListNode ptr = head;
        int len = 1;
        while (ptr.next != null) {
            len++;
            ptr = ptr.next;
        }
        k %= len;
        ptr.next = head;
        
        ptr = head;
        for (int i = 0; i < len - k - 1; i++) {
            ptr = ptr.next;
        }
        head = ptr.next;
        ptr.next = null;
        return head;
    }
}