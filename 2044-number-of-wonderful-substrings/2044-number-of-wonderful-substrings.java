class Solution {
    public long wonderfulSubstrings(String word) {
        long[] map = new long[1024];
        map[0] = 1;
        long ans = 0;

        int mask = 0;
        for(char c: word.toCharArray()) {
            int val = c - 'a';
            mask ^= 1 << val;
            ans += map[mask];
            for(int i = 0; i < 10; i++) {
                int newMask = mask ^ 1 << i;
                ans += map[newMask];
            }
            map[mask]++;
        }
        return ans;
    }
}