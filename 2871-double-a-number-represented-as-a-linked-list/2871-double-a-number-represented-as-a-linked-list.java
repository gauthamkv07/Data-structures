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
    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;
        while(curr != null) {
            int val = curr.val + curr.val;
            if(val < 10) {
                curr.val = val;
                stack.push(curr);
                curr = curr.next;
                continue;
            }
            if(stack.isEmpty()) {
                ListNode newNode = new ListNode(1);
                stack.push(newNode);
                curr.val = val % 10;
                stack.push(curr);
                curr = curr.next;
                continue;
            }
            ListNode temp = stack.pop();
            temp.val = temp.val+1;
            stack.push(temp);
            curr.val = val % 10;
            stack.push(curr);
            curr = curr.next;
        }
        curr = stack.pop();
        ListNode prev= curr;
        while(!stack.isEmpty()) {
            prev = stack.pop();
            prev.next = curr;
            curr = prev;
        }
        head = prev;
        return head;
    }
}