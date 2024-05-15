class Solution {
    int[] cnt;

    public long subArraysWithKDistinctElem(int[] nums, int k) {
        int j = 0, n = nums.length;
        long sum = 0;
        for(int i = 0; i < n; i++) {
            k-= ++cnt[nums[i]] == 1? 1: 0;
            while(j < n && k < 0) k+= --cnt[nums[j++]] == 0? 1 : 0;
            sum += i - j + 1; 
        }
        while(j < n) --cnt[nums[j++]];
        return sum;
    }

    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length, l = 1, r = n;
        cnt = new int[100001];
        long tot = (long) n * (n+1)/2;
        System.out.println(tot);
        long median = (tot+1)/2;
        while(l < r) {
            int mid = l + (r-l)/2;
            if(subArraysWithKDistinctElem(nums, mid) < median) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}