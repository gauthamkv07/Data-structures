class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];

        for(int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        long n = original.length, res = 0;

        for(int i = 0; i < n; i++) {
            int src = original[i] - 'a';
            int des = changed[i] - 'a';
            dist[src][des] = Math.min(dist[src][des], ((long)cost[i]));
        }

        for(int k = 0; k < 26; k++){
            for(int i = 0; i < 26; i++) {
                for(int j = 0; j < 26; j++) {
                    dist[i][j] = Math.min(dist[i][j], (dist[i][k] + dist[k][j]));
                }
            }
        }

        n = source.length();
        
        for(int i = 0; i < n; i++) {
            int src = source.charAt(i) - 'a';
            int des = target.charAt(i) - 'a';
            if(dist[src][des] == Integer.MAX_VALUE) return -1;
            res += dist[src][des];
        }

        return res;
    }
}