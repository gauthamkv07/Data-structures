class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int key = sum % k;
            if(map.containsKey(key) && i - map.get(key) > 1) return true;
            if(!map.containsKey(key)) map.put(key, i); 
        }
        return false;
    }
}