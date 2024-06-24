class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int currFlips = 0, totalFlips = 0, n = nums.length;

        for(int i = 0; i < n; i++) {
            if(i-k >= 0 && nums[i-k] == 2) currFlips--;

            if(currFlips % 2 == nums[i]) {
                if(i+k > n) return -1;
                nums[i] = 2;
                currFlips++;
                totalFlips++;
            }
        }
        return totalFlips;
    }
}