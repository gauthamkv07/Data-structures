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
    public int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while(curr.next != null) {
            int val = gcd(curr.val, curr.next.val);
            ListNode temp = new ListNode(val, curr.next);
            curr.next = temp;
            curr = temp.next;
        }
        return head;
    }
}