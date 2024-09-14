class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, n = nums.length, res = 1, count = 0;

        for(int num: nums) max = Math.max(num, max);

        for(int num: nums) {
            if(num == max) {
                count++;
                res = Math.max(res, count);
            } else count = 0;
        }

        return res;
    }
}