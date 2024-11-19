class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, res = n+1;
        long[] sum = new long[n+1];

        for(int i = 0; i < n; i++) sum[i+1] = sum[i] + (long) nums[i];

        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i <= n; i++) {
            while(!deque.isEmpty() && sum[deque.peekLast()] >= sum[i]) deque.pollLast();
            while(!deque.isEmpty() && sum[i] - sum[deque.peekFirst()] >= k) res = Math.min(res, i - deque.pollFirst());
            deque.offerLast(i);
        }

        return res == n + 1? -1 : res;
    }
}