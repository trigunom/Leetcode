/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
      ListNode dummy = new ListNode(0);
        ListNode resultTail = dummy;
        
        ListNode start = head.next;
        ListNode current = start;
        int sum = 0;
        
        while (current != null) {
            if (current.val != 0) {
                sum += current.val;
            } else {
                
                ListNode newNode = new ListNode(sum);
                resultTail.next = newNode;
                resultTail = newNode;
                
            
                sum = 0;
                start = current.next;
            }
            current = current.next;
        }
        
        return dummy.next;  
    }
}