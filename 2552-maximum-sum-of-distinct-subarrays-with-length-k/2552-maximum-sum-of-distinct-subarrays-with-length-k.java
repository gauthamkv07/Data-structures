class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(i >= k) {
                sum -= nums[i-k];
                map.put(nums[i-k], map.getOrDefault(nums[i-k], 0) - 1);
                if(map.get(nums[i-k]) == 0) map.remove(nums[i-k]);
            }
            
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
            if(map.size() == k) ans = Math.max(ans,sum); 
        }
        
        return ans;
    }
}