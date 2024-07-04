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
        ListNode curr = head.next, temp = head;
        while(curr != null) {
            if(curr.next == null) {
                temp.next = null;
                break;
            }
            if(curr.val == 0) {
                temp.next = curr;
                temp = temp.next;
                curr = curr.next;
                continue;
            }
            temp.val += curr.val;
            curr = curr.next;
        }
        return head;
    }
}