class Solution {
    public int minSwaps(int[] nums) {
        int countone = 0, n = nums.length, res = nums.length;
        for(int num: nums) if(num == 1) countone++;
        if(countone == 0) return 0;

        int[] arr = new int[2*n];

        for(int i = 0; i < n; i++) arr[i] = nums[i];
        for(int i = n; i < 2 * n; i++) arr[i] = nums[i-n];

        int curr = 0;
        for(int i = 0; i < countone; i++) if(arr[i] == 1) curr++;
        res = Math.min(res, countone - curr);

        for(int i = countone; i < 2*n; i++) {
            curr -= arr[i-countone] == 1? 1 : 0;
            curr += arr[i] == 1?1:0;
            res = Math.min(res, countone - curr);
        }

        return res;
    }
}