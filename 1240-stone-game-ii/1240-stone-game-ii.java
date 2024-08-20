class Solution {
    int[][] memo;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        memo = new int[n][n];

        int[] suffixSum = Arrays.copyOf(piles, n);

        for(int i = n-2; i >= 0; i--) suffixSum[i] += suffixSum[i+1];

        return getMax(suffixSum, 1, 0);
    }

    private int getMax(int[] suffixSum, int maxTillNow, int curr) {
        if(curr + 2 * maxTillNow >= n) return suffixSum[curr];

        if(memo[curr][maxTillNow] != 0) return memo[curr][maxTillNow];

        int res = Integer.MAX_VALUE;

        for(int i = 1; i <= 2 * maxTillNow; i++) res = Math.min(res, getMax(suffixSum, Math.max(i, maxTillNow), curr + i));

        memo[curr][maxTillNow] = suffixSum[curr] - res;

        return memo[curr][maxTillNow];
    }
}