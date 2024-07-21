class Solution {
    public int[] bfs(int k, int[][] conditions) {
        Set<int[]> set = new HashSet<>(Arrays.asList(conditions));
        List<Integer> bfs = new ArrayList<>();
        List<Integer>[] graph = new List[k+1];
        int[] indegree = new int[k+1];
        for (int i = 0; i <= k; i++) graph[i] = new ArrayList<>();

        for(int[] curr: set) {
            int before = curr[0];
            int after = curr[1];
            graph[before].add(after);
            indegree[after]++;
        }

        for(int i = 1; i <= k; i++) if(indegree[i] == 0) bfs.add(i);

        for(int i = 0; i < bfs.size(); i++) {
            int curr = bfs.get(i);
            for(int child: graph[curr]) if(--indegree[child] == 0) bfs.add(child);
        }

        int n = bfs.size();
        if(n < k) return new int[0];
        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++) arr[bfs.get(i-1)] = i;
        return arr;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] row = bfs(k, rowConditions);
        int[] col = bfs(k, colConditions);
        if(row.length == 0 || col.length == 0) return new int[0][0];

        int[][] matrix = new int[k][k];

        for(int i = 1; i <= k;i++) matrix[row[i] - 1][col[i] - 1] = i;

        return matrix;
    }
}