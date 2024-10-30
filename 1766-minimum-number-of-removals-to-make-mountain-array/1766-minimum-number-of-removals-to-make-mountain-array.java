class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n], lis = new int[n];

        Arrays.fill(lis, (int) 1e9);

        for(int i = 0; i < n; i++) {
            int j = binarySearch(lis, nums[i]);
            lis[j] = nums[i];
            dp[i] = (j > 0)? j + 1: -n;
        }

        Arrays.fill(lis, (int) 1e9);

        for(int i = n-1; i >= 0; i--) {
            int j = binarySearch(lis, nums[i]);
            lis[j] = nums[i];
            dp[i] += (j > 0)? j: -n;
        }

        int maxDp = Integer.MIN_VALUE;

        for(int i = 1; i < n - 1; i++) maxDp = Math.max(maxDp, dp[i]);

        return n - maxDp;
    }

    // Helper function to find the first position in mono where A[i] can be placed
    private int binarySearch(int[] mono, int target) {
        int left = 0, right = mono.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mono[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}