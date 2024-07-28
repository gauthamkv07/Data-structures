class Solution {
    Map<Integer, List<Integer>> adjacency;
    PriorityQueue<int[]> pq;
    int[] dist1,dist2,freq;

    public int calcTimeTaken(int time, int change, int timeTaken) {
        if((timeTaken/change) % 2 == 1) return change * (timeTaken/change + 1) + time;
        return timeTaken + time;
    }

    public void populateAdjacenylist(int[][] edges) {
        adjacency = new HashMap<>();

        for(int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            adjacency.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adjacency.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }
    }

    public void initializePriorityQueue() {
        pq = new PriorityQueue<>((a,b)-> Integer.compare(a[1], b[1]));
    }

    public void initializeDistance(int n) {
        dist1 = new int[n+1];
        dist2 = new int[n+1];
        freq = new int[n+1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        Arrays.fill(freq, 0);
    }

    public int modifiedDijkstra(int n, int[][] edges, int time, int change) {
        pq.offer(new int[]{1,0});
        dist1[1] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], timeTaken = curr[1];

            freq[node]++;

            if(node == n && freq[node] == 2) return timeTaken;

            timeTaken = calcTimeTaken(time, change, timeTaken);

            for(int adj: adjacency.get(node)) {
                if(freq[adj] == 2) continue;

                if(dist1[adj] > timeTaken) {
                    dist2[adj] = dist1[adj];
                    dist1[adj] = timeTaken;
                    pq.offer(new int[]{adj, timeTaken});
                } else if(dist2[adj] > timeTaken && dist1[adj] != timeTaken) {
                    dist2[adj] = timeTaken;
                    pq.offer(new int[]{adj, timeTaken});
                }  
            }
        }
        return 0;
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        populateAdjacenylist(edges);
        initializePriorityQueue();
        initializeDistance(n);
        return modifiedDijkstra(n, edges, time, change);
    }
}