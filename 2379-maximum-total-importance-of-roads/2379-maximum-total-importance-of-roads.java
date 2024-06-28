class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] cnt = new int[n];

        for(int[] r: roads) {
            cnt[r[0]]++;
            cnt[r[1]]++;
        }

        int[] bucket = new int[n+1];
        
        for(int c: cnt) {
            if(c == 0) continue;
            bucket[c]++;
        }

        long res = 0;
        for(int i = n, j = n; i >= 0 && j > 0; i--) while(bucket[i]-- > 0) res += (long) j-- * (long) i;
        return res;
    }
}