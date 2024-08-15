class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0, n = nums.length, flip = 0, currLen = 0;

        for(int i = 0, j = 0; i < n; i++) {
            if(nums[i] == 1) {
                currLen++;
                res = Math.max(res, currLen);
                continue;
            }
            flip++;
            currLen++;
            while(flip > k) {
                if(j < n && nums[j++] == 0) flip--;
                currLen--;
            }
            res = Math.max(res, currLen);
        }

        return res;
    }
}