class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int l = 0, r = nums[n-1] - nums[0];

        while(l < r) {
            int mid = l + (r-l)/2;

            int count = calcPairsWithMaxDistance(nums, n, mid);

            if(count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public int calcPairsWithMaxDistance(int[] nums, int n, int maxDistance) {
        int left = 0, count = 0;

        for(int right = 1; right < n; right++) {
            while(nums[right] - nums[left] > maxDistance) left++;
            count += right - left;
        }

        return count;
    }
}