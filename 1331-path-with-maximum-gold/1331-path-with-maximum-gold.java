class Solution {
    int res, m , n;

    public int getMaximumGold(int[][] grid) {
        res = 0;
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++) for(int j = 0; j < n; j++) if(grid[i][j] != 0) bt(grid, i, j, 0);
        return res;
    }

    public void bt(int[][] grid, int i, int j, int curr) {
        curr+= grid[i][j];
        res = Math.max(curr, res);
        int val = grid[i][j];
        grid[i][j] = 0;
        if(i-1 >= 0 && grid[i-1][j] != 0) bt(grid, i-1, j, curr);
        if(i+1 < m && grid[i+1][j] != 0) bt(grid, i+1, j, curr);
        if(j-1 >= 0 && grid[i][j-1] != 0) bt(grid, i, j-1, curr);
        if(j+1 < n && grid[i][j+1] != 0) bt(grid, i, j+1, curr);
        grid[i][j] = val;
    }
}