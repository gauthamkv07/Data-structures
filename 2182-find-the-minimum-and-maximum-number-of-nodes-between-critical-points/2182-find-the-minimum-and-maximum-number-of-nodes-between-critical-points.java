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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int index = 1, pi = 0, first = 0, curr = 0, min = (int) 1e6;
        ListNode prev = head;
        head = head.next;
        int count = 0;
        while(head.next != null) {
            index++;
            if((head.val > prev.val && head.val > head.next.val)||(head.val < prev.val && head.val < head.next.val)) {
                count++;
                if(first == 0) {
                    first = index;
                    curr = index;
                } else {
                    pi = curr;
                    curr = index;
                    min = Math.min(min, curr - pi);
                }
            }
            prev = head;
            head = head.next;
        }
        if(count < 2) return new int[]{-1,-1};
        return new int[]{min, curr - first};
    }
}