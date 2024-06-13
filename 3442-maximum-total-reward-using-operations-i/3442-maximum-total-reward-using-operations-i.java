class Solution {
    int[] memo;
    int n;

    public int recur(int[] arr, int i, int sum) {
        if(i == n) return sum;
        if(memo[sum] != 0) return memo[sum];

        int inc = 0;
        if(arr[i] > sum) inc = recur(arr, i+1, arr[i] + sum);
        int exc = recur(arr, i+1, sum);

        return memo[sum] = Math.max(inc,exc);
    }

    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        memo = new int[4001];
        n = rewardValues.length;
        return recur(rewardValues, 0, 0);
    }
}