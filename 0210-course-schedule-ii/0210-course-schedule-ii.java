class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] indegree = new int[n];

        List<Integer>[] graph = new List[n];

        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int[] node: prerequisites) {
            int edge1 = node[0], edge2 = node[1];

            graph[edge2].add(edge1);
            indegree[edge1]++;
        }

        List<Integer> bfs = new ArrayList<>();

        for(int i = 0; i < n; i++) if(indegree[i]  == 0) bfs.add(i);

        for(int i = 0; i < bfs.size(); i++) for(int vertex: graph[bfs.get(i)]) if(--indegree[vertex] == 0) bfs.add(vertex);

        if(bfs.size() < n) return new int[0];

        int[] res = new int[n];

        for(int i = 0; i < n; i++) res[i] = bfs.get(i);

        return res;
    }
}