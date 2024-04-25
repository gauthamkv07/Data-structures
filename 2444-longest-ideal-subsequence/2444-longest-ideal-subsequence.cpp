class Solution {
public:
    int longestIdealString(string s, int k) {
        int dp[26] = {0}, res = 1;
        
        for(char &c: s) {
            int curr = c - 'a';
            for(int i = max(0, curr - k); i <= min(25,curr + k); i++) dp[curr] = max(dp[curr], dp[i]);
            res = max(res, ++dp[curr]);
        }

        return res;
    }
};