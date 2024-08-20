class Solution {
    int[] cnt;

    private long subArraysWithAtMostKUniqueElements(int[] nums, int k) {
        long sum = 0;
        int j = 0, n = nums.length;

        for(int i = 0; i < n; i++) {
            k -= ++cnt[nums[i]] == 1? 1 : 0;
            while(j < n && k < 0) k += --cnt[nums[j++]] == 0? 1 : 0;
            sum += i - j + 1;
        }

        while(j < n) --cnt[nums[j++]];
        
        return sum;
    }

    public int medianOfUniquenessArray(int[] nums) {
        cnt = new int[100001];

        int n = nums.length, l = 1, r = n;

        long total = ((long)n * (n+1))/2;

        long median = (total + 1)/2;

        while(l < r) {
            int mid = l + (r-l)/2;
            if(subArraysWithAtMostKUniqueElements(nums, mid) < median) l = mid + 1;
            else r = mid;
        }

        return l;
    }
}