class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int res = (1 << n-1) * m;

        for(int j = 1; j < n; j++) {
            int curr = 0;
            for(int i = 0; i < m; i++) curr += grid[i][0] == grid[i][j]? 1 : 0;
            res += Math.max(curr, m - curr) * (1 << n-1-j);
        }
        return res;
    }
}