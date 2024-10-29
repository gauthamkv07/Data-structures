class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        int ans = 0;

        for(int j = 1; j < n; j++) {
            for(int i = 0; i < m; i++) {
                for(int k = -1; k <=1; k++) {
                    if(i + k >= 0 && i + k < m && grid[i+k][j-1] < grid[i][j]) {
                        if(j == 1) dp[i][j] = 1;
                        else if(dp[i+k][j-1] > 0) dp[i][j] = Math.max(dp[i][j], dp[i+k][j-1]+1);
                        ans = Math.max(dp[i][j], ans);
                    }
                }
            }
        }

        return ans;
    }
}