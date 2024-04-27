class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int key, n = nums.length;
        for(int i = 0; i < n; i++) {
            key = target - nums[i];
            if(map.containsKey(key)) return new int[] {map.get(key), i};
            map.put(nums[i], i);
        }

        return new int[2];
    }
}