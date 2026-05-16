class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1, last = nums[n-1];

        while(l < r && nums[l] == last) l++;

        while(l < r) {
            int mid = l + (r-l)/2;

            if(nums[mid] > last) l = mid + 1;
            else r = mid;
        }

        return nums[l];
    }
}