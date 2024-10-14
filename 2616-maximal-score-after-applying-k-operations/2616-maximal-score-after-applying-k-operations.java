class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long res = 0;

        for(int num: nums) pq.offer(num);

        while(k-- > 0) {
            int val = pq.poll();
            res += (long) val;
            pq.offer((val + 2)/3);
        }

        return res;
    }
}