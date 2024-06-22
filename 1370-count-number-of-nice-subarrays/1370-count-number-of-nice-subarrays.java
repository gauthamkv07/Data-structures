class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        
        int lastPop = -1, n = nums.length, res = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] % 2 == 1) q.offer(i);
            if(q.size() > k) lastPop = q.poll();
            if(q.size() < k) continue;
            res += q.element() - lastPop;
        }
        return res;
    }
}