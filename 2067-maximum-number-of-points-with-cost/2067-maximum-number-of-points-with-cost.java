class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        
        long[] prev = new long[n];

        for(int[] row: points) {
            long[] curr = new long[n];
            long max = 0;

            for(int j = 0; j < n; j++) {
                max = Math.max(max - 1, prev[j]);
                curr[j] = max;
            }

            max = 0;
            for(int j = n-1; j >= 0; j--) {
                max = Math.max(max - 1, prev[j]);
                curr[j] = Math.max(curr[j], max) + row[j];
            }

            prev = curr;
        }

        long max = 0;
        
        for(long val: prev) max = Math.max(max, val);

        return max;
    }
}