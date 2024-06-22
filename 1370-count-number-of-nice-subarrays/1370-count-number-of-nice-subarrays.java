class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int iniGap = 0, cur = 0,res = 0, n = nums.length;
        for(int i = 0, j = 0; i < n; i++) {
            if(nums[i] % 2 == 1) cur++;
            if(cur == k) {
                iniGap = 0;
                while(cur == k) {
                    iniGap++;
                    if(nums[j++] % 2 == 1) cur--;
                }
            }
            res += iniGap;
        }
        return res;
    }
}