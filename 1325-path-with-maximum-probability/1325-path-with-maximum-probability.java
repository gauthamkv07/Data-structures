class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] dist = new double[n+1];
        int m = edges.length;

        dist[start_node] = 1;

        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[1], a[1]));

        List<double[]>[] graph = new List[n];

        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            int[] edge = edges[i];
            double prob = succProb[i];

            graph[edge[0]].add(new double[]{edge[1], prob});
            graph[edge[1]].add(new double[]{edge[0], prob});
        }

        pq.offer(new double[]{(double) start_node, 1.0});

        while(!pq.isEmpty()) {
            double[] curr = pq.poll();
            int edge = (int) curr[0];
            double prob = curr[1];

            if(edge == end_node) return dist[end_node];

            for(double[] g: graph[edge]) {
                int end = (int) g[0];
                double np = g[1];

                if(dist[end] < prob * np) {
                    dist[end] = prob * np;
                    pq.offer(new double[]{(double) end, dist[end]});
                }
            }
        }

        return dist[end_node];
    }
}