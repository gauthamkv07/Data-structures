class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int res = 1;

        for(char c: s.toCharArray()) {
            int curr = c - 'a';
            for(int i = Math.max(0, curr - k); i <= Math.min(25,curr+k); i++) dp[curr] = Math.max(dp[curr], dp[i]);
            res = Math.max(++dp[curr], res);
        }

        return res;
    }
}