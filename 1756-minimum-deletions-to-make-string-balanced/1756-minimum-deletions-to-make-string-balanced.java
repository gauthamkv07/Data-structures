class Solution {
    public int minimumDeletions(String s) {
        int n = s.length(), countb = 0;
        int[] dp = new int[n+1];

        for(int i = 0; i < n; i++) {
            int cur = s.charAt(i) - 'a';
            if(cur == 0) dp[i+1] = Math.max(dp[i], (i+1-countb));
            else {
                dp[i+1] += dp[i] + 1;
                countb++;
            }
        }

        return n-dp[n];
    }
}