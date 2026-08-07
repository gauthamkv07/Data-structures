class Solution {
    public int longestPath(int[] parent, String s) {
        char[] a = s.toCharArray();
        int n = parent.length, res = 1, qIdx = -1;

        int[] path = new int[n], degree = new int[n], q = new int[n];
        Arrays.fill(path, 1);

        for(int p: parent) if(p != -1) degree[p]++;

        for(int i = 1; i < n; i++) if(degree[i] == 0) q[++qIdx] = i;

        while(qIdx >= 0) {
            int c = q[qIdx--];
            int p = parent[c];

            if(--degree[p] == 0 && p != 0) q[++qIdx] = p;

            if(a[c] == a[p]) continue;

            res = Math.max(res, path[p] + path[c]);
            path[p] = Math.max(path[p], path[c] + 1);
        }

        return res;
    }
}