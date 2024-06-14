class Solution {
    public int minIncrementForUnique(int[] nums) {
        int[] cnt = new int[1000001];
        Arrays.fill(cnt, -1);
        for(int num: nums) cnt[num]++;
        int ans = 0, curr = 0;
        for(int i = 0; i <= 1000000;i++) {
            if(cnt[i] >= 0 || curr > 0) curr += cnt[i];
            ans += curr;
        }
        return ans;
    }
}