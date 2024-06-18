class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int m = worker.length, n = difficulty.length;
        int[][] comb = new int[n][2];
        for(int i = 0; i < n; i++) {
            comb[i][0] = difficulty[i];
            comb[i][1] = profit[i];
        }
        Arrays.sort(comb, (a,b) -> Integer.compare(a[0],b[0]));
        int res = 0, max = 0;
        for(int i = 0, j = 0; i < m; i++) {
            while(j < n && comb[j][0] <= worker[i]) {
                max = Math.max(comb[j][1], max);
                j++;
            }
            res += max;
        }
        return res;
    }
}