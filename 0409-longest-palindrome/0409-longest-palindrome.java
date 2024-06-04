class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[200];
        for(char c: s.toCharArray()) cnt[c-'A']++;
        int ans = 0;
        for(int i = 0; i < 200; i++) ans += ((cnt[i]/2) * 2);
        return s.length() - ans > 0? ans + 1: ans;
    }
}