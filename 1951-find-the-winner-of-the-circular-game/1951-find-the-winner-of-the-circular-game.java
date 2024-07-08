class Solution {
    class ListNode{
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int findTheWinner(int n, int k) {
        ListNode prev = null, head = null;
        for(int i = 1; i <= n; i++) {
            ListNode curr = new ListNode(i);
            if(i != 1) {
                prev.next = curr;
                prev = prev.next;
            } else {
                prev = curr;
                head = curr;
            }
        }
        prev.next = head;
        int i = 0;
        while(n > 1) {
            i++;
            if(i == k) {
                i = 0;
                n--;
                prev.next = prev.next.next;
                head = prev.next;
            } else {
                prev = head;
                head = head.next;
            }
        }
        return head.val;
    }
}